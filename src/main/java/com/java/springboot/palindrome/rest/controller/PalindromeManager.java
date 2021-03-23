package com.java.springboot.palindrome.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility to manipulate palindrome numbers
 */
public class PalindromeManager {

    /**
     * Used internally in evaluatePalindromInRangeWithLambda with Lambda version.
     * @return
     */
    private static IntPredicate evaluatePalindrome() {
        return i -> {
            String numberString = Integer.toString(i);
            String numberBinaryString = Integer.toBinaryString(i);
            Boolean decimalNumberPalindrome = numberString.equals(new StringBuilder(numberString).reverse().toString());
            Boolean binaryNumberPalindrome = numberBinaryString.equals(new StringBuffer(numberBinaryString).reverse().toString());

            return decimalNumberPalindrome && binaryNumberPalindrome;
        };
    }

    /**
     * Given the string verifies if it is a palindrome
     *
     * @param s Data
     * @return True if palindrome
     */
    private boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    /**
     * Evaluates if the data contained which means if is a string representation of a number
     * and its binary representation is both palindromes.
     *
     * @param number Data to evaluate
     * @return True if the string number representation is palindrome and its binary number
     * representation is palindrome.
     */
    public boolean evaluateInfoPalindrome(Integer number) {
        return isPalindromeString(Integer.toString(number)) && isPalindromeString(Integer.toBinaryString(number));
    }

    /**
     * Returns a list of Palindrome Numbers (both decimal and binary number must be a palindrome).
     * The evaluation happens in the range x through y, and both x and y must be integer and x <= y.
     * <p>
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     * </p>
     * <p>
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     * </p>
     *
     * @param x Range start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    public List<PalindromeInfo> evaluatePalindromeInRange(Integer x, Integer y) {
        List<PalindromeInfo> palindromeInfoList = new ArrayList<PalindromeInfo>();

        boolean rangeStart = (x >= 1 && x <= 1000000);
        boolean rangeEnd = (x >= 1 && y <= 1000000);
        if (rangeStart && rangeEnd) {
            while (x <= y) {
                if (evaluateInfoPalindrome(x)) {
                    palindromeInfoList.add(new PalindromeInfo(Integer.toString(x), Integer.toBinaryString(x)));
                }
                x++;
            }
        }
        return palindromeInfoList;
    }

    /**
     * Returns a list of Palindrome Numbers (both deciman and binary number must be a palindrome).
     * The evaluation happens in the range x through y, and both x and y must be integer and x <= y.
     * <p>
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     * </p>
     * <p>
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     * </p>
     * <p>
     * <b>NOTE:</b> The internal implementation uses java 8 lambda expersions and collection streams.
     * </p>
     *
     * @param x Range start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    public List<PalindromeInfo> evaluatePalindromeInRangeWithLambda(Integer x, Integer y) {
        return IntStream.rangeClosed(x, y)
                .filter(evaluatePalindrome()).mapToObj(n -> new PalindromeInfo(Integer.toString(n), Integer.toBinaryString(n)))
                .collect(Collectors.toList());
    }
}
