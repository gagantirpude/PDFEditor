package com.gagan.operation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.gagan.utils.SimulateProgressBar.simulateProgressBar;

public class ConvertPDFToTXT {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output path for the TXT file (e.g., C:\\Users\\YourName\\Documents\\output.txt): ");
        String txtFilePath = scanner.nextLine();

        File pdfFile = new File(pdfFilePath);
        File txtFile = new File(txtFilePath);

        // Check if PDF file exists
        if (!pdfFile.exists() || !pdfFile.isFile()) {
            System.out.println("Invalid PDF file path. Please try again.");
            return;
        }

        // Check if the parent directory of the output file is writable
        if (!txtFile.getParentFile().exists() || !txtFile.getParentFile().canWrite()) {
            System.out.println("The selected directory is not writable. Please choose a different directory.");
            return;
        }

        try (PDDocument document = PDDocument.load(pdfFile);
             FileWriter writer = new FileWriter(txtFile)) {

            // Starting
            System.out.println("\nStarting PDF to TXT conversion...");

            // Operation
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            // Simulating progress bar for conversion
            simulateProgressBar();

            // Writing extracted text to the output file
            writer.write(text);
            System.out.println("\nConversion completed successfully!");
            System.out.println("TXT file created at: " + txtFilePath);

        } catch (IOException e) {
            System.err.println("\nAn error occurred while converting PDF to TXT: " + e.getMessage());
            System.err.println("Please check the file paths and permissions.");
        }
    }

//    private static void simulateProgressBar() {
//        int totalSteps = 50; // Total length of the progress bar
//        int sleepTime = 50; // Sleep time in milliseconds
//
//        System.out.print("[");
//        for (int i = 0; i < totalSteps; i++) {
//            // Simulate work being done
//            try {
//                Thread.sleep(sleepTime);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                break;
//            }
//
//            // Update progress bar
//            System.out.print("=");
//        }
//        System.out.println("]"); // Complete the progress bar
//    }
}
