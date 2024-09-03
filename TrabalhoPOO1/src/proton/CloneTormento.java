package proton;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class CloneTormento extends Proton {

    public CloneTormento(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(50);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Clone tormento nao pode atacar");
        return causar_dano;
    }

}
