package zerg;

import java.util.LinkedList;
import main.Guerreiro;
import natureza.Natureza;
import natureza.Organico;

public class LordDasCastas extends Zerg {

    public LordDasCastas(String nome, int idade, double peso, int energia) {
        super(nome, idade, peso, energia);
        Natureza nat = new Organico();
        this.setMax_Energia(200);
        this.setNatureza(nat);
    }

    @Override
    public boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) {
        Guerreiro filho;
        int num;
        System.out.println("Ataque Lord Das Castas!");
        num = (int) (Math.random() * 3); //SORTEIA 0,1,2;

        switch (num) {
            case 0 -> {
                //CRIA 3 ZERGINIDEOS
                System.out.println("O Lord Criou 3 zergs!");
                for (int i = 0; i < 3; i++) {
                    filho = new Zergnideo(getNome() + "_zerginideo_" + i, 0, 0, 50);
                    l2.addLast(filho);
                }
            }
            case 1 -> {
                //CRIA 2 TATU-BOMBA
                System.out.println("O Lord Criou 2 tatus!");
                for (int i = 0; i < 2; i++) {
                    filho = new TatuBomba(getNome() + "_tatubomba_" + i, 0, 0, 100);
                    l2.addLast(filho);
                }
            } //CRIA 1 INFESTADOR
            default -> {
                System.out.println("O Lord Criou 1 infestador");
                filho = new Infestador(getNome() + "_infestador", 0, 0, 100);
                l2.addLast(filho);
            }
        }
         return causar_dano;
    }
}
