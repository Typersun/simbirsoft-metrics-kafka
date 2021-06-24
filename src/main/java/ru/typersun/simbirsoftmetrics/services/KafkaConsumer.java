package ru.typersun.simbirsoftmetrics.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.typersun.simbirsoftmetrics.dto.MessageDto;

@Service
@AllArgsConstructor
public class KafkaConsumer {
    private final UniqueWordsService uniqueWordsService;
    @KafkaListener(topics = "metrics_messages", groupId = "metrics", containerFactory = "greetingKafkaListenerContainerFactory")
    public void getMessage(MessageDto message) {
        uniqueWordsService.saveUniqueWords(message);
    }
}
