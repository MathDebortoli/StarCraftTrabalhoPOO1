package zerg;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Infestador extends Zerg {

    private int i = 1;

    public Infestador(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Infestador");

        if (vez == 1) { //CASO ATACOU PRIMEIRO]
            System.out.println("Infestador Controlou o Alvo");
            if (l1.size() > 1) {
                l1.remove(0);
                alvo.atacar(l1.getFirst(), l2, l1, vez,causar_dano);
                l1.addFirst(alvo);
            } else {
                System.out.println("O alvo nao pode se automutilar"); // mesmo se for ambunave ela nao precisa curar pois ja perdeu
            }

        } else { //CASO SEJA O SEGUNDO
            System.out.println("Infestador Criou um Zerg");
            Guerreiro filho = new Zergnideo(this.getNome() + "zerg " + i++, 0, 0, 50);

            l2.addLast(filho);
        }
        return causar_dano;
    }

}
