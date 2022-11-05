package com.project.demo;

import com.project.demo.model.VowelDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindVowelsTest
{
    protected static final String testString = getTestString();

    protected static String getTestString()
    {
        String str="Platon made bamboo boats.";
        return str;
    }

    protected List<VowelDto> expectedVowels(){
        List<VowelDto> result = new ArrayList<>();
        VowelDto platon =  new VowelDto("Platon", Arrays.asList('a','o'),2,3.0);
        VowelDto made =  new VowelDto("made", Arrays.asList('a','e'),2,2.0);
        VowelDto bamboo =  new VowelDto("bamboo", Arrays.asList('a','o'),3,3.0);
        VowelDto boats =  new VowelDto("boats.", Arrays.asList('o','a'),3,3.0);
        result.add(platon);
        result.add(made);
        result.add(bamboo);
        result.add(boats);
        return result;

    }
}
