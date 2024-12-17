package com.gagan.utils;

import com.aspose.pdf.Document;

import java.util.concurrent.atomic.AtomicInteger;


public class PDFUtils {

    // Get the total number of pages in the PDF using Aspose
    public static int getAsposePDFPageCount(String filePath) {
        try (Document pdfDocument = new Document(filePath)) {
            AtomicInteger pageCount = new AtomicInteger(pdfDocument.getPages().size());
            return pageCount.get();
        } catch (Exception e) {
            System.err.println("Error retrieving page count: " + e.getMessage());
            return 0;
        }
    }
}

