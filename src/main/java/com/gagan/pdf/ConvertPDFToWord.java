package com.gagan.pdf;

import java.io.File;
import java.util.Scanner;

class ConvertPDFToWord {
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

        try {
            convertPDFToWordWithStyle(pdfFilePath, wordFilePath);
            System.out.println("PDF converted to Word successfully with styles preserved at " + wordFilePath);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
        }
    }

    public static void convertPDFToWordWithStyle(String pdfFilePath, String wordFilePath) throws Exception {
        // Initialize the Aspose library (ensure  .PDF for Java is added to your dependencies)
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(pdfFilePath);

        // Convert PDF to Word with flow layout to preserve styles
        pdfDocument.save(wordFilePath, com.aspose.pdf.SaveFormat.DocX);

        // Clean up resources
        pdfDocument.close();
    }
}