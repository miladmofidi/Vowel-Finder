package com.project.luxoft.service.abstraction;

import com.project.luxoft.model.VowelDto;

import java.util.List;

public interface FindVowelsService
{
    List<VowelDto> findVowels(String inputtedStr);
    boolean hasVowel(Character c);
}
