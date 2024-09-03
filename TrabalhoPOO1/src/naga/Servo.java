package naga;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Servo extends Naga {

    public Servo(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Servo!");
        
        if (alvo.getNatureza() instanceof Organico organico) { //CASO SEJA TERRANO NAO MECANICO
            causar_dano = alvo.tomarDano(0); //PARA ELE ATIVAR O VENENO QUE JA ESTIVER NELE
            int brotos = organico.getBrotos();// Obter o valor atual
            organico.setBrotos(brotos++); // Incrementar o valor
            System.out.println("O total de brotos que esse alvo possui eh: " + brotos);
        }
        return causar_dano;
    }
    
}
