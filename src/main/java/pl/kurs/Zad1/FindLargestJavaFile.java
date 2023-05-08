package pl.kurs.Zad1;

import java.io.File;


public class FindLargestJavaFile {
    private static File largestFile;
    private static long largestSize;

    public static void main(String[] args) {
        findLargestJavaFile("C:\\Users\\Kamil\\IdeaProjects");
        System.out.println("Największy plik Java: " + largestFile.getAbsolutePath());
        System.out.println("Rozmiar: " + largestSize + " bajtów");

    }

    private static void findLargestJavaFile(String path) {
        File file1 = new File(path);
        File[] files = file1.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findLargestJavaFile(file.getAbsolutePath());
                } else if (file.getName().endsWith(".java")) {
                    long fileSize = file.length();
                    if (fileSize > largestSize) {
                        largestFile = file;
                        largestSize = fileSize;
                    }
                }
            }
        }
    }
}

