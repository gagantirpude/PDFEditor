package com.gagan.pdf;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPDF Editor Options:");
            System.out.println("1. Merge PDF Files");
            System.out.println("2. Split PDF File");
            System.out.println("3. Extract Pages from PDF");
            System.out.println("4. Convert PDF to Word");
            System.out.println("5. Convert PDF to JPG");
            System.out.println("6. Convert PDF to HTML");
            System.out.println("7. Convert PDF to PPTX");
            System.out.println("8. Convert PDF to XLSX");
            System.out.println("9. Convert PDF to CSV");
            System.out.println("10. Convert PDF to TXT");
            System.out.println("11. Convert PDF to LaTex");
            System.out.println("12. Convert PDF to EPUB");
            System.out.println("13. Convert PDF to Markdown");
            System.out.println("14. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    MergePDF.mergeOperation(scanner);
                    break;
                case 2:
                    SplitPDF.splitOperation(scanner);
                    break;
                case 3:
                    ExtractPages.extractOperation(scanner);
                    break;
                case 4:
                    ConvertPDFToWord.convertOperation(scanner);
                    break;
                case 5:
                    ConvertPDFToJPG.convertOperation(scanner);
                    break;
                case 6:
                    ConvertPDFToHTML.convertOperation(scanner);
                    break;
                case 7:
                    ConvertPDFToPPTX.convertOperation(scanner);
                    break;
                case 8:
                    ConvertPDFToXLSX.convertOperation(scanner);
                    break;
                case 9:
                    ConvertPDFToCSV.convertOperation(scanner);
                    break;
                case 10:
                    ConvertPDFToTXT.convertOperation(scanner);
                    break;
                case 11:
                    ConvertPDFToLaTex.convertOperation(scanner);
                    break;
                case 12:
                    ConvertPDFToEPUB.convertOperation(scanner);
                    break;
                case 13:
                    ConvertPDFToMarkdown.convertOperation(scanner);
                    break;
                case 14:
                    System.out.println("Exiting PDF Editor. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}