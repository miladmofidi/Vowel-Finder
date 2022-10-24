package com.project.luxoft.service.impl;

import com.project.luxoft.service.abstraction.FileUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.project.luxoft.util.constant.AppConstants.FILE_NAME;


@Service
public class FileUtilsServiceImpl implements FileUtilsService
{
    private final Logger logger = LoggerFactory.getLogger(FileUtilsServiceImpl.class);

    @Override
    public Optional<Stream<String>> readFile(@NotNull Path path)
    {
        try
        {
            if (logger.isDebugEnabled())
            {
                logger.debug(String.format("Trying to read file: %s", FILE_NAME));
            }
            return Optional.ofNullable(Files.lines(new File(path.toUri()).toPath()));
        }
        catch (IOException e)
        {
            if (logger.isDebugEnabled())
            {
                logger.debug(String.format("File writing failed for file: %s", FILE_NAME));
            }
            //can throw a custom exception to manage by consumer of service or AOP
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public Path writeFile(@NotNull Path path, @NotNull List<String> lines)
    {
        try
        {
            if (logger.isDebugEnabled())
            {
                logger.debug(String.format("Trying to write file: %s", FILE_NAME));
            }
            return Files.write(path,
                               lines,
                               StandardCharsets.UTF_8,
                               StandardOpenOption.CREATE,
                               StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            if (logger.isDebugEnabled())
            {
                logger.debug(String.format("File reading failed for file: %s", FILE_NAME));
            }
            //can throw a custom exception to manage by consumer of service or AOP
            e.printStackTrace();
        }
        return path;
    }
}