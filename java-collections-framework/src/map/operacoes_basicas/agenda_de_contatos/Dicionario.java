package map.operacoes_basicas.agenda_de_contatos;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.dicionario.put(palavra, definicao);
        System.out.println("Palavra adicionada com sucesso");
    }

    public void removerPalavra(String palavra) {
        if (!dicionario.isEmpty()) {
            this.dicionario.remove(palavra);
            System.out.println("Palavra removida com sucesso!");
        } else {
            throw new RuntimeException("O dicionário está vazio.");
        }
    }

    public void exibirPalavras() {
        System.out.println(this.dicionario);
    }

    public String pesquisarPorPalavra(String palavra) {
        if (!this.dicionario.isEmpty()) return this.dicionario.get(palavra);
        else throw new RuntimeException("O dicionário está vazio.");
    }

    public static void main(String[] args) {
        Dicionario novoDicionario = new Dicionario();

        novoDicionario.adicionarPalavra("Abobrinha", "É ruim.");
        novoDicionario.adicionarPalavra("Picanha", "É bom.");
        novoDicionario.adicionarPalavra("Cerveja", "Melhor ainda.");

        novoDicionario.removerPalavra("Abobrinha");

        novoDicionario.exibirPalavras();

        System.out.println("Descrição da palavra pesquisada: " + novoDicionario.pesquisarPorPalavra("Cerveja"));
    }
}
