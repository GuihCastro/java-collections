package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaDePessoas;

    public OrdenacaoPessoas() {
        this.listaDePessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        listaDePessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaDePessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenasPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaDePessoas);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Mariana", 32, 1.65);
        ordenacaoPessoas.adicionarPessoa("Guilherme", 31, 1.69);
        ordenacaoPessoas.adicionarPessoa("Josefina", 99, 1.53);
        ordenacaoPessoas.adicionarPessoa("Claudemar", 68, 1.83);

        System.out.println("Pessoas por idade: " + ordenacaoPessoas.ordenarPorIdade());
        System.out.println("Pessoas por altura: " + ordenacaoPessoas.ordenasPorAltura());
    }
}

