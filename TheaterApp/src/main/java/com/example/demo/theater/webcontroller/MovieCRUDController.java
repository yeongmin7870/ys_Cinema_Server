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
    public String insert(Model model, @RequestParam("m_img") MultipartFile file, @RequestParam(required = false) Integer movieId) {
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
            repository.save(movie);
        } else {
            service.updateMovie(movie, movie.getMovieId());
        }

        return new RedirectView( "/movie/movieSelect");

    }

    @PostMapping("/movieDelete")
    @ApiOperation("영화삭제 페이지")
    public RedirectView delete(Model model) {

        model.addAttribute("movie", new Movie());
        return new RedirectView("movie/movieSelect");

    }
}
