package list.pesquisa.catalogo_de_livros;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private final List<Livro> listaDeLivros;

    public CatalogoLivros() {
        this.listaDeLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoDePublicacao) {
        listaDeLivros.add(new Livro(titulo, autor, anoDePublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        if (!listaDeLivros.isEmpty()) {
            for (Livro livro : listaDeLivros) {
                if (livro.getAutor().equalsIgnoreCase(autor)) livrosDoAutor.add(livro);
            }
            if (!livrosDoAutor.isEmpty()) return livrosDoAutor;
            else throw new RuntimeException("Nenhum livro encontrado para o autor informado.");
        } else {
            throw new RuntimeException("A lista de livros está vazia.");
        }
    }

    public List<Livro> pesquisarPorIntervaloDeAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosDentroDoIntervalo = new ArrayList<>();
        if (!listaDeLivros.isEmpty()) {
            for (Livro livro : listaDeLivros) {
                if (livro.getAnoDePublicacao() >= anoInicial && livro.getAnoDePublicacao() <= anoFinal) livrosDentroDoIntervalo.add(livro);
            }
            if (!livrosDentroDoIntervalo.isEmpty()) return livrosDentroDoIntervalo;
            else throw new RuntimeException("Nenhum livro encontrado para o intervalo informado.");
        } else {
            throw new RuntimeException("A lista de livros está vazia.");
        }
    }

    public Livro pesquisarPorTitulo (String titulo) {
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) return livro;
        }
        throw new RuntimeException("Nenhum livro encontrado para o título informado.");
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoDeLivros = new CatalogoLivros();

        catalogoDeLivros.adicionarLivro("Demian", "Herman Hesse", 1919);
        catalogoDeLivros.adicionarLivro("O Lobo da Estepe", "Herman Hesse", 1927);
        catalogoDeLivros.adicionarLivro("O Estrangeiro", "Albert Camus", 1942);

        System.out.println("Livros de Herman Hesse: \n" + catalogoDeLivros.pesquisarPorAutor("Herman Hesse"));
        System.out.println("Livros publicados entre 1900 e 1950: \n" + catalogoDeLivros.pesquisarPorIntervaloDeAnos(1900, 1950));
        System.out.println("Livro encontrado para o título: 'O Estrangeiro': \n" + catalogoDeLivros.pesquisarPorTitulo("O Estrangeiro"));
    }
}
