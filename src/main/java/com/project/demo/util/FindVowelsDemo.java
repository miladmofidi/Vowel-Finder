package com.project.demo.util;

import com.project.demo.service.abstraction.FileUtilsService;
import com.project.demo.service.impl.FindVowelsServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import static com.project.demo.util.constant.AppConstants.SOURCE_PATH;


@Component
@Order(2)
public class FindVowelsDemo extends FindVowelsServiceImpl implements CommandLineRunner
{
    @Resource
    private FileUtilsService fileUtils;

    @Override
    public void run(String... args)
    {
        try
        {
            //Reading file content.
            Optional<Stream<String>> fileLines = fileUtils.readFile(SOURCE_PATH);
            //Checking for vowel letters.
            fileLines.ifPresent(lines -> lines.forEach(this::findVowels));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void preDestroy() throws IOException
    {
        //Delete folder before bean destroy.
        FileUtils.deleteDirectory(new File(SOURCE_PATH.getParent().toUri()));
    }
}
