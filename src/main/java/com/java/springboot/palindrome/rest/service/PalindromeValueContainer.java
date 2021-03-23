package com.java.springboot.palindrome.rest.service;

import java.util.ArrayList;
import java.util.List;

import com.java.springboot.palindrome.rest.controller.PalindromeInfo;

/**
 * Keeps information about evaluated number range to evaluate
 * if there are palindromes in there.
 *
 * The rule to observe is that both then number and is binary representation must
 * be palindromes, e.g. num=585 is palindrome and its binary representation is
 * 1001001001 which is also palindrome. But the num=111 is palindrome but
 * its binary representation 1101111 is not.
 */
public class PalindromeValueContainer {
    private Integer x;
    private Integer y;
    private List<PalindromeInfo> palindromes;
    private Integer numOfPalindromes;
    private String complexity;

    public PalindromeValueContainer() {
        this.x = 0;
        this.y = 0;
        this.palindromes = new ArrayList<PalindromeInfo>();
        this.numOfPalindromes = 0;
        this.complexity = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalindromeValueContainer that = (PalindromeValueContainer) o;

        if (!x.equals(that.x)) return false;
        if (!y.equals(that.y)) return false;
        if (!palindromes.equals(that.palindromes)) return false;
        if (!numOfPalindromes.equals(that.numOfPalindromes)) return false;
        return complexity.equals(that.complexity);
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        result = 31 * result + palindromes.hashCode();
        result = 31 * result + numOfPalindromes.hashCode();
        result = 31 * result + complexity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PalindromeValueContainer{" +
                "x=" + x +
                ", y=" + y +
                ", palindromes=" + palindromes +
                ", numOfPalindromes=" + numOfPalindromes +
                ", complexity='" + complexity + '\'' +
                '}';
    }

    public String getComplexity() {

        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public List<PalindromeInfo> getPalindromes() {
        return palindromes;
    }

    public void setPalindromes(List<PalindromeInfo> palindromes) {
        this.palindromes = palindromes;
    }

    public Integer getNumOfPalindromes() {

        return numOfPalindromes;
    }

    public void setNumOfPalindromes(Integer numOfPalindromes) {
        this.numOfPalindromes = numOfPalindromes;
    }

}
