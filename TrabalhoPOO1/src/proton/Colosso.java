package proton;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Mecanico;
import natureza.Natureza;

public class Colosso extends Proton{

    public Colosso(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Mecanico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Colosso!");
        for (Guerreiro p : l2) { //PERCORRE A LISTA 2 E DA DANO EM TODOS
            causar_dano = p.tomarDano(20);
        }
        this.recuperacaoGelada();
        return causar_dano;
    }

}
