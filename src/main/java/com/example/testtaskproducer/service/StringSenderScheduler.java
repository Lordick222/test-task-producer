package com.example.testtaskproducer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StringSenderScheduler {

    private final StringGenerator stringGenerator;
    private final KafkaProducer kafkaProducer;

    @Value("${kafka-topic.strings-under-100}")
    private String stringsUnder100TopicName;

    @Value("${sheduled.strings-under-100}")
    private String stringSenderDelay;

    @Scheduled(fixedDelayString = "${sheduled.strings-under-100}")
    public void sendString() {
        var strToSend = stringGenerator.getRandomStrUnder100();
        kafkaProducer.send(stringsUnder100TopicName,strToSend);
    }


}
