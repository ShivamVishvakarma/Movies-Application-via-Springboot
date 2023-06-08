package com.moviesApi.MoviesApp.service;

import com.moviesApi.MoviesApp.model.Movies;
import com.moviesApi.MoviesApp.model.Review;
import com.moviesApi.MoviesApp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody , String ImdbId)
    {
        Review review =reviewRepository.insert(new Review(reviewBody));



     mongoTemplate.update(Movies.class)
             .matching(Criteria.where("imdbid").is(ImdbId))
             .apply(new Update().push("reviewIds").value(review))
             .first();

     return review;

    }

}
