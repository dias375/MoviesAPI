package dev.dias375.MoviesAPI.controller;

import com.google.gson.Gson;
import dev.dias375.MoviesAPI.model.Review;
import dev.dias375.MoviesAPI.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    @PostMapping
//    public ResponseEntity<Review> createReview(@RequestBody Review payload){
//        Gson gson = new Gson();
//        Review review = gson.fromJson(String.valueOf(payload), Review.class);
//        return new ResponseEntity<>(reviewService.createReview(review.getBody(), review.getId().toString()), HttpStatus.CREATED);
//    }

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

}
