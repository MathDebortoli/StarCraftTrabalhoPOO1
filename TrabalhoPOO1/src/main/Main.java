package main;

import java.util.LinkedList;
import proton.Tormento;
import utilidade.LeituraArq;
import utilidade.AnalisarLista;
import static utilidade.AnalisarLista.imprimirEnergias;
import utilidade.FimFilaException;
import utilidade.Sortear;
import zerg.Infestador;

public class Main {

    public static void main(String[] args) {
        LinkedList<Guerreiro> l1 = LeituraArq.lerArquivo1();
        LinkedList<Guerreiro> l2 = LeituraArq.lerArquivo2();
        int cont = 0, qtd_guerreiros = (l1.size() + l2.size());

        boolean causar_dano = false;

        realizarAnalisesIniciais(l1, l2);

        System.out.println("\n\n=============================== |JOGO INICIADO| ===============================\n");
        try {
            while (!l1.isEmpty() && !l2.isEmpty()) {
                //Criamos um contador para saber se ja percorreu pelo menos na metade dos guerreiros
                //pois como a cada rodada acontece dois ataques, andando de dois em dois.

              if (cont >= qtd_guerreiros) { //caso ele ja tenha passado em todos os guerreiros
                    if (causar_dano == true) { //caso tenha ocorrido pelo menos um tomar_dano
                        cont = 0; //reseta contador
                        causar_dano = false; //reseta tomar dano
                    } else { //se nao quebramos o ciclo pois esta travado sem novos ataques.
                        break;
                    }
                }


                Guerreiro g1 = l1.getFirst();
                Guerreiro g2 = l2.getFirst();

                System.out.println("======| ENERGIAS PRE-ATAQUES| =====");
                imprimirEnergias(l1, l2);
                causar_dano = realizarAtaque(g1, g2, l1, l2, causar_dano);

                System.out.println("\n\n======| ENERGIAS POS-ATAQUES| =====");
                imprimirEnergias(l1, l2);

                if (!g1.verificarMorte()) { //Caso nao morreu joga pro final da fila
                    l1.remove(g1);
                    l1.addLast(g1);
                }
                if (!g2.verificarMorte()) {//caso nao tenha morrido
                    l2.remove(g2);
                    l2.addLast(g2);
                }
                if (verificarEmpata(l1, l2)) { //Caso deu empate
                    break;
                }
                procurarMortos(l1, l2);
                cont++;

                System.out.println("\n\n=============================== |FIM DA RODADA| ===============================\n");
            }
        } catch (FimFilaException ex) {
            ex.Imprimir();
        }
        determinarVencedor(l1, l2, causar_dano);
    }

 
private static void procurarMortos(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) throws FimFilaException {
    System.out.println("======| FALECIMENTOS LISTA 1 |======");
    for (int i = l1.size() - 1; i >= 0; i--) {
        gerenciarMorte(l1.get(i), l1, l2.getLast());
    }
    System.out.println("\n======| FALECIMENTOS LISTA 2 |======");
    for (int i = l2.size() - 1; i >= 0; i--) {
        gerenciarMorte(l2.get(i), l2, l1.getLast());
    }
}

    private static boolean verificarEmpata(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) {
        if (l1.size() == 1 && l2.size() == 1) {
            Guerreiro g1 = l1.get(0);
            Guerreiro g2 = l2.get(0);
            if (g1.verificarMorte() && g2.verificarMorte()) {
                l1.removeFirst(); //REMOVEMOS OS DOIS MANUALMENTE POIS INTERROMPEMOS O LOOP
                l2.removeFirst();
                
                System.out.println("=====| Morte Conjunta| =======");
                g1.imprimir();
                g2.imprimir();
                return true;
            }

        }
        return false;
    }

    private static void realizarAnalisesIniciais(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) {
        AnalisarLista.somarPeso(l1, l2);
        AnalisarLista.maiorIdade(l1, l2);
    }

    private static boolean realizarAtaque(Guerreiro g1, Guerreiro g2, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, boolean causar_dano) {
        System.out.println("=======|ATAQUE|======");

        if (Sortear.realizarSorteio() == 1) {
            causar_dano = realizarAtaqueDoG1(g1, g2, l1, l2, causar_dano);
        } else {
            causar_dano = realizarAtaqueDoG2(g2, g1, l1, l2, causar_dano);
        }
        return causar_dano;
    }

    private static boolean realizarAtaqueDoG1(Guerreiro g1, Guerreiro g2, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, boolean causar_dano) {
        if (!g1.verificarMorte()) {
            System.out.println("G1 Ataca primeiro!");
            causar_dano = g1.atacar(g2, l1, l2, 1, causar_dano);

            if (g1.getEnergia() == 0) { //CASO ELE TENHA MORRIDO ATACANDO, EXEMPLO: DEVORADORA
                if (l1.size() > 1) {
                    g1 = l1.get(1); //PASSAMOS PRO PROXIMO
                }
            }

            if (g1 instanceof Tormento) {
                g1 = l1.getFirst(); // pra quando cria um clone ele tem que colocar o clone no começo pra receber o ataque
            }
            if (!g2.verificarMorte()) {
                causar_dano = g2.atacar(g1, l1, l2, 2, causar_dano);
            }
        }
        return causar_dano;
    }

    private static boolean realizarAtaqueDoG2(Guerreiro g2, Guerreiro g1, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, boolean causar_dano) {
        System.out.println("G2 Ataca primeiro!");
        causar_dano = g2.atacar(g1, l1, l2, 1, causar_dano);

        if (g2.getEnergia() == 0) { //CASO ELE TENHA MORRIDO ATACANDO, EXEMPLO: DEVORADORA
            if (l2.size() > 1) {
                g2 = l2.get(1); //PASSAMOS PRO PROXIMO
            }
        }

        if (!g1.verificarMorte() && !(g2 instanceof Infestador)) {
            causar_dano = g1.atacar(g2, l1, l2, 2, causar_dano);
        }

        return causar_dano;
    }

    private static void gerenciarMorte(Guerreiro guerreiro, LinkedList<Guerreiro> lista, Guerreiro atacante) throws FimFilaException {
        if (guerreiro.verificarMorte()) {
            System.out.println("O " + guerreiro.getNome() + " esta morto");
            lista.remove(guerreiro);
            if (lista.isEmpty()) {
                throw new FimFilaException(guerreiro, atacante);
            }
        }
    }

    private static void determinarVencedor(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, boolean causar_dano) {
        System.out.println("\n=======| Determinar Vencedor |======");

        if (causar_dano == false) {
            empateTecnico(l1, l2);
        } else if (l1.isEmpty() && l2.isEmpty()) {
            System.out.println("As duas filas foram eliminadas! O Jogo terminou em Empate!");
        } else if (l1.isEmpty()) {
            System.out.println("Zergs e Nagas Venceram");
        } else {
            System.out.println("Protons e Terranos Venceram!");
        }
    }

    private static void empateTecnico(LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2) {
        System.out.println("Ocorreu um Empate Tecnico, o Total de competidores que restavam: " + (l1.size() + l2.size()));
        System.out.println("\n----- lista 1 ------");
        for (Guerreiro a : l1) {
            a.imprimir();
        }
        System.out.println("\n----- lista 2 ------");
        for (Guerreiro a : l2) {
            a.imprimir();
        }
    }
}
