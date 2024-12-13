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

import java.io.File;
import java.util.Scanner;


class ConvertPDFToTXT {
    public static void convertOperation(Scanner scanner) {
        System.out.print("Enter the path of the PDF file: ");
        String pdfFilePath = scanner.nextLine();

        System.out.print("Enter the output directory for the TXT file: ");
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
                outputFileName = outputDirectory + File.separator + "output.txt";
//                pdfDocument.save(outputFileName, SaveFormat.Text);
                pdfDocument.save(outputFileName, SaveFormat.TeX);
            }
            System.out.println("PDF successfully converted to TXT: " + outputFileName);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to TXT: " + e.getMessage());
        }
    }
}