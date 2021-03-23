package com.java.springboot.palindrome.rest.controller;

/**
 * Given an integer number, stores the string representation
 * out of it as well its binary representation.
 */
public class PalindromeInfo {
    private String number;
    private String numberAsBinary;

    /**
     * Default constructor
     */
    public PalindromeInfo() {
    }

    /**
     * Constructor with parameters
     * @param number
     * @param numberAsBinary
     */
    public PalindromeInfo(String number, String numberAsBinary) {
        this.number = number;
        this.numberAsBinary = numberAsBinary;
    }

    /**
     * Return number
     * @return number to return
     */
    public String getNumber() {
        return number;
    }

    /**
     * Assign number
     * @param number to assign
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Number representation as binary.
     * @return String with binary representation of number.
     */
    public String getNumberAsBinary() {
        return numberAsBinary;
    }

    /**
     * Assign the number as string binary representation.
     * @param numberAsBinary Number to set.
     */
    public void setNumberAsBinary(String numberAsBinary) {
        this.numberAsBinary = numberAsBinary;
    }

    /**
     * Print object representation.
     * @return
     */
    @Override
    public String toString() {
        return "PalindromeInfo{" +
                "number='" + number + '\'' +
                ", numberAsBinary='" + numberAsBinary + '\'' +
                '}';
    }
}
