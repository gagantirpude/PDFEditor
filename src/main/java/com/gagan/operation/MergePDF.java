package com.gagan.operation;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class MergePDF {
//
//    public static void mergeOperation(Scanner scanner) {
//        List<String> pdfFiles = new ArrayList<>();
//
//        System.out.println("Enter the paths of PDF files to merge, one per line. Enter 'done' when finished:");
//
//        while (true) {
//            String input = scanner.nextLine();
//            if (input.equalsIgnoreCase("done")) {
//                break;
//            }
//            pdfFiles.add(input);
//        }
//
//        if (pdfFiles.isEmpty()) {
//            System.out.println("No PDF files provided. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the directory where you want to store the output file: ");
//        String outputDirectory = scanner.nextLine();
//
//        File directory = new File(outputDirectory);
//        if (!directory.exists() || !directory.isDirectory()) {
//            System.out.println("Invalid directory. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output file name (including .pdf extension): ");
//        String outputFileName = scanner.nextLine();
//        String outputFilePath = new File(directory, outputFileName).getAbsolutePath();
//
//        try {
//            mergePDFFiles(pdfFiles, outputFilePath);
//            System.out.println("PDF files merged successfully into " + outputFilePath);
//        } catch (IOException e) {
//            System.err.println("An error occurred while merging PDF files: " + e.getMessage());
//        }
//    }
//
//    public static void mergePDFFiles(List<String> pdfFiles, String outputFileName) throws IOException {
//        PDFMergerUtility merger = new PDFMergerUtility();
//
//        for (String filePath : pdfFiles) {
//            File file = new File(filePath);
//            if (file.exists() && file.isFile()) {
//                merger.addSource(file);
//            } else {
//                throw new IOException("File not found: " + filePath);
//            }
//        }
//
//        merger.setDestinationFileName(outputFileName);
//        merger.mergeDocuments(null);
//    }
//}



public class MergePDF {
    public static void mergeOperation(Scanner scanner) {
        List<String> pdfFiles = new ArrayList<>();

        System.out.println("Enter the paths of PDF files to merge, one per line. Enter 'done' when finished:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            pdfFiles.add(input);
        }

        if (pdfFiles.isEmpty()) {
            System.out.println("No PDF files provided. Exiting.");
            return;
        }

        System.out.print("Enter the directory where you want to store the output file: ");
        String outputDirectory = scanner.nextLine();

        File directory = new File(outputDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory. Exiting.");
            return;
        }

        System.out.print("Enter the output file name (including .pdf extension): ");
        String outputFileName = scanner.nextLine();
        String outputFilePath = new File(directory, outputFileName).getAbsolutePath();

        try {
            mergePDFFiles(pdfFiles, outputFilePath);
            System.out.println("PDF files merged successfully into " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while merging PDF files: " + e.getMessage());
        }
    }

    public static void mergePDFFiles(List<String> pdfFiles, String outputFileName) throws IOException {
        PDFMergerUtility merger = new PDFMergerUtility();

        for (String filePath : pdfFiles) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                merger.addSource(file);
            } else {
                throw new IOException("File not found: " + filePath);
            }
        }

        merger.setDestinationFileName(outputFileName);
        merger.mergeDocuments(null);
    }
}