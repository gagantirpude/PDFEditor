package com.gagan.utils;

public class TimeEstimator {

    // Constants: Average time per page (in milliseconds)
    private static final int TIME_PER_PAGE_SMALL_PDF = 200; // 200ms for small PDFs (<4 pages)
    private static final int TIME_PER_PAGE_LARGE_PDF = 100; // 100ms for large PDFs (>=4 pages)

    /**
     * Estimates the time required for an operation based on the page count.
     *
     * @param totalPages The total number of pages in the document.
     * @return Estimated time in seconds.
     */
    public static int estimateTimeInSeconds(int totalPages) {
        int averageTimePerPage = (totalPages < 4) ? TIME_PER_PAGE_SMALL_PDF : TIME_PER_PAGE_LARGE_PDF;
        return (totalPages * averageTimePerPage) / 1000; // Convert milliseconds to seconds
    }

    /**
     * Displays the estimated time to the user.
     *
     * @param totalPages The total number of pages.
     */
    public static void displayEstimatedTime(int totalPages) {
        int estimatedTime = estimateTimeInSeconds(totalPages);
        System.out.println("Estimated time to complete this operation: ~" + estimatedTime + " seconds.");
    }
}
