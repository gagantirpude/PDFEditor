package com.gagan.utils;

//public class ProgressBar {
//
//
//
//    public static void displayProgressBar(String taskName) {
//        System.out.print(taskName + ": [");
//        int totalSteps = 50;
//        for (int i = 0; i < totalSteps; i++) {
//            try {
//                Thread.sleep(50); // Simulates processing time
//                System.out.print("#");
//            } catch (InterruptedException e) {
//                System.err.println("\nProgress simulation interrupted.");
//                break;
//            }
//        }
//        System.out.println("] Done!");
//    }
//
//
//    private static int totalUnits = 0;
//
//    public static void startProgressBar(String taskName, int total) {
//        totalUnits = total;
//        System.out.println(taskName + " Progress:");
//    }
//
//    public static void updateProgressBar(int completedUnits) {
//        int percent = (completedUnits * 100) / totalUnits;
//        StringBuilder progress = new StringBuilder("[");
//
//        int completedBlocks = percent / 2; // Assuming progress bar is 50 blocks
//        for (int i = 0; i < 50; i++) {
//            if (i < completedBlocks) progress.append("#");
//            else progress.append(" ");
//        }
//        progress.append("] ").append(percent).append("%");
//
//        System.out.print("\r" + progress);
//    }
//
//    public static void completeProgressBar() {
//        System.out.println("\nConversion completed successfully!");
//    }



//public class ProgressBar {
//    private static int totalSteps;
//    private static int currentProgress;
//
//    public static void startProgressBar(String taskName, int steps) {
//        totalSteps = steps;
//        currentProgress = 0;
//        System.out.println(taskName + " Progress:");
//        displayProgress();
//    }
//
//    public static void updateProgressBar(int step) {
//        currentProgress = step;
//        displayProgress();
//    }
//
//    private static void displayProgress() {
//        int percentage = (int) ((currentProgress / (double) totalSteps) * 100);
//
//        StringBuilder bar = new StringBuilder("[");
//        int completedBars = percentage / 5;
//        for (int i = 0; i < 20; i++) {
//            bar.append(i < completedBars ? "#" : " ");
//        }
//        bar.append("] ").append(percentage).append("%");
//        System.out.print("\r" + bar.toString());
//    }
//
//    public static void completeProgressBar() {
//        updateProgressBar(totalSteps);
//        System.out.println("\nTask completed successfully!");
//    }
//}


public class ProgressBar {
    private static int totalSteps;
    private static int currentProgress;

    public static void startProgressBar(String taskName, int steps) {
        totalSteps = steps;
        currentProgress = 0;
        System.out.println(taskName + " Progress:");
        displayProgress();
    }

    public static void updateProgressBar(int step) {
        currentProgress = step;
        displayProgress();
    }

    private static void displayProgress() {
        int percentage = (int) ((currentProgress / (double) totalSteps) * 100);

        StringBuilder bar = new StringBuilder("[");
        int completedBars = percentage / 5;
        for (int i = 0; i < 20; i++) {
            bar.append(i < completedBars ? "#" : " ");
        }
        bar.append("] ").append(percentage).append("%");
        System.out.print("\r" + bar.toString());
    }

    public static void completeProgressBar() {
        updateProgressBar(totalSteps);
        System.out.println("\nTask completed successfully!");
    }
}

