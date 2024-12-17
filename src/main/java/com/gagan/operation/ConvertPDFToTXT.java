package com.gagan.operation;

import com.gagan.main.Main;
import com.gagan.utils.FileChecker;
import com.gagan.utils.PostOperationMenu;
import com.gagan.utils.TimestampUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ConvertPDFToTXT {
    public static void convertOperation(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the path of the PDF file to convert to TXT (or 'exit' to return): ");
                String pdfFilePath = scanner.nextLine();
                if (pdfFilePath.equalsIgnoreCase("exit")) return;

                if (!FileChecker.checkFileExists(pdfFilePath)) {
                    System.out.println("Invalid PDF file path. Please try again.");
                    continue;
                }

                System.out.print("Enter the output directory for the TXT file (or 'exit' to return): ");
                String outputDirectory = scanner.nextLine();
                if (outputDirectory.equalsIgnoreCase("exit")) return;

                if (!FileChecker.checkDirectoryExists(outputDirectory)) {
                    System.out.println("Invalid output directory. Please try again.");
                    continue;
                }

                System.out.print("Enter the output TXT file name (without extension): ");
                String txtFileName = scanner.nextLine();
                txtFileName = FileChecker.ensureFileExtension(txtFileName, "txt");
                String txtFilePath = new File(outputDirectory, txtFileName).getAbsolutePath();

                System.out.println("Starting conversion...");

//                ProgressBar.displayProgressBar("Converting PDF to TXT");
                convertPDFToTXT(pdfFilePath, txtFilePath);
                System.out.println("[" + TimestampUtil.getCurrentTimestamp() + "] PDF converted to TXT successfully at " + txtFilePath);

                PostOperationMenu.display(scanner, () -> convertOperation(scanner), () -> Main.main(new String[0]));
                return;
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void convertPDFToTXT(String pdfFilePath, String txtFilePath) throws IOException {
        try (PDDocument pdfDocument = PDDocument.load(new File(pdfFilePath));
             FileOutputStream txtFile = new FileOutputStream(txtFilePath)) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String textContent = pdfStripper.getText(pdfDocument);
            txtFile.write(textContent.getBytes());
        }
    }
}
