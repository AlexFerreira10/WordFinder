package structures;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

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

    public List<Integer> counterLine(String word) {
        return null;
    }

    public int counterWord(String word) {
        return 0;
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
