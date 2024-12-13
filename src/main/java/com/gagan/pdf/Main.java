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
            System.out.println("5. Exit");
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
                    System.out.println("Exiting PDF Editor. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}