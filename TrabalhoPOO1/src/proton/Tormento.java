package proton;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Tormento extends Proton {

    private int i = 1;

    public Tormento(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque tormento");
        causar_dano = alvo.tomarDano(30); // ele sempre vai atacar

        if (vez == 1) {
            Guerreiro clone = new CloneTormento("Clone " + getNome() + "_" + i++, 0, 0, 50);
            // Adicione o clone ao início da fila
            l1.addFirst(clone);
            // Mova o Tormento para o final da fila
            l1.remove(this);
            l1.addLast(this);
        }
        return causar_dano;

    }
}
