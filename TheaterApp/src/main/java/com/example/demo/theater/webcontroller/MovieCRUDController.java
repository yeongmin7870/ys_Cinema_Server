package com.example.demo.theater.webcontroller;

import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.movie.MovieDaoService;
import com.example.demo.theater.movie.MovieRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieCRUDController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MovieRepository repository;

    @Autowired
    private MovieDaoService service;

    @GetMapping("/movieSelect")
    @ApiOperation("회원정보검색 페이지")
    public String select(Model model) {
        List<Movie> movie = repository.findAll();;
        model.addAttribute("movie", movie);
        return "movie/movieSelect";
    }

    @GetMapping("/movieInsert")
    @ApiOperation("영화등록 페이지")
    public String insert(Model model, @RequestParam(required = false) Integer movieId) {
        if (movieId == null) {
            model.addAttribute("movie", new Movie());
        } else {
            Movie movie = repository.findById(movieId).orElse(null);
            model.addAttribute("movie", movie);
        }
        return "movie/movieInsert";
    }

    @PostMapping("/movieInsert")
    @ApiOperation("영화등록")
    public RedirectView insertForm(@ModelAttribute Movie movie) {
        if(movie.getMovieId() == null) {
            service.save(movie);
        } else {
            logger.info("영화를 수정합니다.");
            service.updateMovie(movie, movie.getMovieId());
        }

        return new RedirectView( "/movie/movieSelect");

    }

    @GetMapping("/movieImage")
    @ApiOperation("영화 이미지 등록 페이지")
    public String image(Model model, @RequestParam(required = false) Integer movieId){
        if (movieId == null) {
            model.addAttribute("movie", new Movie());
            logger.info("아이디 값이 null입니다.");
        } else {
            logger.info("아이디 값이 null이 아닙니다.");
            Movie movie = repository.findById(movieId).orElse(null);
            model.addAttribute("movie", movie);
        }
        return "movie/movieImage";
    }

    @PostMapping("/movieImage")
    @ApiOperation("영화 이미지 등록")
    public RedirectView upload(@ModelAttribute Movie movie, @RequestParam("file") MultipartFile file) {
        if (movie.getMovieId() == null) {
            logger.info("값: " + movie.getMovieId() + ", " + file);
            return  new RedirectView("movie/movieSelect");
        } else {
            logger.info("아이디 값이 정확하게 전달 되었습니다.");
            service.uploadToLocal(movie.getMovieId(), file);
        }
        return new RedirectView("/");
    }
    //
}
