package com.bookshop.features.book.data;

import com.bookshop.features.book.data.entity.LanguageEntity;
import com.bookshop.features.book.data.jpa.LanguageJpaRepository;
import com.bookshop.features.book.domain.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LanguageRepositoryImpl implements LanguageRepository {

    private final LanguageJpaRepository languageJpaRepository;

    @Override
    public List<LanguageEntity> getLanguages() {
        return languageJpaRepository.findAll();
    }

    @Override
    public LanguageEntity saveLanguage(LanguageEntity language) {
        return languageJpaRepository.saveAndFlush(language);
    }

    @Override
    public Optional<LanguageEntity> getLanguageById(Integer id) {
        return languageJpaRepository.findById(id);
    }
}
