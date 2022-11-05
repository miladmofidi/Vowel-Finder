package com.project.demo.service.abstraction;

import com.project.demo.model.VowelDto;

import java.util.List;

public interface FindVowelsService
{
    List<VowelDto> findVowels(String inputtedStr);
    boolean hasVowel(Character c);
}
