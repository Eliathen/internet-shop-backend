package com.bookshop.features.book.data;

import com.bookshop.features.book.data.entity.AuthorEntity;
import com.bookshop.features.book.data.jpa.AuthorJpaRepository;
import com.bookshop.features.book.domain.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorJpaRepository jpa;

    @Override
    public AuthorEntity getAuthorByNameAndSurnameOrSave(String name, String surname) {
        return jpa.findFirstByNameIgnoreCaseAndSurnameIgnoreCase(name, surname)
                .orElseGet(() -> jpa.saveAndFlush(AuthorEntity.builder()
                        .name(name)
                        .surname(surname)
                        .build()));
    }

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        return jpa.saveAndFlush(author);
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(Integer id) {
        return jpa.findById(id);
    }
}
