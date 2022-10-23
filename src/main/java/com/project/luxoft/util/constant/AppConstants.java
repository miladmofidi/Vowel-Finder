package com.project.luxoft.util.constant;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppConstants
{
    public static final String FILE_NAME = "INPUT.TXT";
    public static final Path SOURCE_PATH = Paths.get("src", "main", "resources", "data", FILE_NAME);
    //Add more strings here if required.
    public static final String[] FILE_LINES = {"Platon made bamboo boats."};
    public static final HashSet<Character> VOWEL_CHARACTERS = vowelsInitializer();


    private static HashSet<Character> vowelsInitializer()
    {
        return Stream.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')
                .collect(Collectors.toCollection(HashSet::new));
    }
}
