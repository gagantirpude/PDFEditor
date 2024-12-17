package com.gagan.utils;

import java.util.List;

public class OperationHandler {

    /**
     * Handles any PDF-related operation dynamically.
     * @param operationName Name of the operation being performed
     * @param inputFiles    List of input file paths
     * @param outputFile    Path of the output file
     * @param totalPages    Total number of pages involved
     * @param operationTask The specific task (Runnable) to execute
     */
    public static void handleOperation(String operationName, List<String> inputFiles, String outputFile, int totalPages, Runnable operationTask) {
        try {
            // Step 1: Show total pages and estimated time
            System.out.println("\nStarting " + operationName + "...");
            System.out.println("The selected PDF contains " + totalPages + " page(s).");
            TimeEstimator.displayEstimatedTime(totalPages);

            // Step 2: Professional waiting message for large PDFs
            if (totalPages > 4) {
                System.out.println("This is a large PDF operation. Please be patient, as this may take a bit longer than usual. 😊");
            }

            // Step 3: Progress bar initialization
            ProgressBar.startProgressBar(operationName, totalPages);

            // Step 4: Execute the operation
            operationTask.run();

            // Step 5: Complete the progress bar
            ProgressBar.completeProgressBar();

            // Step 6: Final success message
            System.out.println("\n🎉 [" + TimestampUtil.getCurrentTimestamp() + "] " + operationName + " completed successfully!");
            System.out.println("Output saved at: " + outputFile);

        } catch (Exception e) {
            System.err.println("Error occurred during " + operationName + ": " + e.getMessage());
        }
    }
}
