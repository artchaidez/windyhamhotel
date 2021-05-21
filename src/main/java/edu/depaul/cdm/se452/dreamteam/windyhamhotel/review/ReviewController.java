package edu.depaul.cdm.se452.dreamteam.windyhamhotel.review;


import edu.depaul.cdm.se452.dreamteam.windyhamhotel.exception.ResourceNotFoundException;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.Room;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.room.RoomRepository;
import edu.depaul.cdm.se452.dreamteam.windyhamhotel.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping("/api/reviews")
////@CrossOrigin(origins = "http://localhost:8081")
//public class ReviewController {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//
//    // get all reviews
//    @GetMapping
//    public List<Review> getAllReviews() {
//        return this.reviewRepository.findAll();
//    }
//
//    // get a single review
//    @GetMapping("/{id}")
//    public Review getReviewById(@PathVariable(value = "id") int reviewId) {
//        //System.out.println("getReviewById");
//        return this.reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
//    }
//
//    // add a review
//    @PostMapping
//    public Review createReview(@RequestBody Review review) {
//        return this.reviewRepository.save(review);
//    }
//
//    // update a review
//    @PutMapping("/{id}")
//    public Review updateReview(@RequestBody Review review, @PathVariable(value = "id") int reviewId) {
//        Review existingReview = this.reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
//
//        existingReview.setComment(review.getComment());
//        existingReview.setDate(review.getDate());
//        existingReview.setName(review.getName());
//        existingReview.setRating(review.getRating());
//
//        return this.reviewRepository.save(existingReview);
//    }
//
//    // delete a review
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Review> deleteReview(@PathVariable(value = "id") int reviewId) {
//        Review existingReview = this.reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
//
//        this.reviewRepository.delete(existingReview);
//
//        return ResponseEntity.ok().build();
//
//    }
//}


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
        //review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
        return reviewRepository.save(review);
    }


    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@ Valid @RequestBody Review review, @PathVariable ("id") Long reviewId)
            throws ResourceNotFoundException {
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + reviewId));

        existingReview.setName(review.getName());
        existingReview.setComment(review.getComment());
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
