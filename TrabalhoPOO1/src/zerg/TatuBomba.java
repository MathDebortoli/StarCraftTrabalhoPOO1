package zerg;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class TatuBomba extends Zerg {

    public TatuBomba(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Tatu-Bomba");
        causar_dano = alvo.tomarDano(100);
        this.setEnergia(0);
        return causar_dano;
    }
}
