package com.gagan.operation;


import com.gagan.main.Main;
import com.gagan.utils.*;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergePDF  {

    public static void mergeOperation(Scanner scanner) {
        while (true) {
            try {
                // Step 1: Collect input file paths
                System.out.print("Enter the number of PDF files to merge (or 'exit' to return): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) return;

                int count = Integer.parseInt(input);
                if (count < 2) {
                    System.out.println("At least two files are required to merge.");
                    continue;
                }

                List<String> pdfFiles = new ArrayList<>();
                int totalPages = 0; // Total pages for time estimation
                for (int i = 1; i <= count; i++) {
                    while (true) {
                        System.out.print("Enter path for PDF file " + i + " (or 'exit' to return): ");
                        String filePath = scanner.nextLine();
                        if (filePath.equalsIgnoreCase("exit")) return;

                        if (FileChecker.checkFileExists(filePath) && FileChecker.checkFileType(filePath, "pdf")) {
                            pdfFiles.add(filePath);
                            totalPages += PDFUtils.getAsposePDFPageCount(filePath);
                            break;
                        } else {
                            System.out.println("Invalid PDF file. Please try again.");
                        }
                    }
                }

                // Step 2: Output directory and file naming
                System.out.print("Enter the output directory for the merged PDF (or 'exit' to return): ");
                String outputDirectory = scanner.nextLine();
                if (outputDirectory.equalsIgnoreCase("exit")) return;

                if (!FileChecker.checkDirectoryExists(outputDirectory)) {
                    System.out.println("Invalid output directory. Please try again.");
                    continue;
                }

                System.out.print("Enter the output file name (without extension): ");
                String outputFileName = scanner.nextLine();
                outputFileName = FileChecker.ensureFileExtension(outputFileName, "pdf");
                String outputFilePath = new File(outputDirectory, outputFileName).getAbsolutePath();

                // Step 3: Display estimated time
                TimeEstimator.displayEstimatedTime(totalPages);

                // Step 4: Merge PDFs
                System.out.println("Starting PDF merging...");
                if (totalPages < 4) {
                    mergeSmallPDFs(pdfFiles, outputFilePath, totalPages);
                } else {
                    mergeLargePDFs(pdfFiles, outputFilePath, totalPages);
                }

                System.out.println("[" + TimestampUtil.getCurrentTimestamp() + "] PDF files merged successfully at: " + outputFilePath);

                // Step 5: Post-operation menu
                PostOperationMenu.display(scanner, () -> mergeOperation(scanner), () -> Main.main(new String[0]));
                return;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void mergeSmallPDFs(List<String> pdfFiles, String outputFilePath, int totalPages) throws IOException, InterruptedException {
        ProgressBar.startProgressBar("Merging Small PDFs", totalPages);

        PDFMergerUtility merger = new PDFMergerUtility();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            // Simulate progress with a small delay per page
            ProgressBar.updateProgressBar(currentPage);
            Thread.sleep(200); // Simulated small delay
        }

        for (String filePath : pdfFiles) {
            merger.addSource(filePath);
        }
        merger.setDestinationFileName(outputFilePath);
        merger.mergeDocuments(null);

        ProgressBar.completeProgressBar();
    }

    private static void mergeLargePDFs(List<String> pdfFiles, String outputFilePath, int totalPages) throws IOException, InterruptedException {
        ProgressBar.startProgressBar("Merging Large PDFs", 1);

        PDFMergerUtility merger = new PDFMergerUtility();
        for (String filePath : pdfFiles) {
            merger.addSource(filePath);
        }

        // Simulate progress for large PDFs
        Thread.sleep(100L * totalPages); // Simulated large delay
        merger.setDestinationFileName(outputFilePath);
        merger.mergeDocuments(null);

        ProgressBar.updateProgressBar(1);
        ProgressBar.completeProgressBar();
    }
}