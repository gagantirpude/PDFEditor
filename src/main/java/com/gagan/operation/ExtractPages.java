package com.gagan.operation;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExtractPages {
    public static void extractOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output directory for the extracted pages: ");
        String outputDirectory = scanner.nextLine();

        System.out.print("Enter the page numbers to extract (comma-separated, e.g., 1,3,5): ");
        String pagesInput = scanner.nextLine();

        File directory = new File(outputDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory. Exiting.");
            return;
        }

        try {
            extractPagesFromPDF(pdfFilePath, outputDirectory, pagesInput);
            System.out.println("Pages extracted successfully. Output files are in: " + outputDirectory);
        } catch (IOException e) {
            System.err.println("An error occurred while extracting pages: " + e.getMessage());
        }
    }

    public static void extractPagesFromPDF(String pdfFilePath, String outputDirectory, String pagesInput) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));

        String[] pages = pagesInput.split(",");
        for (String pageStr : pages) {
            int pageIndex = Integer.parseInt(pageStr.trim()) - 1;
            if (pageIndex < 0 || pageIndex >= document.getNumberOfPages()) {
                System.out.println("Invalid page number: " + (pageIndex + 1));
                continue;
            }

            PDDocument singlePageDoc = new PDDocument();
            singlePageDoc.addPage(document.getPage(pageIndex));

            String outputFileName = outputDirectory + File.separator + "page-" + (pageIndex + 1) + ".pdf";
            singlePageDoc.save(outputFileName);
            singlePageDoc.close();
        }

        document.close();
    }
}
