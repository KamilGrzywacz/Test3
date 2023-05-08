package pl.kurs.Zad2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<File> javaFiles = new ArrayList<>();
        findJavaFiles(new File("C:\\Users\\Kamil\\IdeaProjects"), javaFiles);

        javaFiles.stream()
                .map(x -> getDayOfWeekFromFile(x))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(System.out::println);

    }

    static void findJavaFiles(File file, List<File> list) {
        File[] filesArray = file.listFiles();
        for (File f : filesArray) {
            if (f.isDirectory()) {
                findJavaFiles(f, list);
            } else if (f.getName().endsWith(".java")) {
                list.add(f);
            }

        }
    }


    static DayOfWeek getDayOfWeekFromFile(File file) {
        DayOfWeek dow = null;
        try {
            BasicFileAttributes bfa = Files.readAttributes(Path.of(file.getAbsolutePath()), BasicFileAttributes.class);
            if (bfa != null) {
                Instant instant = bfa.creationTime().toInstant();
                LocalDate ld = LocalDate.ofInstant(instant, ZoneOffset.UTC);
                dow = ld.getDayOfWeek();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dow;
    }
}
