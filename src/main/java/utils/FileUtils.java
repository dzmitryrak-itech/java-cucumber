package utils;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class FileUtils {

    public List<String> getLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(Paths.get(filePath))) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage() + filePath);
        }
        return lines;
    }
}
