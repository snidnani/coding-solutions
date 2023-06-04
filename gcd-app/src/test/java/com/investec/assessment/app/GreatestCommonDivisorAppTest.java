package com.investec.assessment.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for GreatestCommonDivisorApp for null input and positive scenarios.
 */
public class GreatestCommonDivisorAppTest 
    
{
	private GreatestCommonDivisorApp divisor;

    @BeforeEach
    void init() {
        divisor = new GreatestCommonDivisorApp();
    }

    @Test
    @DisplayName("Null Input")
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> divisor.greatestCommonDivisor(null),
                "Null input should not be allowed");
    }

    @Test
    @DisplayName("Positive Test")
    void testGreatestCommonDivisor() {
        assertAll(               
                () -> assertEquals(5, divisor.greatestCommonDivisor(new int[] {5})),
                () -> assertEquals(1, divisor.greatestCommonDivisor(new int[] {8, 13})),
                () -> assertEquals(1, divisor.greatestCommonDivisor(new int[] {0, 1})),
                () -> assertEquals(6, divisor.greatestCommonDivisor(new int[] {6, 12})),
                () -> assertEquals(2, divisor.greatestCommonDivisor(new int[] {2, 4, 6})),
                () -> assertEquals(3, divisor.greatestCommonDivisor(new int[] {6, 12, 27, 36, 45}))
        );
    }
}
