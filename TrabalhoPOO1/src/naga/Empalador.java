package naga;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Empalador extends Naga {

    public Empalador(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(400);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Empalador!");
        causar_dano = alvo.tomarDano(50);

        if ((l2.size() > 1) && this.getEnergia() < 100) { //Caso ele tenha menos de 100 de vida, e nao esteja sozinho na fila
            System.out.println("O Empalador comeu alguem!");
            Guerreiro comida = l2.get(1);
            comida.setEnergia(0); //Foi comido
            this.setEnergia(400); //Recupera sua vida
        }
        return causar_dano;
    }
}
