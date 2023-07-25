package dev.dias375.MoviesAPI.repository;

import dev.dias375.MoviesAPI.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
