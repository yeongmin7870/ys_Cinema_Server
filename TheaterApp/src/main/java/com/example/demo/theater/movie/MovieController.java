package com.example.demo.theater.movie;


import com.example.demo.logControll.LogController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String methodName; // 메소드명 가져오기위한 변수

    private LogController logController;  // 찍는 이유는 여러가지 1. 악용자가 누군지 알기위한 방책, 2. 로그인 시 누가 어디서 로그인 했는지 알기위한 방책


    @Autowired
    private MovieDaoService service;

    //영화 이미지 한개만 가져오기
    @GetMapping("/movies/display")
    public ResponseEntity<Resource> getAllMovieImages(@RequestParam String id) throws IOException {
        return service.getAllMovieImages(id);
    }

    //영화 이미지 업로드
    @PutMapping("/movies/images/upload")
    public String movieIMageUpload(@RequestParam String id, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName(); //메소드 명 가져오기

        logger.info(methodName + " 서비스를 실행하였고 " + "IP는 " + logController.clientIp(request));

        return service.uploadToLocal(id, multipartFile);
    }


    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies() {
        return service.findAll();
    }

    @GetMapping("/movie/{movieid}")
    public Movie retrieveMovies(@PathVariable Integer movieId) {
        Movie movie = service.findById(movieId);

        if (movie == null) {
            throw new MovieNotFoundException(String.format("ID [%s] not found", movieId));
        }

        return movie;
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> newMovies(@RequestBody Movie newMovie) {

        Movie insertMovie = service.findById(newMovie.getMovieId());

        if (insertMovie == null) {
            service.save(newMovie);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newMovie.getMovieId())
                    .toUri();
            return ResponseEntity.created(location).build();
        } else {
            throw new MovieNotFoundException(String.format("ID [%s] already exist", insertMovie.getMovieId()));
        }
    }

}
