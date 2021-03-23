package com.java.springboot.palindrome.rest.controller;

import com.java.springboot.palindrome.rest.controller.PalindromeInfo;
import com.java.springboot.palindrome.rest.service.PalindromeValueContainer;
import com.java.springboot.palindrome.rest.service.interfaces.IPalindromeNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST API to evaluate palindrome numbers.
 * Given a range of numbers in (x..y) where x <= y and valid integer values.
 * <p>
 * 1 <= x <= 1000000
 * 1 <= y <= 1000000
 */
@RestController
@RequestMapping("/api/v1/palindrome/numbers")
@SuppressWarnings("unused")
public class PalindromeNumberController {

    /* Gets inyected by IoC. */
    private IPalindromeNumberService palindromeNumberService;

    /**
     * Constructor with parameter
     *
     * @param palindromeNumberService Service for palindrome numbers tasks.
     */
    public PalindromeNumberController(IPalindromeNumberService palindromeNumberService) {
        this.palindromeNumberService = palindromeNumberService;
    }

    /**
     * Retrieves all palindrome numbers between 1 and 1 million.
     *
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range")
    public PalindromeValueContainer range() {
        Integer x = 1;
        Integer y = 1000000;

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = y - x + 1;
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return palindromeValueContainer;
    }

    /**
     * Retrieves all palindrome numbers between 1 and 1 million.
     * <p><b>NOTE:</b>Uses the lambda version to compute results.</p>
     *
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/lambda")
    public PalindromeValueContainer rangeLambda() {
        Integer x = 1;
        Integer y = 1000000;

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRangeWithLambda(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = y - x + 1;
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return palindromeValueContainer;
    }

    /**
     * Retrieves all palindrome numbers from x to y. If x = y then it evaluates to one value.
     * Here x<=y and 1<=x<=1000000 and 1<=y<=1000000.
     *
     * @param start Gives the initial value to evaluate.
     * @param end   Gives the final value to evaluate.
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/{start}/{end}")
    public ResponseEntity<PalindromeValueContainer> range(@PathVariable String start, @PathVariable String end) {
        Integer x, y;
        boolean validInt;

        validInt = true;
        x = y = 0;
        try {
            x = Integer.parseInt(start);
            y = Integer.parseInt(end);
        } catch (Exception e) {
            validInt = false;
        }

        if (!validInt) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = 1;
        if (x <= y) {
            complexityTimes = y - x + 1;
        }
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return new ResponseEntity<>(palindromeValueContainer, HttpStatus.CREATED);
    }

    /**
     * Retrieves all palindrome numbers from x to y. If x = y then it evaluates to one value.
     * Here x<=y and 1<=x<=1000000 and 1<=y<=1000000.
     * <p>
     * <p><b>NOTE:</b>Uses the lambda version to compute results.</p>
     *
     * @param start Gives the initial value to evaluate.
     * @param end   Gives the final value to evaluate.
     * @return An object representing the desired output information for JSON serialization. The named object is of
     * type PalindromeValueContainer.
     */
    @GetMapping("/range/lambda/{start}/{end}")
    public ResponseEntity<PalindromeValueContainer> rangeLambda(@PathVariable String start, @PathVariable String end) {
        Integer x, y;
        boolean validInt;

        validInt = true;
        x = y = 0;
        try {
            x = Integer.parseInt(start);
            y = Integer.parseInt(end);
        } catch (Exception e) {
            validInt = false;
        }

        if (!validInt) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        PalindromeValueContainer palindromeValueContainer = new PalindromeValueContainer();
        palindromeValueContainer.setX(x);
        palindromeValueContainer.setY(y);

        List<PalindromeInfo> infoList = palindromeNumberService.evaluateInRange(x, y);
        palindromeValueContainer.setPalindromes(infoList);
        palindromeValueContainer.setNumOfPalindromes(infoList.size());

        Integer complexityTimes = 1;
        if (x <= y) {
            complexityTimes = y - x + 1;
        }
        palindromeValueContainer.setComplexity("O(n)=O(y-x) = O(" + complexityTimes + ")");
        return new ResponseEntity<>(palindromeValueContainer, HttpStatus.CREATED);
    }
    
    /**
     * Verifies the given input string for longest available palindrome
     * 
     * @param Random string to check longest palindrome in the given input string
     * @return palindrome string.
     */
    @GetMapping("/{inputstring}")
    public String longestPalindrome(@PathVariable String inputstring) {
        if (inputstring == null || inputstring.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < inputstring.length(); i++) {
            int len1 = expandAroundCenter(inputstring, i, i);
            int len2 = expandAroundCenter(inputstring, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return inputstring.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
