package com.example.demo.theater.moviereview;

import com.example.demo.logControll.LogController;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.movie.MovieNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/theater")
@CrossOrigin
public class MovieReviewController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String methodName;

    private LogController logController;

    @Autowired
    private MovieReviewDaoService service;

    @GetMapping("/MovieReview")
    public List<MovieReview> retrieveAllMovieReview() {
        return service.findAll();
    }

    @GetMapping("/MovieReview/{mrId}")
    public MovieReview retrieveMovieReview (@PathVariable Integer mrId){
        MovieReview movieReview = service.findById(mrId);

        if (movieReview==null) {
            throw new MovieNotFoundException(String.format("ID [%s] Not Found",mrId));
        }

        return movieReview;
    }

    @PostMapping("/MovieReview")
    public ResponseEntity<MovieReview> newReview(@RequestBody MovieReview newMovieReview){
        MovieReview insertMovieReview = service.findById(newMovieReview.getMovieReviewId());

        if (insertMovieReview == null) {
            service.save(newMovieReview);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newMovieReview.getMovieReviewId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }else {
            throw new MovieNotFoundException(String.format("ID [%s] already exist",insertMovieReview.getMovieReviewId()));
        }
    }

    @PutMapping("/MovieReview/{id}")
    public MovieReview replaceMovieReview ( @RequestBody MovieReview newMovieReview, @PathVariable Integer id) {
        MovieReview updateMovieReview = service.updateMovieReview(newMovieReview, id);

        if(updateMovieReview == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found", id));
        }

        return updateMovieReview;
    }

    @DeleteMapping("/MovieReview/{id}")
    public void deleteMovieReview(@PathVariable Integer id) {service.deleteMovieReview(id);}
}
