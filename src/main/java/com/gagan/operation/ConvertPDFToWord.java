package com.gagan.operation;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.gagan.main.Main;
import com.gagan.utils.*;

import java.io.File;
import java.util.Scanner;

public class ConvertPDFToWord {

    public static void convertOperation(Scanner scanner) {
        while (true) {
            try {
                // Step 1: Input PDF file path
                System.out.print("Enter the path of the PDF file to convert (or 'exit' to return): ");
                String pdfFilePath = scanner.nextLine();
                if (pdfFilePath.equalsIgnoreCase("exit")) return;

                // Validate file existence and type
                if (!FileChecker.checkFileExists(pdfFilePath) || !FileChecker.checkFileType(pdfFilePath, "pdf")) {
                    System.out.println("Invalid PDF file. Please try again.");
                    continue;
                }

                // Retrieve total page count
                int totalPages = PDFUtils.getAsposePDFPageCount(pdfFilePath);
                if (totalPages <= 0) {
                    System.out.println("The selected PDF file has no pages or could not be read. Operation aborted.");
                    continue;
                }

                System.out.println("The selected PDF contains " + totalPages + " page(s).");

                // Step 2: Display estimated time
                TimeEstimator.displayEstimatedTime(totalPages);

                // Step 3: Output directory and file name
                System.out.print("Enter the output directory for the Word file (or 'exit' to return): ");
                String outputDirectory = scanner.nextLine();
                if (outputDirectory.equalsIgnoreCase("exit")) return;

                if (!FileChecker.checkDirectoryExists(outputDirectory)) {
                    System.out.println("Invalid output directory. Please try again.");
                    continue;
                }

                System.out.print("Enter the output Word file name (without extension): ");
                String wordFileName = scanner.nextLine();
                wordFileName = FileChecker.ensureFileExtension(wordFileName, "docx");
                String wordFilePath = new File(outputDirectory, wordFileName).getAbsolutePath();

                System.out.println("Starting conversion...");
                System.out.println("Converting PDF: " + pdfFilePath);
                System.out.println("Output Word file will be saved at: " + wordFilePath);

                // Step 4: Convert PDF to Word
                if (totalPages < 4) {
                    convertSmallPDFToWord(pdfFilePath, wordFilePath, totalPages);
                } else {
                    convertLargePDFToWord(pdfFilePath, wordFilePath, totalPages);
                }

                System.out.println("[" + TimestampUtil.getCurrentTimestamp() + "] PDF converted to Word successfully at: " + wordFilePath);

                // Step 5: Post-operation menu
                PostOperationMenu.display(scanner, () -> convertOperation(scanner), () -> Main.main(new String[0]));
                return;

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void convertSmallPDFToWord(String pdfFilePath, String wordFilePath, int totalPages) throws Exception {
        ProgressBar.startProgressBar("Converting Small PDF to Word", totalPages);

        try (Document pdfDocument = new Document(pdfFilePath)) {
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                // Simulate processing
                ProgressBar.updateProgressBar(currentPage);
                System.out.println("Processed page " + currentPage + " of " + totalPages);
                Thread.sleep(200); // Simulated delay (remove in production)
            }
            pdfDocument.save(wordFilePath, SaveFormat.DocX);
        }

        ProgressBar.completeProgressBar();
    }

    private static void convertLargePDFToWord(String pdfFilePath, String wordFilePath, int totalPages) throws Exception {
        ProgressBar.startProgressBar("Converting Large PDF to Word", 1);

        try (Document pdfDocument = new Document(pdfFilePath)) {
            Thread.sleep(100L * totalPages); // Simulated delay (remove in production)
            pdfDocument.save(wordFilePath, SaveFormat.DocX);
        }

        ProgressBar.updateProgressBar(1);
        ProgressBar.completeProgressBar();
    }
}