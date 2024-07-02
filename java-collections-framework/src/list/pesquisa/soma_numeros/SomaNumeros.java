package list.pesquisa.soma_numeros;

import java.util.List;
import java.util.ArrayList;

public class SomaNumeros {
    private List<Integer> numerosInteiros;

    // construtor
    public SomaNumeros() {
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosInteiros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (int numero : numerosInteiros) {
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maiorNumero = Integer.MIN_VALUE;
        if (!numerosInteiros.isEmpty()) {
            for (int numero : numerosInteiros) {
                if (numero >= maiorNumero) maiorNumero = numero;
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista de números está vazia.");
        }
    }

    public int encontrarMenorNumero() {
        int menorNumero = Integer.MAX_VALUE;
        if (!numerosInteiros.isEmpty()) {
            for (int numero : numerosInteiros) {
                if (numero <= menorNumero) menorNumero = numero;
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista de números está vazia.");
        }
    }

    public void exibirNumeros() {
        if (!numerosInteiros.isEmpty()) System.out.println(this.numerosInteiros);
        else System.out.println("A lista está vazia.");
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(6);
        somaNumeros.adicionarNumero(-7);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(13);

        System.out.println("Lista de números inteiros:");
        somaNumeros.exibirNumeros();

        System.out.println("Menor número da lista: " + somaNumeros.encontrarMenorNumero());

        System.out.println("Maior número da lista: " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Soma de todos os números da lista: " + somaNumeros.calcularSoma());
    }
}
