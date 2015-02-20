package com.y62wang.learn.utils;

import com.y62wang.learn.TestConstants;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.y62wang.learn.TestConstants.INTEGER_GENERATOR;

public class InputGeneratorTest {

    private File outputFile;

    @Before
    public void setUp() throws Exception {
        outputFile = new File(TestConstants.OUTPUT_DATA_FILE);
    }

    @Test
    @Ignore
    public void testWriteOneMillionGUIDsToFile() throws IOException {
        final InputWriter writer = new InputWriter(outputFile, INTEGER_GENERATOR);
        writer.writeFile(10000000);
    }
}