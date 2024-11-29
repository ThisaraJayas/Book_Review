package com.book_review.BookReview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book_review.BookReview.entity.BookReview;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Integer>{

}
