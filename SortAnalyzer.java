import java.io.*;
import java.util.*;

public class SortAnalyzer {
    public static void analyze(String filePath) throws IOException {
        int[] data = DataReader.readData(filePath);

        for (String sortType : List.of("Bubble", "Insertion", "Quick")) {
            int[] tempData = Arrays.copyOf(data, data.length);

            long startTime = System.nanoTime();

            switch (sortType) {
                case "Bubble" -> SortAlgorithms.bubbleSort(tempData);
                case "Insertion" -> SortAlgorithms.insertionSort(tempData);
                case "Quick" -> SortAlgorithms.quickSort(tempData, 0, tempData.length - 1);
            }

            long endTime = System.nanoTime();
            System.out.printf("%s Sort levou %d ns para %s%n", sortType, (endTime - startTime), filePath);
        }
    }
}
