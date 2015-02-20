package com.y62wang.learn;

import com.y62wang.learn.utils.InputGenerator;

import java.util.Random;
import java.util.UUID;

public class TestConstants {
    public static final String OUTPUT_DATA_FILE = "/workplace/test-data/output.txt";

    public static final InputGenerator GUID_GENERATOR = new InputGenerator() {
        @Override
        public String next() {
            return UUID.randomUUID().toString();
        }
    };

    public static final InputGenerator WORD_GENERATOR = new InputGenerator() {
        private final Random random = new Random();
        private static final int ALPHABET_SIZE = 26;
        private static final char STARTING_CHARACTER = 'a';

        @Override
        public String next() {
            final int wordLength = 3 + random.nextInt(15);
            final char[] chars = new char[wordLength];
            for(int i=0;i<wordLength;i++) {
                chars[i] = (char)(STARTING_CHARACTER + random.nextInt(ALPHABET_SIZE));
            }
            return String.valueOf(chars);
        }
    };

    public static final InputGenerator INTEGER_GENERATOR = new InputGenerator() {
        private final Random random = new Random();
        @Override
        public String next() {
            return Integer.toString(random.nextInt(Integer.MAX_VALUE));
        }
    };

    public static final InputGenerator BINARY_GENERATOR = new InputGenerator() {
        private final Random random = new Random();
        @Override
        public String next() {
            return Integer.toString(random.nextInt(Integer.MAX_VALUE), 2);
        }
    };
}
