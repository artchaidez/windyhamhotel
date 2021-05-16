package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId) 
    throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
        .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        return ResponseEntity.ok().body(review);

    }

    @PostMapping("/reviews")
    public Review createReview(@Valid @RequestBody Review review) {
        review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
        return reviewRepository.save(review);
    }


    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@ Valid @RequestBody Review review, @PathVariable ("id") Long reviewId)
    throws ResourceNotFoundException {
        Review existingReview = reviewRepository.findById(reviewId)
        .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + reviewId));

        existingReview.setName(review.getName());
        existingReview.setReview(review.getReview());
        existingReview.setDate(review.getDate());
        final Review updatedReview = reviewRepository.save(review);
        return ResponseEntity.ok(updatedReview);

    }

    @DeleteMapping("/reviews/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable ("id") Long reviewId) 
    throws ReflectiveOperationException {

        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + reviewId));

        reviewRepository.delete(existingReview);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
