package com.project.demo.service;

import com.project.demo.service.abstraction.FileUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static com.project.demo.util.constant.AppConstants.FILE_LINES;
import static com.project.demo.util.constant.AppConstants.FILE_NAME;
import static com.project.demo.util.constant.AppConstants.SOURCE_PATH;

@Component
@Order(1)
public class DataInitializer implements CommandLineRunner
{
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    @Resource
    private FileUtilsService fileUtilsService;


    @Override
    public void run(String... args)
    {
        fileInitializer();
    }

    private void fileInitializer()
    {
        //Initializing the INPUT file.
        try
        {
            if (logger.isDebugEnabled())
            {
                logger.debug(String.format("Trying to create folder at path: %s", SOURCE_PATH.getParent()));
            }

            Files.createDirectories(SOURCE_PATH.getParent());
            List<String> lines = Arrays.asList(FILE_LINES);
            fileUtilsService.writeFile(SOURCE_PATH, lines);
            logger.info(String.format("%s file has been created at path: %s", FILE_NAME, SOURCE_PATH.getParent()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
