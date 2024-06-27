package list.operacoes_basicas.carrinho_de_compras;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeItens;

    public CarrinhoDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        for (Item item : this.listaDeItens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.setQuantidade(quantidade);
                return;
            }
        }
        this.listaDeItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if (!listaDeItens.isEmpty()) {
            Item itemParaRemover = new Item();
            for (Item item : listaDeItens) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    if (item.getQuantidade() > 1) {
                        item.setQuantidade(-1);
                        return;
                    }
                    else {
                        itemParaRemover = item;
                    }
                }
            }
            listaDeItens.remove(itemParaRemover);
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    public String calcularValorTotal() {
        double valorTotal = 0;
        for (Item item : listaDeItens) {
            valorTotal += item.getPreco() * item.getQuantidade();
        }
        DecimalFormat df = new DecimalFormat();
        return df.format(valorTotal);
    }

    public void exibirItens() {
        System.out.println(listaDeItens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Bolacha", 6, 2);
        carrinhoDeCompras.adicionarItem("Cerveja", 3.99, 6);
        carrinhoDeCompras.adicionarItem("Pão de Queijo", 19.90, 2);
        carrinhoDeCompras.adicionarItem("Tapioca", 7.50, 1);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Bolacha", 6, 1);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Pão de Queijo");
        carrinhoDeCompras.removerItem("Tapioca");

        carrinhoDeCompras.exibirItens();

        System.out.println("Total: " + carrinhoDeCompras.calcularValorTotal());
    }
}
