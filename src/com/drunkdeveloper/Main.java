package com.drunkdeveloper;

import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    private static int MAX_DATA_VALUE = 1000;

    static class Operation {
        int comparison;
        int swap;
    }

    public static void main(String[] args) {
        int[] sizes = {500, 5000, 15000};
        List<Integer> data;

        // 1. generate random data value
        // 2. write data value to file
        // Uncomment these 3 lines to generate new dataset.
//        for (int size : sizes) {
//            data = generateRandomData(size);
//            writeDataToFile(data);
//        }

        // 3. read data value from file
        // 4. run bubble sort algorithm
        // 5. show results
        for (int size : sizes) {
            data = readDataFromFile("input-file-random-" + size + ".txt");
            Operation operation = bubbleSort(data);
            System.out.println("Bubble Sort \tsize: " + data.size() + "\t\tcomparisons: " + operation.comparison + "\t\tswaps: " + operation.swap);
        }
        System.out.println();

        // 6. read data value from file
        // 7. run selection sort algorithm
        // 8. show results
        for (int size : sizes) {
            data = readDataFromFile("input-file-random-" + size + ".txt");
            Operation operation = selectionSort(data);
            System.out.println("Selection Sort \tsize: " + data.size() + "\t\tcomparisons: " + operation.comparison + "\t\tswaps: " + operation.swap);
        }
    }

    public static List<Integer> generateRandomData(@NotNull int n) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(MAX_DATA_VALUE));
        }
        return numbers;
    }

    public static void writeDataToFile(@NotNull List<Integer> data) {
        try {
            Path file = Paths.get("input-file-" + data.size() + ".txt");
            Files.write(file, data.stream().map(Object::toString).collect(Collectors.toList()), Charset.forName("UTF-8"));
//            System.out.println(data.size() + " data values written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readDataFromFile(@NotNull String filename) {
        List<String> data = new ArrayList<>();
        try {
            Path file = Paths.get(filename);
            data = Files.readAllLines(file, Charset.forName("UTF-8"));
//            System.out.println(data.size() + " data values read from file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Operation bubbleSort(@NotNull List<Integer> A) {
        // A[0] to A[n-1] is the array to sort
        int n = A.size();
        boolean swapped = true;
        Operation operation = new Operation(); // 0: comparison, 1: swap

        while (swapped) {
            swapped = false;
            for (int i = 1; i <= n - 1; i++) {
                if (A.get(i - 1) > A.get(i)) {
                    int temp = A.get(i - 1);
                    A.set(i - 1, A.get(i));
                    A.set(i, temp);
                    swapped = true;

                    // swap operation performed
                    operation.swap++;
                }

                // comparison operation performed
                operation.comparison++;
            }
            n = n - 1;
        }

        return operation;
    }

    private static Operation selectionSort(@NotNull List<Integer> A) {
        // A[0] to A[n-1] is the array to sort
        int i, j;
        int n = A.size();
        Operation operation = new Operation();

        // advance the position through the entire array
        // (could do j < n-1 because single element is also min element)
        for (j = 0; j < n - 1; j++) {
            // find the min element in the unsorted A[j .. n-1]

            // assume the min is the first element
            int indexOfMinElement = j;
            // test against elements after j to find the smallest
            for (i = j + 1; i < n; i++) {
                // if this element is less, then it is the new minimum
                if (A.get(i) < A.get(indexOfMinElement)) {
                    // found new minimum; remember its index
                    indexOfMinElement = i;
                }

                // comparison operation performed
                operation.comparison++;
            }

            if (indexOfMinElement != j) {
                int temp = A.get(j);
                A.set(j, A.get(indexOfMinElement));
                A.set(indexOfMinElement, temp);

                // swap operation performed
                operation.swap++;
            }
        }

        return operation;
    }
}
