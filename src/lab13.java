//fendoglu
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lab13 {
    
    public ArrayList<Integer> dataList = new ArrayList<>();
    public void readData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    dataList.add(Integer.parseInt(line.trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long getTotalCount() {
        return dataList.stream().count();
    }
    public long getOddCount() {
        return dataList.stream().filter(x -> x % 2 != 0).count();
    }

    public long getEvenCount() {
        return dataList.stream().filter(x -> x % 2 == 0).count();
    }
    public long getDistinctGreaterThanFiveCount() {
        return dataList.stream().filter(x -> x > 5).distinct().count();
    }

    public Integer[] getResult1() {
        return dataList.stream()
                .filter(x -> x % 2 == 0 && x > 5 && x < 50)
                .sorted()
                .toArray(Integer[]::new);
    }
    public Integer[] getResult2() {
        return dataList.stream()
                .map(x -> x * x * 3)
                .limit(50)
                .toArray(Integer[]::new);
    }
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