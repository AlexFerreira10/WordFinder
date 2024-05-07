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
                        sc.close();
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
                        System.out.println("\n...Pressione Enter para continuar...");
                        sc.nextLine();
                        clear();
                        break;
                    case 2:
                        System.out.println("Total de palavras: " + tree.getTotalWord());
                        System.out.println("\n...Pressione Enter para continuar...");
                        sc.nextLine();
                        clear();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        System.out.println("\n...Pressione Enter para continuar...");
                        sc.nextLine();
                        clear();
                }
            } while(option != 0);
        } catch(NumberFormatException e) {
            System.out.println("Você não pode digitar letras nesse campo!!");
        }
    }

    public static void menu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pesquise uma palavra para ser encontrada nos files!").append("\n------------ Menu ------------").append("\n [0] - Sair").append("\n [1] - Pesquisar").append("\n [2] - Total de Palavras")
                .append("\n Option: ");
        System.out.print(sb);
    }

    public static void clear(){
        try{
        String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            for(int i=0; i<50; i++){
                System.out.println();
            }
        }
        else{
            System.out.print("\033\143"); //A string é um código de escape ANSI, \033 indica o início de uma sequência de escape; \143 limpa o console

        }}
        catch(final Exception e){
            e.printStackTrace();
        }
    }
}