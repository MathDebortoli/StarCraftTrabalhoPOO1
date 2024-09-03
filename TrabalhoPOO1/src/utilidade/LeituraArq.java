package utilidade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import main.Guerreiro;
import naga.Devoradora;
import naga.Empalador;
import naga.Servo;
import proton.Colosso;
import proton.Fanaticu;
import proton.Tormento;
import proton.Transportadora;
import terrano.Ambunave;
import terrano.CruzadorDeBatalha;
import terrano.Endiabrado;
import terrano.Soldado;
import zerg.Infestador;
import zerg.LordDasCastas;
import zerg.TatuBomba;
import zerg.Zergnideo;

public class LeituraArq {

    // =============================================================================
    public static LinkedList lerArquivo1() {
        try {
            FileInputStream arq = new FileInputStream("lado1.txt");  //ABERTURA DO ARQ
            Scanner scan = new Scanner(arq);

            int tipo, idade;
            String nome;
            double peso;
            Guerreiro a;

            LinkedList<Guerreiro> l1 = new LinkedList(); //LISTA DUPLAMENTE ENCADEADA

            while (scan.hasNextLine()) {
                tipo = scan.nextInt();
                nome = scan.next();
                idade = scan.nextInt();
                peso = scan.nextDouble();

                switch (tipo) {
                    case 1 -> {
                        a = new Soldado(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 2 -> {
                        a = new Endiabrado(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 3 -> {
                        a = new Ambunave(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 4 -> {
                        a = new CruzadorDeBatalha(nome, idade, peso, 1000);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 5 -> {
                        a = new Fanaticu(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 6 -> {
                        a = new Tormento(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 7 -> {
                        a = new Colosso(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    case 8 -> {
                        a = new Transportadora(nome, idade, peso, 500);
                        System.out.println("O nome do guerreiro eh: " + a.getNome());
                    }
                    default -> {
                        System.out.println("Erro Na Leitura do Guerreiro");
                        return null;
                    }
                }
                l1.add(a); //ADICIONA NA LISTA
            }

            scan.close();
            return l1;

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo Nao Encontrado!");
        }

        return null;
    }

// =============================================================================
    public static LinkedList lerArquivo2() {
        try {
            FileInputStream arq = new FileInputStream("lado2.txt");  //ABERTURA DO ARQ
            Scanner scan = new Scanner(arq);

            int tipo, idade;
            String nome;
            double peso;
            Guerreiro b;

            LinkedList<Guerreiro> l2 = new LinkedList(); //LISTA DUPLAMENTE ENCADEADA

            while (scan.hasNextLine()) {
                tipo = scan.nextInt();
                nome = scan.next();
                idade = scan.nextInt();
                peso = scan.nextDouble();

                switch (tipo) {
                    case 1 -> {
                        b = new Zergnideo(nome, idade, peso, 45);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 2 -> {
                        b = new TatuBomba(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 3 -> {
                        b = new Infestador(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 4 -> {
                        b = new LordDasCastas(nome, idade, peso, 200);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 5 -> {
                        b = new Servo(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 6 -> {
                        b = new Devoradora(nome, idade, peso, 100);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    case 7 -> {
                        b = new Empalador(nome, idade, peso, 400);
                        System.out.println("O nome do guerreiro eh: " + b.getNome());
                    }
                    default -> {
                        System.out.println("Erro na Leitura do Arquivo!");
                        return null;
                    }
                }
                l2.add(b); //ADICIONA NA LISTA
            }

            scan.close();
            return l2;

        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo Nao Encontrado!");
        }
        return null;
    }
}
