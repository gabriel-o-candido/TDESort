import java.io.*;
import java.util.*;

public class DataReader {
    public static int[] readData(String filePath) throws IOException {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove espaços em branco
                if (line.isEmpty() || !line.matches("\\d+")) {
                    // Ignora linhas vazias ou não numéricas
                    continue;
                }
                list.add(Integer.parseInt(line));
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
