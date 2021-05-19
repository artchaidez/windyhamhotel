package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;


import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:8081")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;


    // get all reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    // get a single review
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable(value = "id") int reviewId) {
        //System.out.println("getReviewById");
        return this.reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
    }

    // add a review
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    // update a review
    @PutMapping("/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable(value = "id") int reviewId) {
        Review existingReview = this.reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        existingReview.setComment(review.getComment());
        existingReview.setDate(review.getDate());
        existingReview.setName(review.getName());
        existingReview.setRating(review.getRating());

        return this.reviewRepository.save(existingReview);
    }

    // delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable(value = "id") int reviewId) {
        Review existingReview = this.reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        this.reviewRepository.delete(existingReview);

        return ResponseEntity.ok().build();

    }
}
