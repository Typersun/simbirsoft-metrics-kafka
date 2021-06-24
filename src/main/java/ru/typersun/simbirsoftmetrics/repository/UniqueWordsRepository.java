package ru.typersun.simbirsoftmetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.typersun.simbirsoftmetrics.models.UniqueWords;

import java.util.Optional;

public interface UniqueWordsRepository extends JpaRepository<UniqueWords, Long> {
    Optional<UniqueWords> findByWordAndAuthor(String word, String author);
}
