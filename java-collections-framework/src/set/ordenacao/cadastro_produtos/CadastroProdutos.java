package set.ordenacao.cadastro_produtos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> setDeProdutos;

    public CadastroProdutos() {
        this.setDeProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        this.setDeProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(setDeProdutos);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(setDeProdutos);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto Y", 100, 3);
        cadastroProdutos.adicionarProduto(2L, "Produto J", 50, 4);
        cadastroProdutos.adicionarProduto(3L, "Produto A", 380, 5);
        cadastroProdutos.adicionarProduto(2L, "Produto X", 400, 6);

        System.out.println(cadastroProdutos.setDeProdutos);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}

