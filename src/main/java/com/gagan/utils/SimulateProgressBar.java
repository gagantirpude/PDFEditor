package com.gagan.utils;

public class SimulateProgressBar {

    public static void simulateProgressBar() {
        int totalSteps = 50; // Total length of the progress bar
        int sleepTime = 50; // Sleep time in milliseconds

        System.out.print("[");
        for (int i = 0; i < totalSteps; i++) {
            // Simulate work being done
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            // Update progress bar
            System.out.print("=");
        }
        System.out.println("]"); // Complete the progress bar
    }
}
