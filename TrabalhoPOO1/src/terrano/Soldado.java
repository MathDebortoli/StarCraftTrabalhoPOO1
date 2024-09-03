package terrano;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Soldado extends Terrano {

    public Soldado(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Soldado");
        causar_dano = alvo.tomarDano(20);
        return causar_dano;
    }

}
