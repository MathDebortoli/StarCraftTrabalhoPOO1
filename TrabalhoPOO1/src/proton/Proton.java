package proton;

import main.Guerreiro;

public abstract class Proton extends Guerreiro {

    public Proton(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
    }

    public void recuperacaoGelada() {
        if (this.getEnergia() < (this.getMax_Energia() / 2)) {
            this.setEnergia(this.getEnergia() + (int) (this.getMax_Energia() * 0.05)); //ENERGIA ATUAL + 5% Do maximo
            System.out.println(this.getNome() + " Realizou Recuperacao Gelada!");
        }
    }
    
}
