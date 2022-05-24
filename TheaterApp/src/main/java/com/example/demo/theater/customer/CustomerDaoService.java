package com.example.demo.theater.customer;

import com.example.demo.theater.foodpayment.FoodPaymentRepository;
import com.example.demo.theater.reservation.ReservationRepository;
import com.google.gson.JsonParser;
import io.jsonwebtoken.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String secretKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoaSJ9.GY_JamNllFTbrZ1qd2LVM1CcKp45bHKYFnHkWELr__U";


    @Autowired
    private CustomerRepository repository;

    @Autowired
    private FoodPaymentRepository foodPaymentRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    //회원 영수증
    public List<Object> retrieveCustomerReceipt(String cId) {
        List<Object> Food = foodPaymentRepository.findCustomerPaymentOrderList2(cId);
        List<Object> Movie = reservationRepository.retrieveCustomerMovieList(cId);
        List<Object> result = new ArrayList<>();
        result.add(Food);
        result.add(Movie);
        return result;
    }


    public List<Customer> findAll() {
        return repository.findAll();
    }


    public Customer findById(String customerId) {
        Customer customer = repository.findByCustomerId(customerId);
        return customer;
    }

    //    로그인 하기위한 메소드
    public String checkedCustomer(String id, String passwd, HttpServletRequest request) {
        Customer customer1 = repository.findByCustomerId(id);

        if (id.equals(customer1.getCustomerId()) && passwd.equals(customer1.getC_Pw())) {
            String token = makeJwtToken(id, passwd);
            return token;
        } else {
            return "fail";
        }
    }

    // 토큰생성
    public static String makeJwtToken(String id, String passwd) {


        Date ext = new Date();

        Long expiredTime = 1000 * 60L * 60L * 2L; //2시간
        ext.setTime(ext.getTime() + expiredTime);

        Claims claims = Jwts.claims()
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(ext);
        claims.put("id", id);

        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();

        return jwt;
    }

    // 토큰 파서
    public String decodeToken(@RequestParam String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(token).getBody();

            return JsonParser.parseString(claims.toString()).toString();
        } catch (ExpiredJwtException e) {
            logger.error("Token Expired");
            return "fail";
        } catch (JwtException e) {
            logger.error("Token Error");
            return "fail";
        }

    }


    // 아이디 삭제
    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }

    public Customer save(Customer customer) {
        repository.save(customer);
        return customer;
    }

    //이미지 업로드
    public String uploadToLocal(String id, MultipartFile file) {
        try {
            String uploadFolderPath = "./src/main/resources/serverImage/profile/";
            String imageName = "profile" + id + ".jpeg";
            Customer customer = repository.findByCustomerId(id);
            File checkFile = new File(uploadFolderPath + imageName);
            Path path = Paths.get(uploadFolderPath + imageName);

            // 회원정보가 없을떄
            if (customer == null) {
                return "회원정보가 없음";
            }
            // 만약 이미지가 이미 있다면 삭제 하고 다시 넣기
            if (checkFile.exists()) {
                Files.delete(path);
            }


            byte[] data = file.getBytes();
            Files.write(path, data);


            // 여기까지는 이미지를 폴더에 저장함

            customer.setC_Profile(imageName);
            customer.setC_Profile_Path(uploadFolderPath);
            repository.save(customer);
            // 여기까지 디비에 이미지 이름과 경로 저장
            return "finish";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    // 이미지 가져오기

    public ResponseEntity<Resource> getImage(String id) throws IOException {

        Customer customer = repository.findByCustomerId(id);  // 회원 정보 가져오기
        String path = customer.getC_Profile_Path() + customer.getC_Profile(); //경로
        HttpHeaders headers = new HttpHeaders();
        Path filePath = Paths.get(path);
        Resource resource = (Resource) new FileSystemResource(path);
        if (path == null) {
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
        headers.add("Content-Type", Files.probeContentType(filePath));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

    }


    public Customer updateCustomer(Customer newCustomer, String id) {
        Customer customer = repository.findByCustomerId(id);

        if (customer == null) {
            return null;
        }

        customer.setC_Pw(newCustomer.getC_Pw());
        customer.setC_Name(newCustomer.getC_Name());
        customer.setC_Nikname(newCustomer.getC_Nikname());
        customer.setC_Phone(newCustomer.getC_Phone());
        customer.setC_Total(newCustomer.getC_Total());
        customer.setC_Address(newCustomer.getC_Address());
        customer.setC_Point(newCustomer.getC_Point());
        customer.setC_Profile(newCustomer.getC_Profile());

        Customer updateCustomer = repository.save(customer);

        return updateCustomer;
    }
}
