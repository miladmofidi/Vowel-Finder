package com.project.demo.service.impl;


import com.project.demo.model.VowelDto;
import com.project.demo.service.abstraction.FindVowelsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.demo.util.constant.AppConstants.VOWEL_CHARACTERS;


@Service
public class FindVowelsServiceImpl implements FindVowelsService
{
    private static final Logger logger = LoggerFactory.getLogger(FindVowelsServiceImpl.class);


    public List<VowelDto> findVowels(String inputtedStr)
    {
        List<VowelDto> vowels = new ArrayList<>();
        try
        {
            logger.info(String.format("Finding vowels in the string: '%s'", inputtedStr));
            String[] words = inputtedStr.trim().split("\\s+");
            for (String word : words)
            {
                List<Character> vowelCharacters = new ArrayList<>();
                VowelDto vowelDto = new VowelDto();
                vowelDto.setWord(word);
                for (int i = 0; i < word.length(); i++)
                {
                    if (hasVowel(word.charAt(i)))
                    {
                        logger.info(String.format("Vowel: '%s' has been found at the index: %s of the string: '%s'",
                                                  word.charAt(i), i, vowelDto.getWord()));
                        vowelDto.counterAdder();
                        if (!vowelCharacters.contains(word.charAt(i)))
                        {
                            vowelCharacters.add(word.charAt(i));
                        }
                    }
                }
                vowelDto.setVowelLetters(vowelCharacters);
                vowelDto.avgCalculator();
                vowels.add(vowelDto);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        vowels.forEach(s -> {
            logger.info("================================================================");
            logger.info(
                    String.format("Input: '%s' , Vowels: %s , Average of vowels: %s ", s.getWord(), s.getVowelLetters(),
                                  s.getAverage()));
        });
        return vowels;
    }


    public boolean hasVowel(Character c)
    {
        return VOWEL_CHARACTERS.contains(c);
    }
}

