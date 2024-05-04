package structures;

import java.lang.Comparable;

public class Word implements Comparable<Word> {

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
    }

    @Override
    public int compareTo(Word otherWord) {
        return this.name.compareToIgnoreCase(otherWord.getName());
    }
}
