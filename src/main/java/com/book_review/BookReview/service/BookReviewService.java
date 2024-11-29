package com.book_review.BookReview.service;

import java.util.List;

import com.book_review.BookReview.entity.BookReview;

public interface BookReviewService {

	BookReview insertBookReview(BookReview review);

	List<BookReview> getAllReviews();

	BookReview updateReview(Long id, BookReview updatedReview);

	void deleteReview(Long id);

	BookReview getReviewById(Long id);

}
