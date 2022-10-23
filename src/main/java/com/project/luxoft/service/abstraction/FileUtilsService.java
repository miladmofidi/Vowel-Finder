package com.project.luxoft.service.abstraction;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface FileUtilsService
{
    Optional<Stream<String>> readFile(Path path);
    Path writeFile(Path path, List<String> lines);
}
