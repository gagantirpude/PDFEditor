package com.gagan.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
            convertPDFToWord(pdfFilePath, wordFilePath);
            System.out.println("PDF converted to Word successfully at " + wordFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
        }
    }

    public static void convertPDFToWord(String pdfFilePath, String wordFilePath) throws IOException {
        try (PDDocument pdfDocument = PDDocument.load(new File(pdfFilePath));
             XWPFDocument wordDocument = new XWPFDocument();
             FileOutputStream outputStream = new FileOutputStream(wordFilePath)) {

            // Extract text from each page of the PDF
            PDFTextStripper textStripper = new PDFTextStripper();
            String pdfText = textStripper.getText(pdfDocument);

            // Write extracted text into the Word document
            wordDocument.createParagraph().createRun().setText(pdfText);

            // Save the Word document
            wordDocument.write(outputStream);
            System.out.println("PDF converted to Word successfully.");
        } catch (Exception e) {
            throw new IOException("Error during PDF to Word conversion: " + e.getMessage(), e);
        }
    }
}
