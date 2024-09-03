package main;

import natureza.Natureza;
import java.util.LinkedList;
import natureza.Organico;

public abstract class Guerreiro {

    private Natureza natureza;
    private String nome;
    private int idade;
    private double peso;
    private int energia;
    private int max_Energia;

    public Guerreiro(String nome, int idade, double peso, int energia) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMax_Energia() {
        return max_Energia;
    }

    public void setMax_Energia(int max_Energia) {
        this.max_Energia = max_Energia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setNatureza(Natureza nat) {
        this.natureza = nat;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void imprimir() {
        System.out.println("Nome: " +this.getNome() + " Idade: " + this.getIdade() + " Peso: " + this.getPeso());
    }

    public boolean tomarDano(int dano) {
        if (this.getNatureza() instanceof Organico organico) { //CASO SEJA PROTON NAO MECANICO
            dano += organico.getBrotos(); // Obter o valor atual para adicionar um dano bonus por veneno
        }
        System.out.println("O Dano que o " + nome + " tomou foi: " + dano);
        this.energia -= dano;

        if (this.energia < 0) { //CASO A ENERGIA TENHA FICADO NEGATIVA
            this.energia = 0;
        }
        return true;
    }

    public void verificarMaxEnerg() {
        //Caso a energia tenha ultrapassado o limite, volta pro limite.
        if (this.getEnergia() > this.getMax_Energia()) {
            this.setEnergia(this.getMax_Energia());
        }
    }

    public boolean verificarMorte() {
        return this.energia == 0; //retorna true ou false
    }

    public abstract boolean atacar(Guerreiro alvo, LinkedList<Guerreiro> l1, LinkedList<Guerreiro> l2, int vez,boolean causar_dano) ;
}
