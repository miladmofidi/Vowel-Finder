package com.project.demo.service.impl;

import com.project.demo.FindVowelsTest;
import com.project.demo.model.VowelDto;
import com.project.demo.service.abstraction.FindVowelsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.project.demo.util.constant.AppConstants.FILE_LINES;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class FindVowelsServiceImplTest extends FindVowelsTest
{
    private FindVowelsService findVowelsService;

    @BeforeEach
    void setUp()
    {
        findVowelsService = new FindVowelsServiceImpl();
    }


    @Test
    void findVowels()
    {
        List<VowelDto> actualVowels = findVowelsService.findVowels(testString);
        assertThat(actualVowels).isInstanceOf(ArrayList.class);
        assertThat(actualVowels.get(0)).isInstanceOf(VowelDto.class);
        assertThat(actualVowels).isNotNull();
        assertThat(actualVowels.size()).isEqualTo(4);
        actualVowels.forEach(actualVowel -> expectedVowels().forEach(expectedVowel -> {
            if (expectedVowel.getWord().equals(actualVowel.getWord()))
            {
                assertThat(actualVowel.getAverage()).isEqualTo(expectedVowel.getAverage());
            }
        }));
    }


    @Test
    void hasVowelWithTrueCase()
    {
        String sre = FILE_LINES[0];
        boolean actualResult = false;
        for (Character chr : sre.toCharArray())
        {
            actualResult = findVowelsService.hasVowel(chr);
            if (actualResult)
            {
                break;
            }
        }
        assertThat(actualResult).isInstanceOf(Boolean.class);
        assertTrue(actualResult);
    }

    @Test
    void hasVowelWithFalseCase()
    {
        String sre = "Gym";
        boolean actualResult = false;
        for (Character chr : sre.toCharArray())
        {
            actualResult = findVowelsService.hasVowel(chr);
        }
        assertThat(actualResult).isInstanceOf(Boolean.class);
        assertFalse(actualResult);
    }
}