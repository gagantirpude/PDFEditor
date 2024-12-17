package com.gagan.test;

import com.aspose.pdf.DocSaveOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



//public class Demo {
//    public static void convertOperation(Scanner scanner) {
//        System.out.print("Enter the path of the PDF file to convert: ");
//        String pdfFilePath = scanner.nextLine();
//
//        File pdfFile = new File(pdfFilePath);
//        if (!pdfFile.exists() || !pdfFile.isFile()) {
//            System.out.println("Invalid PDF file path. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output directory for the Word file: ");
//        String outputDirectory = scanner.nextLine();
//
//        File directory = new File(outputDirectory);
//        if (!directory.exists() || !directory.isDirectory()) {
//            System.out.println("Invalid directory. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output Word file name (including .docx extension): ");
//        String wordFileName = scanner.nextLine();
//        String wordFilePath = new File(directory, wordFileName).getAbsolutePath();
//
//        System.out.println("Starting conversion...");
//
//        try {
//            simulateProgressBar();
//            convertPDFToWordWithText(pdfFilePath, wordFilePath);
//            System.out.println("PDF converted to Word successfully at " + wordFilePath);
//
//            // Print completion timestamp
//            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//            System.out.println("Completed at: " + timestamp);
//        } catch (Exception e) {
//            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
//        }
//    }
//
//    public static void convertPDFToWordWithText(String pdfFilePath, String wordFilePath) throws Exception {
//        // Load the PDF
//        PDDocument pdfDocument = PDDocument.load(new File(pdfFilePath));
//
//        // Extract text using PDFBox
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//        String pdfText = pdfStripper.getText(pdfDocument);
//
//        // Close the PDF document
//        pdfDocument.close();
//
//        // Create a new Word document using Docx4j
//        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
//        org.docx4j.wml.ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
//
//        // Add the extracted text to the Word document
//        String[] lines = pdfText.split("\n");
//        for (String line : lines) {
//            P para = factory.createP();
//            Text t = factory.createText();
//            t.setValue(line);
//            R run = factory.createR();
//            run.getContent().add(t);
//            para.getContent().add(run);
//            wordMLPackage.getMainDocumentPart().addObject(para);
//        }
//
//        // Save the Word document
//        wordMLPackage.save(new File(wordFilePath));
//    }
//
//    private static void simulateProgressBar() {
//        int progress = 0;
//        System.out.print("Progress: [");
//
//        while (progress <= 100) {
//            try {
//                Thread.sleep(100); // Simulate time delay
//                System.out.print("#");
//                progress += 5;
//            } catch (InterruptedException e) {
//                System.err.println("Progress simulation interrupted.");
//                break;
//            }
//        }
//
//        System.out.println("] 100%");
//    }
//}
//public class Demo {
//    public static void convertOperation(Scanner scanner) {
//        System.out.print("Enter the path of the PDF file to convert: ");
//        String pdfFilePath = scanner.nextLine();
//
//        File pdfFile = new File(pdfFilePath);
//        if (!pdfFile.exists() || !pdfFile.isFile()) {
//            System.out.println("Invalid PDF file path. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output directory for the Word file: ");
//        String outputDirectory = scanner.nextLine();
//
//        File directory = new File(outputDirectory);
//        if (!directory.exists() || !directory.isDirectory()) {
//            System.out.println("Invalid directory. Exiting.");
//            return;
//        }
//
//        System.out.print("Enter the output Word file name (including .docx extension): ");
//        String wordFileName = scanner.nextLine();
//        String wordFilePath = new File(directory, wordFileName).getAbsolutePath();
//
//        System.out.println("Starting conversion...");
//
//        try {
//            simulateProgressBar();
//            convertPDFToWordWithStyle(pdfFilePath, wordFilePath);
//            System.out.println("PDF converted to Word successfully at " + wordFilePath);
//        } catch (Exception e) {
//            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
//        }
//    }
//
//    public static void convertPDFToWordWithStyle(String pdfFilePath, String wordFilePath) throws Exception {
//        // Load the PDF document
//        PDDocument pdfDocument = PDDocument.load(new File(pdfFilePath));
//
//        // Extract text using PDFTextStripper
//        PDFTextStripper textStripper = new PDFTextStripper();
//        String pdfText = textStripper.getText(pdfDocument);
//
//        // Initialize WordprocessingMLPackage for DOCX file
//        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
//        ObjectFactory factory = new ObjectFactory();
//
//        // Split text into paragraphs
////        String[] paragraphs = pdfText.split("\n");
////        for (String paragraph : paragraphs) {
////            P p = factory.createP();
////            Text t = factory.createText();
////            t.setValue(paragraph);
////            p.getContent().add(factory.createR().withContent(t));
////            wordMLPackage.getMainDocumentPart().addObject(p);
////        }
//
//        // Split text into paragraphs
//        String[] paragraphs = pdfText.split("\\n");
//        for (String paragraph : paragraphs) {
//            P p = factory.createP();  // Create a paragraph
//            R r = factory.createR();  // Create a run
//            Text t = factory.createText();  // Create a text node
//
//            t.setValue(paragraph);  // Set text value
//            r.getContent().add(t);  // Add text node to the run
//            p.getContent().add(r);  // Add run to the paragraph
//
//            wordMLPackage.getMainDocumentPart().addObject(p);  // Add paragraph to the document
//        }
//
//
//
//        // Save the DOCX file
//        wordMLPackage.save(new File(wordFilePath));
//
//        // Close the PDF document
//        pdfDocument.close();
//    }
//
//    private static void simulateProgressBar() {
//        int progress = 0;
//        System.out.print("Progress: [");
//
//        while (progress <= 100) {
//            try {
//                Thread.sleep(100); // Simulate time delay
//                System.out.print("#");
//                progress += 5;
//            } catch (InterruptedException e) {
//                System.err.println("Progress simulation interrupted.");
//                break;
//            }
//        }
//
//        System.out.println("] 100%");
//    }
//}


public class Demo {
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

        System.out.println("Starting conversion...");

        try {
            simulateProgressBar();
            convertPDFToWordWithStyle(pdfFilePath, wordFilePath);
            System.out.println("PDF converted to Word successfully with styles preserved at " + wordFilePath);

            // Print completion timestamp
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("Completed at: " + timestamp);
        } catch (Exception e) {
            System.err.println("An error occurred while converting PDF to Word: " + e.getMessage());
        }
    }

    public static void convertPDFToWordWithStyle(String pdfFilePath, String wordFilePath) throws Exception {
        // Load the PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(pdfFilePath);

        // Configure Word save options to preserve layout
        DocSaveOptions saveOptions = new DocSaveOptions();
        saveOptions.setMode(DocSaveOptions.RecognitionMode.Flow); // Recognize flow of content
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);     // Save as DOCX
//        saveOptions.setPreserveFontSize(true);                   // Preserve font sizes
//        saveOptions.setReSaveFonts(true);                   // Preserve font sizes
//        saveOptions.setPreserveTableLayout(true);                // Preserve table layout
        saveOptions.setRecognizeBullets(true);                   // Recognize bullet lists

        // Save the document
        pdfDocument.save(wordFilePath, saveOptions);

        // Clean up resources
        pdfDocument.close();
    }

    private static void simulateProgressBar() {
        int progress = 0;
        System.out.print("Progress: [");

        while (progress <= 100) {
            try {
                Thread.sleep(100); // Simulate time delay
                System.out.print("#");
                progress += 5;
            } catch (InterruptedException e) {
                System.err.println("Progress simulation interrupted.");
                break;
            }
        }

        System.out.println("] 100%");
    }
}
