package map.pesquisa.contagem_de_palavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemDePalavras;

    public ContagemPalavras() {
        this.contagemDePalavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, int contagem) {
        this.contagemDePalavras.put(palavra, contagem);
        System.out.println("Palavra adicionada com sucesso!");
    }

    public void removerPalavra(String palavra) {
        if (!this.contagemDePalavras.isEmpty()) {
            this.contagemDePalavras.remove(palavra);
            System.out.println("A palavra foi removida com sucesso!");
        } else {
            throw new RuntimeException("A contagem está vazia.");
        }
    }

    public void exibirContagemPalavras() {
        int totalDePalavras = 0;
        for (int contagem : contagemDePalavras.values()) totalDePalavras += contagem;
        System.out.println("A contagem tem um total de " + totalDePalavras + " palavras.");
    }

    public String encontrarPalavraMaisFrequente() {
        if (!this.contagemDePalavras.isEmpty()) {
            String palavraMaisFrequente = null;
            int maiorContagem = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> palavra : contagemDePalavras.entrySet()) {
                if (palavra.getValue() > maiorContagem) {
                    palavraMaisFrequente = palavra.getKey();
                    maiorContagem = palavra.getValue();
                }
            }
            return palavraMaisFrequente;
        } else {
            throw new RuntimeException("A contagem está vazia.");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Arroz", 3);
        contagemPalavras.adicionarPalavra("Feijão", 1);
        contagemPalavras.adicionarPalavra("Batata", 5);
        contagemPalavras.adicionarPalavra("Macarrão", 2);

        contagemPalavras.exibirContagemPalavras();

        System.out.println("A palavra mais frequente da contagem é: " + contagemPalavras.encontrarPalavraMaisFrequente());

        contagemPalavras.removerPalavra("Batata");

        contagemPalavras.exibirContagemPalavras();

        System.out.println("A palavra mais frequente da contagem é: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
