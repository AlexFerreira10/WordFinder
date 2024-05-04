package structures;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class File {

    private String name;
    private String path;

    public File(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> counterLine(File file, String name) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");

                    for (String word : words) {
                        if (name.equals(word)) { // Usando equals() para comparar strings
                            list.add(counter);
                        }
                    }
                }
                counter++;
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public int counterWord(File file, String name) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            long occurrences = reader.lines()
                    //Separa ou junta streams
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> word.equals(name))
                    .count();
            return (int) occurrences;
        }
    }

    public void read(TreeAVL tree) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");

                    for (String word : words) {
                        tree.insert(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
