package com.example.demo.theater.movie;

import com.example.demo.logControll.LogController;
import com.example.demo.theater.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class MovieDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private static final

    @Autowired
    private MovieRepository movieRepository;








    // 영화 이미지 한개만 가져오기
    public ResponseEntity<Resource> getMovieImage(String id) throws IOException {

        Movie movie = movieRepository.findByMovieId(Integer.valueOf(id));  // 회원 정보 가져오기
        String path = movie.getM_ImagePath() + movie.getM_Img(); //경로
        HttpHeaders headers = new HttpHeaders();
        Path filePath = Paths.get(path);
        Resource resource = (Resource) new FileSystemResource(path);
        if (path == null) {
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
        }
        headers.add("Content-Type", Files.probeContentType(filePath));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    //현재 상영작 이미지 업로드
    public String uploadToLocal(String id, MultipartFile file) {
        try {
            String uploadFolderPath = "./src/main/resources/serverImage/movieImage/";

            Movie movie = movieRepository.findByMovieId(Integer.valueOf(id));

            // 회원정보가 없을떄
            if (movie == null) {
                return "fail";
            }


            // 이미지를 변경할떄 기존이미지 삭제
            if (movie.getM_ImagePath() != null) {
                Files.delete(Path.of(movie.getM_ImagePath() + movie.getM_Img()));
            }


            File folder = new File(uploadFolderPath);

            if (!folder.exists()) {
                try {
                    folder.mkdir();
                    logger.info("폴더가 생성되었습니다.");
                } catch (Exception e) {
                    e.getStackTrace();
                }
            } else {
                logger.info("이미 폴더가 생성되어 있습니다.");
            }
            //여기까지는 디렉토리 유무 확인 후 생성


            LocalTime time = LocalTime.now();
            byte[] data = file.getBytes();
            String fileName = id + LocalDate.now() + time.getHour() + time.getMinute() + time.getSecond() + ".jpeg";
            Path path = Paths.get(uploadFolderPath + fileName);
            Files.write(path, data);
            // 여기까지는 이미지를 폴더에 저장함


            movie.setM_Img(fileName);
            movie.setM_ImagePath(uploadFolderPath);
            movieRepository.save(movie);
            // 여기까지 디비에 이미지 이름과 경로 저장
            return "finish";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }


    //영화 전체 출력
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    //ID값으로 해당 영화 검색
    public Movie findById(Integer m_No) {
        Movie movie = movieRepository.findByMovieId(m_No);
        return movie;
    }

    //영화 입력
    public Movie save(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    //영화 삭제
    public void deleteMovie(Integer id) {movieRepository.deleteById(id);}


    //영화 수정
    public Movie updateMovie(Movie newMovie, Integer id) {
        Movie movie = movieRepository.findByMovieId(id);

        if (movie == null) {
            return null;
        }
        movie.setM_Actors(newMovie.getM_Actors());
        movie.setM_Actor2(newMovie.getM_Actor2());
        movie.setM_Actor3(newMovie.getM_Actor3());
        movie.setM_Img(newMovie.getM_Img());
        movie.setM_ImagePath(newMovie.getM_ImagePath());
        movie.setM_Categories(newMovie.getM_Categories());
        movie.setM_Name(newMovie.getM_Name());
        movie.setM_Content(newMovie.getM_Content());
        movie.setM_Director(newMovie.getM_Director());
        movie.setM_StarScore(newMovie.getM_StarScore());
        movie.setM_Rating(newMovie.getM_Rating());
        movie.setM_Hour(newMovie.getM_Hour());
        movie.setM_StartDate(newMovie.getM_StartDate());
        movie.setM_EndDate(newMovie.getM_EndDate());

        Movie updateMovie = movieRepository.save(movie);

        return updateMovie;
    }
}
