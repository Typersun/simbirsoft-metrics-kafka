package ru.typersun.simbirsoftmetrics.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.typersun.simbirsoftmetrics.dto.MessageDto;
import ru.typersun.simbirsoftmetrics.models.UniqueWords;
import ru.typersun.simbirsoftmetrics.repository.UniqueWordsRepository;
import ru.typersun.simbirsoftmetrics.services.UniqueWordsService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UniqueWordsServiceImpl implements UniqueWordsService {

    private final UniqueWordsRepository uniqueWordsRepository;
    @Override
    public void saveUniqueWords(MessageDto messageDto) {
        String[] uniqueWords = messageDto.getMessage().split(" ");
        for (String word : uniqueWords) {
            Optional<UniqueWords> uniqueWordsOptional =
                    uniqueWordsRepository.findByWordAndAuthor(word, messageDto.getAuthor());
            if (uniqueWordsOptional.isEmpty()) {
                uniqueWordsRepository.save(UniqueWords.builder()
                        .word(word)
                        .author(messageDto.getAuthor())
                        .count(1)
                        .build());
            } else {
                UniqueWords uniqueWordToUpdate = uniqueWordsOptional.get();
                uniqueWordToUpdate.setCount(uniqueWordToUpdate.getCount() + 1);
                uniqueWordsRepository.save(uniqueWordToUpdate);
            }
        }
    }
}
