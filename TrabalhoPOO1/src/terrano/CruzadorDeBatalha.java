package terrano;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Mecanico;
import natureza.Natureza;

public class CruzadorDeBatalha extends Terrano{
    private int feixe=1;

    public CruzadorDeBatalha(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Mecanico();
        this.setMax_Energia(1000);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Cruzador de Batalha!");
        if(this.feixe != 3){ //GOLPE SIMPLES
            System.out.println("Ataque Simples!");
            causar_dano = alvo.tomarDano(50);
            this.feixe++;
        }
        else{ //GOLPE CARREGADO
            System.out.println("Ataque Carregado!");
            alvo.setEnergia(0);
            causar_dano = true;
            this.feixe=0; //RESETA O FEIXE
        }
        return causar_dano;
    }

}