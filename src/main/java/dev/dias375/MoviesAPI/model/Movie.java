package dev.dias375.MoviesAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;
    private String title, releaseDate, trailerLink, poster;

    private List<String> genres, backdrops;
    @DocumentReference
    private List<Review> reviewsIds;
}
