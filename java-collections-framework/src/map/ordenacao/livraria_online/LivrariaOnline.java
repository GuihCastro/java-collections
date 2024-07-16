package map.ordenacao.livraria_online;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livraria;

    public LivrariaOnline() {
        this.livraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        this.livraria.put(link, new Livro(titulo, autor, preco));
        System.out.println("Livro adicionado com sucesso!");
    }

    public void removerLivro(String titulo) {
        if (!this.livraria.isEmpty()) {
            String chaveParaRemover = null;
            for (Map.Entry<String, Livro> livro : this.livraria.entrySet()) {
                if (livro.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    chaveParaRemover = livro.getKey();
                    break;
                }
            }
            this.livraria.remove(chaveParaRemover);
        }
    }

    public void exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(this.livraria.entrySet());

        Collections.sort(livrosParaOrdenar, new Com);

        System.out.println(livrosParaOrdenar);
    }

    public Map<String, Livro> pesquisarLivroPorAutor(String autor) {
        if (!this.livraria.isEmpty()) {
            Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
            for (Map.Entry<String, Livro> entry : this.livraria.entrySet()) {
                Livro livro = entry.getValue();
                if (livro.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.put(entry.getKey(), livro);
                }
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException("A livraria está vazia.");
        }
    }

    public List<Livro> obterLivrosMaisCaros() {
        if (!this.livraria.isEmpty()) {
            List<Livro> livrosMaisCaros = new ArrayList<>();
            double maiorPreco = Double.MIN_VALUE;
            for (Livro livro : this.livraria.values()) {
                if (livro.getPreco() >= maiorPreco) {
                    maiorPreco = livro.getPreco();
                }
            }
            for (Livro livro : this.livraria.values()) {
                if (livro.getPreco() == maiorPreco) {
                    livrosMaisCaros.add(livro);
                }
            }
            return livrosMaisCaros;
        } else {
            throw new RuntimeException("A livraria está vazia.");
        }
    }

    public List<Livro> obterLivrosMaisBaratos() {
        if (!this.livraria.isEmpty()) {
            List<Livro> livrosMaisBaratos = new ArrayList<>();
            double menorPreco = Double.MAX_VALUE;
            for (Livro livro : this.livraria.values()) {
                if (livro.getPreco() <= menorPreco) {
                    menorPreco = livro.getPreco();
                }
            }
            for (Livro livro : this.livraria.values()) {
                if (livro.getPreco() == menorPreco) {
                    livrosMaisBaratos.add(livro);
                }
            }
            return livrosMaisBaratos;
        } else {
            throw new RuntimeException("A livraria está vazia.");
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("link1.com.br", "Demian", "Herman Hesse", 35.0);
        livrariaOnline.adicionarLivro("link2.com.br", "Sidharta", "Herman Hesse", 30.0);
        livrariaOnline.adicionarLivro("link3.com.br", "O Estrangeiro", "Albert Camus", 25.9);
        livrariaOnline.adicionarLivro("link4.com.br", "O Lobo da Estepe", "Herman Hesse", 35.9);

        livrariaOnline.exibirLivrosOrdenadosPorPreco();
    }
}
