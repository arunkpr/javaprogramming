package com.java.programs;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileOperationsTest {
    FileOperations fileOperations = new FileOperations();
    @Test
    public void arithmeticOperationTest() throws IOException {
        BufferedReader readInput;
        BufferedReader readOutput = null;

        try {
            readInput = new BufferedReader(new FileReader("input.txt"));
            fileOperations.validateFileInput(readInput);
            // Read output generated file
            readOutput = new BufferedReader(new FileReader("output.txt"));
            String line = readOutput.readLine();
            assertEquals("1+5*1=6.0", line);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readOutput.close();
        }
    }

    @Test(expected = Exception.class)
    public void arithmeticOperationThrowsException() throws IOException {
        fileOperations.validateFileInput(new BufferedReader(new FileReader("invalid.txt")));
    }
}