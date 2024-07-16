package map.pesquisa.estoque_de_produtos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoque;

    public EstoqueProdutos() {
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        this.estoque.put(cod, new Produto(nome, quantidade, preco));
        System.out.println("Produto adicionado com sucesso!");
    }

    public void exibirProdutos() {
        System.out.println(this.estoque);
    }

    public double calcularValorTotalEstoque() {
        if (!this.estoque.isEmpty()) {
            double valorTotal = 0;
            for (Produto produto : estoque.values()) {
                valorTotal += produto.getQuantidade() * produto.getPreco();
            }
            return valorTotal;
        } else {
            throw new RuntimeException("O estoque está vazio.");
        }
    }

    public Produto obterProdutoMaisCaro() {
        if (!this.estoque.isEmpty()) {
            Produto produtoMaisCaro = null;
            double maiorValor = Double.MIN_VALUE;
            for (Produto produto : estoque.values()) {
                if (produto.getPreco() > maiorValor) {
                    produtoMaisCaro = produto;
                    maiorValor = produto.getPreco();
                }
            }
            return produtoMaisCaro;
        } else {
            throw new RuntimeException("O estoque está vazio.");
        }
    }

    public Produto obterProdutoMaisBarato() {
        if (!this.estoque.isEmpty()) {
            Produto produtoMaisBarato = null;
            double menorValor = Double.MAX_VALUE;
            for (Produto produto : estoque.values()) {
                if (produto.getPreco() < menorValor) {
                    produtoMaisBarato = produto;
                    menorValor = produto.getPreco();
                }
            }
            return produtoMaisBarato;
        } else {
            throw new RuntimeException("O estoque está vazio.");
        }
    }

    public Produto obterProdutoDeMaiorValorTotal() {
        if (!this.estoque.isEmpty()) {
            Produto produtoMaiorTotal = null;
            double maiorTotal = Double.MIN_VALUE;
            for (Produto produto : estoque.values()) {
                double totalProduto = produto.getPreco() * produto.getQuantidade();
                if (totalProduto > maiorTotal) {
                    produtoMaiorTotal = produto;
                    maiorTotal = totalProduto;
                }
            }
            return produtoMaiorTotal;
        } else {
            throw new RuntimeException("O estoque está vazio.");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueDeProdutos = new EstoqueProdutos();

        estoqueDeProdutos.adicionarProduto(1L, "Produto A", 3, 32.0);
        estoqueDeProdutos.adicionarProduto(2L, "Produto B", 1, 80.7);
        estoqueDeProdutos.adicionarProduto(3L, "Produto C", 5, 20.9);

        System.out.println("Produtos em estoque:");
        estoqueDeProdutos.exibirProdutos();

        System.out.println("Valor total de produtos em estoque: " + estoqueDeProdutos.calcularValorTotalEstoque());

        System.out.println("Produto mais caro em estoque: " + estoqueDeProdutos.obterProdutoMaisCaro());

        System.out.println("Produto mais barato em estoque: " + estoqueDeProdutos.obterProdutoMaisBarato());

        System.out.println("Produto com maior soma de valor no total: " + estoqueDeProdutos.obterProdutoDeMaiorValorTotal());
    }
}
