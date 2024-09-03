package proton;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Mecanico;
import natureza.Natureza;

public class Transportadora extends Proton {

    private int qtd_Inter = 0;

    public Transportadora(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Mecanico();
        this.setMax_Energia(500);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Transportadora!");
        if (qtd_Inter < 8) { //MAXIMO DE 8 INTERPCTADORES
            qtd_Inter++;
        }
        causar_dano = alvo.tomarDano(25 * qtd_Inter); //25 vezes quantos intercptadores tem
        System.out.println("A transportadora atacou com: " + qtd_Inter + " intercptadores!");
        return causar_dano;
    }

}
