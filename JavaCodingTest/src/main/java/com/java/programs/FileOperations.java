package com.java.programs;

import com.java.programs.ArithmeticOperation;
import com.java.programs.ResponseObject;

import java.io.*;

public class FileOperations {
    ArithmeticOperation arithmeticOperation = new ArithmeticOperation();

    /**
     * File operations: reading input file and writing output to new file
     * @param reader reader buffered with input text file
     * @throws IOException
     */
    public  void validateFileInput (BufferedReader reader) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        try {
            String line = reader.readLine();
            while (line != null) {
                ResponseObject response = arithmeticOperation.inputValidation(line);
                if (response.getErrorMessage().equalsIgnoreCase("")) {
                    writer.write(line + "=" + response.getTotal());
                } else {
                    if (!line.contains("=")) {
                        writer.write(line + "=" + response.getErrorMessage());
                    } else {
                        writer.write(line);
                    }
                }
                writer.newLine();
                line = reader.readLine();
            }
        } finally {
            writer.close();
            reader.close();
        }
    }
}
