import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lab13 {
    
    public ArrayList<Integer> dataList = new ArrayList<>();

    // Reads the input file and stores values in the ArrayList [cite: 15, 16]
    public void readData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    dataList.add(Integer.parseInt(line.trim())); // [cite: 103]
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Return the number of values in the ArrayList [cite: 19, 20]
    public long getTotalCount() {
        return dataList.stream().count();
    }

    // Return the number of odd values [cite: 21, 22]
    public long getOddCount() {
        return dataList.stream().filter(x -> x % 2 != 0).count();
    }

    // Return the number of even values [cite: 23, 24]
    public long getEvenCount() {
        return dataList.stream().filter(x -> x % 2 == 0).count();
    }

    // Return number of distinct values greater than 5 [cite: 25, 26]
    public long getDistinctGreaterThanFiveCount() {
        return dataList.stream().filter(x -> x > 5).distinct().count();
    }

    // Even, > 5, < 50, sorted [cite: 29, 30]
    public Integer[] getResult1() {
        return dataList.stream()
                .filter(x -> x % 2 == 0 && x > 5 && x < 50)
                .sorted()
                .toArray(Integer[]::new);
    }

    // First 50, squared, multiplied by 3 [cite: 31, 33]
    public Integer[] getResult2() {
        return dataList.stream()
                .map(x -> x * x * 3)
                .limit(50)
                .toArray(Integer[]::new);
    }

    // Filter odd, multiply by 2, sort, skip 20, distinct [cite: 34, 35, 45]
    public Integer[] getResult3() {
        return dataList.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * 2)
                .sorted()
                .skip(20)
                .distinct()
                .toArray(Integer[]::new);
    }
}