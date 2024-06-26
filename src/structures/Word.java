package structures;

import javax.xml.stream.events.EndDocument;
import java.lang.Comparable;
import java.util.List;
import java.io.IOException;

public class Word extends TreeAVL implements Comparable<Word> {

    private String name;
    private Word father;
    private Word sonLeft;
    private Word sonRight;
    private int bF;

    public Word(String name) {
       this.name = name;
    }

    public Word(String name, int bF) {
        this.name = name;
        this.bF = bF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word getFather() {
        return father;
    }

    public void setFather(Word father) {
        this.father = father;
    }

    public Word getSonLeft() {
        return sonLeft;
    }

    public void setSonLeft(Word sonLeft) {
        this.sonLeft = sonLeft;
    }

    public Word getSonRight() {
        return sonRight;
    }

    public void setSonRight(Word sonRight) {
        this.sonRight = sonRight;
    }

    public int getbF() {
        return bF;
    }

    public void setbF(int bF) {
        this.bF = bF;
    }

    public void info() {

        int totalOccurrences = files.stream()
                .mapToInt(file -> {
                    try {
                        return file.counterWord(file, name);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return 0;
                    }
                })
                .sum();

        System.out.println("------------------------------"+"\n\nTotal de ocorrências da palavra \"" + name + "\": " + totalOccurrences + "\n\n\nOcorrência(s): ");

        List<Integer> list;
        String poem = null;

        for(File file : files){
            poem = file.getName();
            list = file.counterLine(file, name);
            if(!list.isEmpty()) {
                boolean lineFound = false;
                int listSizeVar = list.size();
                System.out.print(poem + " - Linha(s): ");
                for (int i = 0; i < listSizeVar; i++) {
                    Integer lineNumber = list.get(i);
                    if (lineNumber != null) {
                        System.out.print(lineNumber);
                        if (list.indexOf(lineNumber) < list.size() - 1) {
                            System.out.print(", ");
                        } else {
                            System.out.print(". ");
                        }
                        lineFound = true;
                    } else {
                        break;
                    }
                }
                if (!lineFound) {
                    System.out.print(". ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public int compareTo(Word otherWord) {
        return this.name.compareToIgnoreCase(otherWord.getName());
    }
}
