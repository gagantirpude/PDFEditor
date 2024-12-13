package com.gagan.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class SplitPDF {
    public static void splitOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file to split: ");
        String pdfFilePath = scanner.nextLine();

        File pdfFile = new File(pdfFilePath);
        if (!pdfFile.exists() || !pdfFile.isFile()) {
            System.out.println("Invalid PDF file path. Exiting.");
            return;
        }

        System.out.print("Enter the output directory for the split files: ");
        String outputDirectory = scanner.nextLine();

        File directory = new File(outputDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory. Exiting.");
            return;
        }

        try {
            splitPDFFile(pdfFilePath, outputDirectory);
            System.out.println("PDF file split successfully. Output files are in: " + outputDirectory);
        } catch (IOException e) {
            System.err.println("An error occurred while splitting the PDF file: " + e.getMessage());
        }
    }

    public static void splitPDFFile(String pdfFilePath, String outputDirectory) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));

        int pageCount = document.getNumberOfPages();
        for (int i = 0; i < pageCount; i++) {
            PDDocument singlePageDoc = new PDDocument();
            singlePageDoc.addPage(document.getPage(i));

            String outputFileName = outputDirectory + File.separator + "page-" + (i + 1) + ".pdf";
            singlePageDoc.save(outputFileName);
            singlePageDoc.close();
        }

        document.close();
    }
}
