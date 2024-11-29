package com.book_review.BookReview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.book_review.BookReview.entity.BookReview;
import com.book_review.BookReview.repository.BookReviewRepository;

@Service
public class BookReviewServiceImpl implements BookReviewService{

	@Autowired
	private BookReviewRepository bookReviewRepository;
	
	@Override
	public BookReview insertBookReview(BookReview review) {
		BookReview reviewSaved = bookReviewRepository.save(review);
		return reviewSaved;
	}

	@Override
	public List<BookReview> getAllReviews() {
		return bookReviewRepository.findAll();
	}
	
	

	@Override
	public BookReview updateReview(Long id, BookReview updatedReview) {
		BookReview existingReview = bookReviewRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
		
		existingReview.setBookTitle(updatedReview.getBookTitle());
	    existingReview.setAuthor(updatedReview.getAuthor());
	    existingReview.setRating(updatedReview.getRating());
	    existingReview.setReviewText(updatedReview.getReviewText());

	    return bookReviewRepository.save(existingReview);
	}

	@Override
	public void deleteReview(Long id) {
		if (!bookReviewRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "review not found");
        }
		bookReviewRepository.deleteById(id);
		
	}

	@Override
	public BookReview getReviewById(Long id) {
		return bookReviewRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "review not found"));
	}

}
