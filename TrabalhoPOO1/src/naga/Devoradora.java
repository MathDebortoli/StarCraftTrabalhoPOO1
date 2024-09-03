package naga;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class Devoradora extends Naga {

    public Devoradora(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(100);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        System.out.println("Ataque Devoradora");
        if (l2.size() > 1) {
            Guerreiro comido = l2.get(1);

            if (comido instanceof Empalador) { //Tentou comer Empalador
                System.out.println("A Devoradora tentou comer empalador!");
                this.setEnergia(0);
                for (int i = 0; i < 4; i++) { //Criamos 4 servos
                    Guerreiro a = new Servo("servo_devoradora_" + i, 0, 0, 100);
                    l2.addLast(a);
                }
            } else {
                System.out.println("Comeu Alguem normal");
                causar_dano = alvo.tomarDano(comido.getEnergia() * 2); //Toma a energia do comido vezes 2
                comido.setEnergia(0); //foi devorado
            }
        } else {
            System.out.println("Devoradora Sozinha na Fila!");
        }
        return causar_dano;
    }

}
