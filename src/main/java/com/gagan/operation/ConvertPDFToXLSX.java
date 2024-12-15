package com.gagan.operation;

import com.aspose.pdf.*; // Aspose PDF library import

import java.io.File;
import java.util.Scanner;

public class ConvertPDFToXLSX {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output directory for the XLSX file: ");
        String outputDirectory = scanner.nextLine();

        File pdfFile = new File(pdfFilePath);
        File directory = new File(outputDirectory);

        if (!pdfFile.exists() || !pdfFile.isFile()) {
            System.out.println("Invalid PDF file path. Exiting.");
            return;
        }

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid output directory. Exiting.");
            return;
        }

        try {
            Document pdfDocument = new Document(pdfFilePath);
            String outputFileName = outputDirectory + File.separator + "output.xlsx";
            pdfDocument.save(outputFileName, SaveFormat.Excel);
            System.out.println("PDF successfully converted to XLSX: " + outputFileName);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to XLSX: " + e.getMessage());
        }
    }
}