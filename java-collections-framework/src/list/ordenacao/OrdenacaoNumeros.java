package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> listaDeNumeros;

    public OrdenacaoNumeros() {
        this.listaDeNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listaDeNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosEmOrdemAscendente = new ArrayList<>(this.listaDeNumeros);
        if (!this.listaDeNumeros.isEmpty()) {
            Collections.sort(numerosEmOrdemAscendente);
            return numerosEmOrdemAscendente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> numerosEmOrdemDescendente = new ArrayList<>(this.listaDeNumeros);
        if (!this.listaDeNumeros.isEmpty()) {
            numerosEmOrdemDescendente.sort(Collections.reverseOrder());
            return numerosEmOrdemDescendente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirNumeros() {
        if (!this.listaDeNumeros.isEmpty()) System.out.println(this.listaDeNumeros);
        else throw new RuntimeException("A lista está vazia.");
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(33);
        ordenacaoNumeros.adicionarNumero(0);
        ordenacaoNumeros.adicionarNumero(28);
        ordenacaoNumeros.adicionarNumero(-1);

        System.out.println("Lista de números:");
        ordenacaoNumeros.exibirNumeros();

        System.out.println("Números em ordem ascendente: " + ordenacaoNumeros.ordenarAscendente());

        System.out.println("Números em ordem descendente: " + ordenacaoNumeros.ordenarDescendente());
    }
}
