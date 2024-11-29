package com.book_review.BookReview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book_review.BookReview.entity.BookReview;
import com.book_review.BookReview.service.BookReviewService;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class BookReviewController {
	
	@Autowired
	private BookReviewService bookReviewService;
	
	@PostMapping
	public BookReview createReview(@RequestBody BookReview review) {
        return bookReviewService.insertBookReview(review);
    }
	
	@GetMapping
    public List<BookReview> getAllReviews() {
        return bookReviewService.getAllReviews();
    }
	@GetMapping("/{id}")
    public BookReview getReviewById(@PathVariable Long id) {
        return bookReviewService.getReviewById(id);
    }
	
	@PutMapping("/{id}")
	public BookReview updateReview(@PathVariable Long id, @RequestBody BookReview updatedReview) {
	    return bookReviewService.updateReview(id, updatedReview);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReview(@PathVariable Long id) {
		bookReviewService.deleteReview(id);
	 }

	
}
