package com.gagan.test;

import java.io.File;
import java.util.Scanner;

public class Test {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file to convert: ");
        String pdfFilePath = scanner.nextLine();

        File pdfFile = new File(pdfFilePath);
        if (!pdfFile.exists() || !pdfFile.isFile()) {
            System.out.println("Invalid PDF file path. Exiting.");
            return;
        }

        System.out.print("Enter the output directory for the Word file: ");
        String outputDirectory = scanner.nextLine();

        File directory = new File(outputDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory. Exiting.");
            return;
        }

        System.out.print("Enter the output Word file name (including .docx extension): ");
        String wordFileName = scanner.nextLine();
        String wordFilePath = new File(directory, wordFileName).getAbsolutePath();

        System.out.println("Starting conversion...");

        try {
            simulateProgressBar();
            convertPDFToWordWithStyle(pdfFilePath, wordFilePath);
            System.out.println("PDF converted to Word successfully with styles preserved at " + wordFilePath);

//            // Print completion timestamp
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//            System.out.println("Completed at: " + timestamp);


            //called Time stamp
//            myTimeStamp();

        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
        }
    }

    public static void convertPDFToWordWithStyle(String pdfFilePath, String wordFilePath) throws Exception {
        // Initialize the Aspose library (ensure .PDF for Java is added to your dependencies)
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(pdfFilePath);

        // Convert PDF to Word with flow layout to preserve styles
        pdfDocument.save(wordFilePath, com.aspose.pdf.SaveFormat.DocX);

        // Clean up resources
        pdfDocument.close();
    }

    private static void simulateProgressBar() {
        int progress = 0;
        System.out.print("Progress: [");

        while (progress <= 100) {
            try {
                Thread.sleep(100); // Simulate time delay
                System.out.print("#");
                progress += 5;
            } catch (InterruptedException e) {
                System.err.println("Progress simulation interrupted.");
                break;
            }
        }

        System.out.println("] 100%");
    }
}



//
//public class ConvertPDFToWord {
//    public static void convertOperation(Scanner scanner) {
//        System.out.print("Enter the path of the PDF file to convert: ");
//        String pdfFilePath = scanner.nextLine();
//
//        File pdfFile = new File(pdfFilePath);
//        if (!pdfFile.exists() || !pdfFile.isFile()) {
//            System.out.println("Invalid PDF file path. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output directory for the Word file: ");
//        String outputDirectory = scanner.nextLine();
//
//        File directory = new File(outputDirectory);
//        if (!directory.exists() || !directory.isDirectory()) {
//            System.out.println("Invalid directory. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output Word file name (including .docx extension): ");
//        String wordFileName = scanner.nextLine();
//        String wordFilePath = new File(directory, wordFileName).getAbsolutePath();
//
//        System.out.println("Starting conversion...");
//
//        try {
//            simulateProgressBar();
//            convertPDFToWordWithStyle(pdfFilePath, wordFilePath);
//            System.out.println("PDF converted to Word successfully with styles preserved at " + wordFilePath);
//
//            // Print completion timestamp
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//            System.out.println("Completed at: " + timestamp);
//        } catch (Exception e) {
//            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
//        }
//    }
//
//    public static void convertPDFToWordWithStyle(String pdfFilePath, String wordFilePath) throws Exception {
//        // Initialize the Aspose library (ensure .PDF for Java is added to your dependencies)
//        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(pdfFilePath);
//
//        // Convert PDF to Word with flow layout to preserve styles
//        pdfDocument.save(wordFilePath, com.aspose.pdf.SaveFormat.DocX);
//
//        // Clean up resources
//        pdfDocument.close();
//    }
//
//    private static void simulateProgressBar() {
//        int progress = 0;
//        System.out.print("Progress: [");
//
//        while (progress <= 100) {
//            try {
//                Thread.sleep(100); // Simulate time delay
//                System.out.print("#");
//                progress += 5;
//            } catch (InterruptedException e) {
//                System.err.println("Progress simulation interrupted.");
//                break;
//            }
//        }
//
//        System.out.println("] 100%");
//    }
//}