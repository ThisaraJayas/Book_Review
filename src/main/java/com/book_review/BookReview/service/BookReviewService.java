package com.book_review.BookReview.service;

import java.util.List;

import com.book_review.BookReview.entity.BookReview;

public interface BookReviewService {

	BookReview insertBookReview(BookReview review);

	List<BookReview> getAllReviews();

	BookReview updateReview(Integer id, BookReview updatedReview);

	void deleteReview(Integer id);

}
