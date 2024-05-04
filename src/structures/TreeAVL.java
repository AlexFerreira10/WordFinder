package structures;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TreeAVL {

    protected static List<File> files = new ArrayList<>();

    private Word root;
    private int totalWord;
    private boolean increased;
    private boolean decreased;

    public TreeAVL(){
    }

    public static List<File> getFiles() {
        addFiles();
        return files;
    }

    public Word getRoot() {
        return root;
    }

    public void setRoot(Word root) {
        this.root = root;
    }

    public int getTotalWord() {
        return totalWord;
    }

    public void setTotalWord(int totalWord) {
        this.totalWord = totalWord;
    }

    public boolean isIncreased() {
        return increased;
    }

    public void setIncreased(boolean increased) {
        this.increased = increased;
    }

    public boolean isDecreased() {
        return decreased;
    }

    public void setDecreased(boolean decreased) {
        this.decreased = decreased;
    }

    private static void addFiles() {
        files.addAll(Arrays.asList(
                new File("Amor", "/home/kali/Java-Projects/WordFinder/Files/Amor.txt"),
                new File("Canção do Exílio", "/home/kali/Java-Projects/WordFinder/Files/CancaodoExilio.txt"),
                new File("O tempo", "/home/kali/Java-Projects/WordFinder/Files/OTempo.txt"),
                new File("Soneto de Fidelidade", "/home/kali/Java-Projects/WordFinder/Files/SonetodeFidelidade.txt"),
                new File("Meu Destino", "/home/kali/Java-Projects/WordFinder/Files/MeuDestino.txt"),
                new File("Jose", "/home/kali/Java-Projects/WordFinder/Files/Jose.txt"),
                new File("Versos Íntimos", "/home/kali/Java-Projects/WordFinder/Files/Jose.txt"),
                new File("Casamento", "/home/kali/Java-Projects/WordFinder/Files/Casamento.txt"),
                new File("Aninha e suas Pedras", "/home/kali/Java-Projects/WordFinder/Files/AninhaESuasPedras.txt"),
                new File("O Apanhador de Desperdícios", "/home/kali/Java-Projects/WordFinder/Files/OApanhadordeDesperdicios.txt")
        ));
    }

    public Word search(String word) {
        Word aux = root;
        Word father = null;

        while (aux != null) {
            if (word.compareToIgnoreCase(aux.getName()) < 0) { //word < current.getName()
                father = aux;
                aux = aux.getSonLeft();
            } else if (word.compareToIgnoreCase(aux.getName()) > 0) {
                father = aux;
                aux = aux.getSonRight();
            } else {
                aux.setFather(father);
                return aux;
            }
        }
        return null;
    }

    public void insert(String word) {
        if(search(word) == null) {
            recursiveInsert(root, word);
            totalWord++;
        }
    }

    private void recursiveInsert(Word current, String word) {
        // Se o nó atual for nulo, cria um novo nó com os dados fornecidos
        // e atualiza a raiz se estiver nula
        if (current == null) {
            Word newWord = new Word(word, 0);
            if (root == null) {
                root = newWord;
            }
            current = newWord;
            increased = true;
            return;
        } else if (word.compareToIgnoreCase(current.getName()) < 0) { //word < current.getName()
            // Se os dados forem menores que os dados do nó atual
            if (current.getSonLeft() == null) {
                // Se o filho esquerdo for nulo, cria um novo nó com os dados fornecidos
                // e define-o como o filho esquerdo do nó atual
                Word newWord = new Word(word, 0);
                current.setSonLeft(newWord);
                increased = true;
            } else {
                // Caso contrário, insere recursivamente os dados na subárvore esquerda
                recursiveInsert(current.getSonLeft(), word);
                if (increased) {
                    // Se a altura da subárvore aumentou, atualiza o fator de balanceamento do nó atual
                    current.setbF(current.getbF() - 1);
                }
            }
        } else {
            // Se os dados forem maiores ou iguais aos dados do nó atual
            if (current.getSonRight() == null) {
                // Se o filho direito for nulo, cria um novo nó com os dados fornecidos
                // e define-o como o filho direito do nó atual
                Word newWord = new Word(word, 0);
                current.setSonRight(newWord);
                increased = true;
            } else {
                // Caso contrário, insere recursivamente os dados na subárvore direita
                recursiveInsert(current.getSonRight(), word);
                if (increased) {
                    // Se a altura da subárvore aumentou, atualiza o fator de balanceamento do nó atual
                    current.setbF(current.getbF() + 1);
                }
            }
        }
        // Realiza rotação se necessário
        doRotation(current);

        // Se o fator de balanceamento for 0 e o increased for verdadeiro, define increased como falso
        if (increased && current.getbF() == 0) {
            increased = false;
        }
    }

    private void doRotation(Word father){
        Word son;
        Word grandchild; // If need double rotation

        if(father.getbF() == -2){ //right rotation
            son = father.getSonLeft();

            if(son.getbF() == -1) { //Default right
                father.setbF(0);
                son.setbF(0);
                rightRotation(father);
            }
            else if(son.getbF() == 0) { //Default Right
                father.setbF(-1);
                son.setbF(-1);
                rightRotation(father);
            }
            else if(son.getbF() == 1){ //Double right
                grandchild = son.getSonRight();
                if(grandchild.getbF() == -1) {
                    father.setbF(1);
                    son.setbF(0);
                }
                else if(grandchild.getbF() == 0){
                    father.setbF(0);
                    son.setbF(0);
                }
                else if(grandchild.getbF() == 1){
                    father.setbF(0);
                    son.setbF(-1);
                }
                grandchild.setbF(0);
                leftRightRotation(father);
            }
            else if (father.getbF() == 2) { // Left Rotation
                son = father.getSonRight();

                if(son.getbF() == 1) { //Default Left
                    father.setbF(0);
                    son.setbF(0);
                    leftRotation(father);
                }
                else if(son.getbF() == 0) { //Default Left
                    father.setbF(1);
                    son.setbF(-1);
                    leftRotation(father);
                }
                else if(son.getbF() == -1){ //Double Left
                    grandchild = son.getSonLeft();
                    if(grandchild.getbF() == -1) {
                        father.setbF(0);
                        son.setbF(1);
                    }
                    else if(grandchild.getbF() == 0){
                        father.setbF(0);
                        son.setbF(0);
                    }
                    else if(grandchild.getbF() == 1){
                        father.setbF(-1);
                        son.setbF(0);
                    }
                    grandchild.setbF(0);
                    rightLeftRotation(father);
                    leftRightRotation(father);
                }
            }
        }
    }

    // HLeft > HRight
    // Case 5H 4H H3H
    public void rightRotation(Word father) {
        Word newFather = father.getSonLeft();
        father.setSonLeft(newFather.getSonRight());
        newFather.setSonRight(father);
        father = newFather;
    }//-> 4 H3H H5H

    // HRigth > HLeft
    // Case H3 H4 H5H
    public void leftRotation(Word father) {
        Word newFather = father.getSonRight();
        father.setSonRight(newFather.getSonLeft());
        newFather.setSonLeft(father);
        father = newFather;
    }//-> 4 H3H H5H

    //Case 5H H3 H4H
    public void leftRightRotation(Word father) {
        Word son = father.getSonLeft();
        leftRotation(son); //-> 5H 4H H3H
        father.setSonLeft(son);
        rightRotation(father); //-> 4 H3H H5H
    }

    //Case H3 5H H4H
    public void rightLeftRotation(Word father) {
        Word son = father.getSonRight();
        rightRotation(son); //-> H3 H4 H5H
        father.setSonRight(son);
        leftRotation(father); //-> 4 H3H H5H
    }

    public void printInOrder(Word currentNode) {
        if(currentNode != null){
            printInOrder(currentNode.getSonLeft());
            System.out.print(currentNode.getName() + ", ");
            printInOrder(currentNode.getSonRight());
        }
    }
}
