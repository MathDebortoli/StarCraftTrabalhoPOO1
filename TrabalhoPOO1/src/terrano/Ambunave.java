package terrano;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Mecanico;
import natureza.Natureza;
import natureza.Organico;

public class Ambunave extends Terrano {

    public Ambunave(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Mecanico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Cura Ambunave");
        for (Guerreiro aliado : l1) {
            if (!(aliado.getNatureza() instanceof Mecanico)) { // se o aliado for diferente da ambunave e o aliado for diferente de mecanico
                aliado.setEnergia(aliado.getEnergia() + 50);
                aliado.verificarMaxEnerg();       
                } // funcao para verificar se o aliado ta com a energia sobresalente ao que pode ter
            }
        return causar_dano;
        }

}
