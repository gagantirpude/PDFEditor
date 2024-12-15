package com.gagan.operation;

import com.aspose.pdf.*; // Aspose PDF library import
import java.util.Scanner;
import java.io.File;

public class ConvertPDFToMobiXML {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output directory for the TXT file: ");
        String outputDirectory = scanner.nextLine();

        //
        File pdfFile = new File(pdfFilePath);
        if (!pdfFile.exists() || !pdfFile.isFile()) {
            System.out.println("Invalid PDF file path. Exiting.");
            return;
        }
        if (!pdfFile.getParentFile().canWrite()) {
            System.out.println("The selected directory is not writable. Please choose a different directory.");
            return;
        }

        //
        File directory = new File(outputDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid output directory. Exiting.");
            return;
        }

        //
        try {
            String outputFileName;
            try (Document pdfDocument = new Document(pdfFilePath)) {
                outputFileName = outputDirectory + File.separator + "output.pdfxml";
                pdfDocument.save(outputFileName, SaveFormat.PdfXml);
            }
            System.out.println("PDF successfully converted to TXT: " + outputFileName);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to TXT: " + e.getMessage());
        }



    }
}