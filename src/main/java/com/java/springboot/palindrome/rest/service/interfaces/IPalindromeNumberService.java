package com.java.springboot.palindrome.rest.service.interfaces;

import com.java.springboot.palindrome.rest.controller.PalindromeInfo;

import java.util.List;

/**
 * Defines the interface service to evaluate palindrome numbers.
 *
 */
public interface IPalindromeNumberService {
    /**
     * Retrieves a list of palindrome numbers in range x and y.
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     * <p>
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     *
     * @param x Range Start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    List<PalindromeInfo> evaluateInRange(Integer x, Integer y);

    /**
     * Retrieves a list of palindrome numbers in range x and y.
     * Given a range of numbers in (x..y) where x <= y and valid integer values.
     * <p>
     * 1 <= x <= 1000000
     * 1 <= y <= 1000000
     * <p>
     * <p>
     * <b>NOTE:</b>Uses an internal method that computes elements using lambda expressions.
     * </p>
     *
     * @param x Range Start
     * @param y Range End
     * @return If x > y then an empty list is returned. If any parameter is
     * outside range then and empty list is returned as well.
     */
    List<PalindromeInfo> evaluateInRangeWithLambda(Integer x, Integer y);
}
