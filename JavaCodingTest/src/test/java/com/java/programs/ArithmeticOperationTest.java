package com.java.programs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArithmeticOperationTest {
    private static final double DELTA = 1e-15;
    ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
    @Test
    public void testArithmeticOperation() {
        double total = arithmeticOperation.arithmeticOperation("3/6*100-1");
        assertEquals(49.0, total, DELTA);

        double total_1 = arithmeticOperation.arithmeticOperation("21-4+5");
        assertEquals(22.0, total_1, DELTA);

        double total_2 = arithmeticOperation.arithmeticOperation("2*2+1-1");
        assertEquals(4.0, total_2, DELTA);

        double total_3 = arithmeticOperation.arithmeticOperation("1+5*1");
        assertEquals(6.0, total_3, DELTA);
    }

    @Test
    public void testInputValidation() {
        ResponseObject responseObject = arithmeticOperation.inputValidation("3/6*100-1");
        assertEquals("3/6*100-1", responseObject.getInput());
        assertEquals("", responseObject.getErrorMessage());
        assertEquals(49.0, responseObject.getTotal(), DELTA);
    }



}