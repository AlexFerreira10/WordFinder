package application;

import structures.TreeAVL;
import structures.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        List<File> files = new ArrayList<>();
        files.addAll(Arrays.asList(
                new File("Amor", "/home/kali/Java-Projects/WordFinder/Files/Amor.txt"),
                new File("Canção do Exílio", "/home/kali/Java-Projects/WordFinder/Files/CancaodoExilio.txt"),
                new File("O tempo", "/home/kali/Java-Projects/WordFinder/Files/OTempo.txt"),
                new File("Soneto de Fidelidade", "/home/kali/Java-Projects/WordFinder/Files/SonetodeFidelidade.txt"),
                new File("Soneto de Fidelidade", "/home/kali/Java-Projects/WordFinder/Files/MeuDestino.txt")
        ));*/

       // files.forEach(x -> x.read(tree));

        TreeAVL tree = new TreeAVL();
        //tree.addFiles();
        TreeAVL.getFiles().forEach(x -> x.read(tree));


        tree.search("E").info();


        //tree.printInOrder(tree.getRoot());


        /* Test
        tree.insert("oi");
        tree.insert("ola");
        tree.insert("ta");
        System.out.println(tree.search("olA")); */

    }
}