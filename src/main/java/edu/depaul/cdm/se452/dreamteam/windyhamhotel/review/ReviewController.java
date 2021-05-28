package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;

import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:8081")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping
    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));

        return ResponseEntity.ok().body(review);

    }

    @PostMapping
    public Review createReview(@Valid @RequestBody Review review) {
        review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
        return reviewRepository.save(review);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@ Valid @RequestBody Review review, @PathVariable ("id") Long reviewId)
            throws ResourceNotFoundException {
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + reviewId));

        existingReview.setName(review.getName());
        existingReview.setComment(review.getComment());
        existingReview.setDate(review.getDate());
        existingReview.setRating(review.getRating());
        final Review updatedReview = reviewRepository.save(existingReview);
        return ResponseEntity.ok(updatedReview);

    }

    @DeleteMapping("/{id}")
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
