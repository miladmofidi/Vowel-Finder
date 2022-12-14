package com.project.demo.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public final class VowelDto
{
    @NotNull
    private String word;
    private List<Character> vowelLetters;
    private int vowelsCounter = 0;
    private double average = 0;

    public VowelDto()
    {
    }

    public VowelDto(String word, List<Character> vowelLetters, int vowelsCounter, double average)
    {
        this.word = word;
        this.vowelLetters = vowelLetters;
        this.vowelsCounter = vowelsCounter;
        this.average = average;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    public List<Character> getVowelLetters()
    {
        return vowelLetters;
    }

    public void setVowelLetters(List<Character> vowelLetters)
    {
        this.vowelLetters = vowelLetters;
    }

    public int getVowelsCounter()
    {
        return vowelsCounter;
    }

    public void setVowelsCounter(int vowelsCounter)
    {
        this.vowelsCounter = vowelsCounter;
    }

    public double getAverage()
    {
        return average;
    }

    public void setAverage(double average)
    {
        this.average = average;
    }

    public int counterAdder()
    {
        return vowelsCounter++;
    }

    public void avgCalculator()
    {
        average = BigDecimal.valueOf((double) word.length() / (double) vowelLetters.size())
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString()
    {
        return "VowelModel{" +
               "word='" + word + '\'' +
               ", vowelLetters=" + vowelLetters +
               ", vowelsCounter=" + vowelsCounter +
               ", average=" + average +
               '}';
    }
}
