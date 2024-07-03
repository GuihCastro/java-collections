package set.operacoes_basicas.convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        if (!palavrasUnicas.contains(palavra)) palavrasUnicas.add(palavra);
        else System.out.println("A palavra já existe no conjunto.");
    }

    public void removerPalavra(String palavra) {
        if (!palavrasUnicas.isEmpty()) {
                if (palavrasUnicas.contains(palavra)) palavrasUnicas.remove(palavra);
                else System.out.println("Palavra não encontrada no conjunto.");
        } else {
            throw new RuntimeException("O conjunto de palavras está vazio.");
        }
    }

    public void exibirPalavrasUnicas() {
        System.out.println("Conjunto de Palavras Únicas: \n" + palavrasUnicas);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        System.out.println("Adicionando palavra...");
        conjuntoPalavrasUnicas.adicionarPalavra("Macarrão");
        System.out.println("Adicionando palavra...");
        conjuntoPalavrasUnicas.adicionarPalavra("Abobrinha");
        System.out.println("Adicionando palavra...");
        conjuntoPalavrasUnicas.adicionarPalavra("Feijão");
        System.out.println("Adicionando palavra...");
        conjuntoPalavrasUnicas.adicionarPalavra("Macarrão");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println("Removendo palavra...");
        conjuntoPalavrasUnicas.removerPalavra("Abobrinha");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
