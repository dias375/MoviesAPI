package dev.dias375.MoviesAPI.service;

import dev.dias375.MoviesAPI.model.Movie;
import dev.dias375.MoviesAPI.model.Review;
import dev.dias375.MoviesAPI.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public Review createNewReview(String body, String imdbId){
        return null;
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = new Review(reviewBody);
        reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where(imdbId).is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
