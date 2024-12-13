package com.gagan.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import com.aspose.pdf.*; // Aspose PDF library import

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class ConvertPDFToCSV {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output directory for the CSV file: ");
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
            String outputFileName;
            try (Document pdfDocument = new Document(pdfFilePath)) {
                outputFileName = outputDirectory + File.separator + "output.csv";
                pdfDocument.save(outputFileName, SaveFormat.Markdown);
            }
            System.out.println("PDF successfully converted to CSV: " + outputFileName);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to CSV: " + e.getMessage());
        }
    }
}