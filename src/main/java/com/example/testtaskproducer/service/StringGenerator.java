package com.example.testtaskproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringGenerator {

    private static final int STRING_SIZE = 100;
    private static final boolean USE_LETTERS = true;
    private static final boolean USE_NUMBERS = true;

    public String getRandomStrUnder100() {
        var generatedString = RandomStringUtils.random(STRING_SIZE, USE_LETTERS, USE_NUMBERS);
        log.debug("Generated str: {}", generatedString);
        return generatedString;
    }

}
