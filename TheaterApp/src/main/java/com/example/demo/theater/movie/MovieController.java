package com.example.demo.theater.movie;


import com.example.demo.logControll.LogController;
import com.google.gson.JsonObject;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String methodName; // 메소드명 가져오기위한 변수

    private LogController logController;
    // 찍는 이유는 여러가지 1. 악용자가 누군지 알기위한 방책, 2. 로그인 시 누가 어디서 로그인 했는지 알기위한 방책


    @Autowired
    private MovieDaoService service;






    // 영화 비디오 저장
    @PutMapping("/movie/video")
    @ApiOperation(value = "영화 비디오 저장")
    public String saveMovieVideo(Integer id, MultipartFile multipartFile) {
        return service.saveMovieVideo(id,multipartFile);
    }

    @GetMapping("/movie/video/display/{id}")
    @ApiOperation(value = "영화 비디오 한개만 불러오기")
    public ResponseEntity<Resource> getMovieVideo(@PathVariable Integer id) throws  IOException{
        return service.getMovieVideo(id);
    }


    // 영화 이미지 전체 uri 뽑아오기
    @GetMapping(value = "/movies/display")
    @ApiOperation(value = "영화 이미지 전체 uri 뽑아오기")
    public String[] getMoviesImages() throws IOException {

        return service.getMoviesImages();
    }


    //영화 이미지 한개만 가져오기
    @GetMapping("/movie/display/{id}")
    @ApiOperation(value = "영화 이미지 한개 출력", notes = "영화 이미지 한개만 출력하는 기능이다.")
    // 이걸 써주면 클라이언트 측에서 swagger-ui.html 문서로 확인할떄 편함
    public ResponseEntity<Resource> getMovieImage(@PathVariable Integer id) throws IOException {
        return service.getMovieImage(id);
    }

    //영화 이미지 업로드
    @PutMapping("/movies/images/upload")
    @ApiOperation(value = "영화 이미지 업로드", notes = "영화 이미지 업로드 기능이다.")
    public String movieIMageUpload(@RequestParam Integer id, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName(); //메소드 명 가져오기

        logger.info(methodName + " 서비스를 실행하였고 " + "IP는 " + logController.clientIp(request));

        return service.uploadToLocal(id, multipartFile);
    }


    @GetMapping("/movies")
    @ApiOperation(value = "영화 전체 정보 리스트", notes = "영화 전체 정보 리스트를 뽑아온다.")
    public List<Movie> retrieveAllMovies() {
        return service.findAll();
    }

    @GetMapping("/movie/{movieId}")
    @ApiOperation(value = "영화 한개 정보 가져오기", notes = "영화 한개 정보 가져온다.")
    public Movie retrieveMovies(@PathVariable Integer movieId) {
        Movie movie = service.findById(movieId);

        if (movie == null) {
            throw new MovieNotFoundException(String.format("ID [%s] not found", movieId));
        }

        return movie;
    }


    @PostMapping("/movies")
    @ApiOperation(value = "영화 정보 삽입", notes = "영화 정보 삽입하는 기능이다.")
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

    @DeleteMapping("/movies/{id}")
    @ApiOperation(value = "영화 삭제하기")
    public void deleteMovie(@PathVariable Integer id) {
        service.deleteMovie(id);
    }

    @PutMapping("/movies/{id}")
    @ApiOperation(value = "영화 정보 수정하기")
    public Movie replaceMovies(@RequestBody Movie newMovie,
                               @PathVariable Integer id) {

        Movie updateMovie = service.updateMovie(newMovie, id);

        if (updateMovie == null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found", id));
        }

        return updateMovie;
    }

}
