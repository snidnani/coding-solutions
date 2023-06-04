package com.investec.assessment.app;

import java.util.Scanner;
import java.util.stream.Stream;

/**
* author: snidnani
* Date: 2023/04/06
*/
public class  GreatestCommonDivisorApp {

   /**
    * array of integers provided as input, finds the greatest common divisor of the integers in the input
    *
    * @param numbers int[]
    * @return greatest common divisor
    */
   public int greatestCommonDivisor(final int[] numbers) {
       if(!validateInputData(numbers))
           throw new IllegalArgumentException("Please provide valid numbers");

       int result = numbers[0];
       for (int i = 1; i < numbers.length; i++) {
           result = calculateGCDUsingEuclid(numbers[i], result);
       }

       return result;
   }

   /**
    * Validates the input of numbers for null check and empty array
    * 
    * @param numbers int[]
    * @return boolean value true if input is valid
    */
   private boolean validateInputData(int[] numbers) {
       return numbers != null && numbers.length > 0;
   }
   
   /**
    * Calculates the greatest common divisor using Euclidean algorithm
    * 
    * @param integers a and b
    * @return greatest common divisor of a and b
    */
   private int calculateGCDUsingEuclid(final int a, final int b) {
	   if (b == 0) {
           return a;
       }
       return calculateGCDUsingEuclid(b, a % b);
   }
   
   /**
    * Processes string of integers to array of integers
    */
   private int[] processInputIntArray(final String numbers) {
       final String[] integers = numbers.split("\\s+");
       return Stream.of(integers)
               .mapToInt(Integer::parseInt)
               .toArray();
   }


   public static void main(String[] args) {
	   GreatestCommonDivisorApp divisor = new GreatestCommonDivisorApp();
       Scanner scanner = new Scanner(System.in);

       System.out.println("Please enter numbers you would like to find the greatest common divisor for (eg. 6 12 15): ");

       String numberString = scanner.nextLine();
       int[] numbers = divisor.processInputIntArray(numberString);

       System.out.printf("The Greatest Common Factor is %d", divisor.greatestCommonDivisor(numbers));
   }
}
