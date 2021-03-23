package com.java.springboot.palindrome.rest.service;

import com.java.springboot.palindrome.rest.controller.PalindromeInfo;
import com.java.springboot.palindrome.rest.controller.PalindromeManager;
import com.java.springboot.palindrome.rest.service.interfaces.IPalindromeNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements a service to evaluate palindrome numbers
 *
 */
@Service
@SuppressWarnings("unused")
public class PalindromeNumberService implements IPalindromeNumberService {

    /* Helper to handle palindrome number tasks. */
    private PalindromeManager palindromeManager;

    /**
     * Default constructor.
     */
    public PalindromeNumberService() {
        palindromeManager = new PalindromeManager();
    }

    /**
     * @see com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService#evaluateInRange(Integer x, Integer y)
     */
    @Override
    public List<PalindromeInfo> evaluateInRange(Integer x, Integer y) {
        return palindromeManager.evaluatePalindromeInRange(x, y);
    }

    /**
     * @see com.csoftz.torre.palindrome.rest.service.interfaces.IPalindromeNumberService#evaluateInRangeWithLambda(Integer x, Integer y)
     */
    @Override
    public List<PalindromeInfo> evaluateInRangeWithLambda(Integer x, Integer y) {
        return palindromeManager.evaluatePalindromeInRangeWithLambda(x, y);
    }
}
