package utilidade;

import java.util.LinkedList;
import main.Guerreiro;

public class AnalisarLista {

    public static void somarPeso(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) { //CASH EXPLICITO
        double i = 0;

        for (Guerreiro g : l1) { //PERCORRENDO TODA A LISTA COM O OBJETO G
            i += g.getPeso();
        }
        System.out.println("\nTerranos e Protons pesam: " + i + " - unidades");
        i = 0; //RESETA O PESO

        for (Guerreiro g : l2) {
            i += g.getPeso(); //PEGAMOS O PESO DO OBJETO G
        }
        System.out.println("Zergnideos e Nagas pesam: " + i + " - unidades");

    }

    public static void maiorIdade(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) {
        int maior = l1.get(0).getIdade(); //SALVAMOS A PRIMEIRA IDADE 
        String nome = "";

        for (Guerreiro g : l1) {
            if (maior < g.getIdade()) {
                maior = g.getIdade(); //SALVA A IDADE
                nome = g.getNome(); //SALVA O NOME DESSE CARA
            }
        }
        for (Guerreiro g : l2) {
            if (maior < g.getIdade()) {
                maior = g.getIdade();
                nome = g.getNome();
            }
        }
        System.out.println(nome + " eh o mais velho " + "(" + maior + " unidades)\n");
    }

    public static void imprimirEnergias(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) {
        for (Guerreiro g : l1) {
            System.out.println(g.getNome() + " possui " + g.getEnergia() + " de energia.");
        }
        System.out.println("====================");
        for (Guerreiro g : l2) {
            System.out.println(g.getNome() + " possui " + g.getEnergia() + " de energia.");
        }
        System.out.println("====================\n\n");
    }

}
