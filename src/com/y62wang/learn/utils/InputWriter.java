package com.y62wang.learn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputWriter {
    private final File outputFile;
    private final InputGenerator inputGenerator;

    public InputWriter(final File outputFile, final InputGenerator inputGenerator) {
        this.outputFile = outputFile;
        this.inputGenerator = inputGenerator;
    }

    public void writeFile(final int numberOfLines) throws IOException {
        if(!outputFile.exists()) {
            outputFile.createNewFile();
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFile);
            for (int i = 0; i < numberOfLines; i++) {
                fileWriter.write(inputGenerator.next() + "\n");
            }
        } finally {
            if(fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
