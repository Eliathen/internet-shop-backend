package com.bookshop.features.book.data;

import com.bookshop.features.book.data.entity.BookEntity;
import com.bookshop.features.book.data.jpa.BookJpaRepository;
import com.bookshop.features.book.domain.model.Book;
import com.bookshop.features.book.domain.repository.BookRepository;
import com.bookshop.features.book.exception.BookNotFound;
import com.bookshop.features.book.mapper.BookMapper;
import com.bookshop.features.opinion.data.entity.OpinionEntity;
import com.bookshop.features.opinion.domain.model.Opinion;
import com.bookshop.features.opinion.mapper.OpinionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository jpa;


    @Override
    public Book saveBook(Book book) {
        BookEntity bookToSave = BookMapper.mapToBookEntity(book);
        return BookMapper.mapToBook(jpa.saveAndFlush(bookToSave));
    }

    @Override
    public Book getBookById(Long id) {
        return BookMapper.mapToBook(jpa.getBookEntityById(id)
                .orElseThrow(() -> new BookNotFound(id))
        );
    }

    @Override
    public void saveOpinion(Long bookId, Opinion opinion) {
        BookEntity book = BookMapper.mapToBookEntity(getBookById(bookId));
        OpinionEntity opinionEntity = OpinionMapper.mapToOpinionEntity(opinion);
        opinionEntity.setBook(book);
        book.getOpinions().add(opinionEntity);
        jpa.saveAndFlush(book);
    }
}
