package com.gagan.utils;

import java.io.File;

public class FileChecker {

    public static boolean checkFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist: " + filePath);
            return false;
        }
        return true;
    }

    public static boolean checkDirectoryExists(String dirPath) {
        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist: " + dirPath);
            return false;
        }
        return true;
    }

    public static String ensureFileExtension(String fileName, String desiredExtension) {
        if (!fileName.toLowerCase().endsWith("." + desiredExtension.toLowerCase())) {
            return fileName + "." + desiredExtension;
        }
        return fileName;
    }

    public static boolean checkFileType(String filePath, String expectedExtension) {
        return filePath.toLowerCase().endsWith("." + expectedExtension);
    }
}