package application;

import structures.TreeAVL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TreeAVL tree = new TreeAVL();
        TreeAVL.getFiles().forEach(x -> x.read(tree));
        Scanner sc = new Scanner(System.in);
        int option = 7;
        try {
            do {
                Main.menu();
                option = Integer.parseInt(sc.nextLine());
                switch (option){
                    case 0 :
                        option = 0;
                        break;
                    case 1:
                        System.out.println("Digite a Palavra: ");
                        String word = sc.next();
                        sc.nextLine();
                        if(word.length() > 3) {
                            if(tree.search(word) != null){
                                tree.search(word).info();
                            } else {
                                System.out.println("Palavra não encontrada! ");
                            }
                        } else {
                            System.out.println("O tamanho da palavra precisa ser maior que 4!");
                        }
                        break;
                    case 2:
                        System.out.println("Total de palavras: " + tree.getTotalWord());
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while(option != 0);
        } catch(NumberFormatException e) {
            System.out.println("Você não pode digitar letras nesse campo!");
        }
    }

    public static void menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("------------ Menu ------------").append("\n [0] - Sair").append("\n [1] - Pesquisar").append("\n [2] - Total de Palavras")
                .append("\n Option: ");
        System.out.print(sb);
    }
}