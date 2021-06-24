package ru.typersun.simbirsoftmetrics.services;

import ru.typersun.simbirsoftmetrics.dto.MessageDto;

import java.util.List;

public interface UniqueWordsService {
    void saveUniqueWords(MessageDto messageDto);
}
