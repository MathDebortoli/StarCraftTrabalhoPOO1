package utilidade;

import main.Guerreiro;

public class FimFilaException extends Exception {

    private final Guerreiro g_dead;
    private final Guerreiro atacante;

    public FimFilaException(Guerreiro morto, Guerreiro atacante) {
        this.g_dead = morto;
        this.atacante = atacante;
    }

    public void Imprimir() {
        System.out.println("\n=============================== | FIM DO JOGO | ===============================\n");
        System.out.println("=====| Dados do Ultimo Morto| =====");
        System.out.println("Nome: " + g_dead.getNome() + "\nIdade: " + g_dead.getIdade() + "\nPeso: " + g_dead.getPeso());
        System.out.println("=====| Dados do Ultimo A Atacar| =====");
        System.out.println("Nome: " + atacante.getNome() + "\nIdade: " + atacante.getIdade() + "\nPeso: " + atacante.getPeso());

    }

}
