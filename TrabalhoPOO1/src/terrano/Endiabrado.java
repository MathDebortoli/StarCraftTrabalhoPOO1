
package terrano;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Mecanico;
import natureza.Natureza;

public class Endiabrado extends Terrano{

    public Endiabrado(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Mecanico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Endiabrado");
        Guerreiro aux;
        int dano = 15;
        for (int i = 0; i < Math.min(3, l2.size()); i++) { //Pego o minimo entre o tamanho da lista e 3
            aux = l2.get(i);
            causar_dano =  aux.tomarDano(dano);
            dano -= 5; //Vou diminuindo o dano de 5 em 5
        }
        return causar_dano;
    }

}
