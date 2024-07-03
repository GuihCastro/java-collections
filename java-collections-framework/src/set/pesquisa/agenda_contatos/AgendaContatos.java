package set.pesquisa.agenda_contatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> agendaContatos;

    public AgendaContatos() {
        this.agendaContatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        agendaContatos.add(new Contato(nome, numero));
        System.out.println("Contato adicionado!");
    }

    public void exibirContatos() {
        System.out.println("Agenda de contatos: \n" + agendaContatos);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> conjuntoPorNome = new HashSet<>();
        if (!agendaContatos.isEmpty()) {
            for (Contato contato : agendaContatos) {
                if (contato.getNome().contains(nome)) conjuntoPorNome.add(contato);
            }
            if (conjuntoPorNome.isEmpty()) System.out.println("Nenhum contato encontrado para o nome informado.");
        } else {
            throw new RuntimeException("A agenda está vazia.");
        }
        return conjuntoPorNome;
    }

    public void atualizarNumeroContato(String nome, int novoNumero) {
        if (!agendaContatos.isEmpty()) {
            for (Contato contato : agendaContatos) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    contato.setNumero(novoNumero);
                    System.out.println("Contato atualizado!");
                    return;
                }
            }
        } else {
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaDeContatos = new AgendaContatos();

        agendaDeContatos.adicionarContato("Guilherme", 123456);
        agendaDeContatos.adicionarContato("Mariana", 456789);
        agendaDeContatos.adicionarContato("Maggie", 123789);
        agendaDeContatos.adicionarContato("Kurt", 456123);
        agendaDeContatos.adicionarContato("Guts", 789456);
        agendaDeContatos.adicionarContato("Red", 789123);
        agendaDeContatos.adicionarContato("Guilherme2", 753159);

        agendaDeContatos.exibirContatos();

        System.out.println("Contatos com o nome 'Guilherme': \n" + agendaDeContatos.pesquisarPorNome("Guilherme"));

        agendaDeContatos.atualizarNumeroContato("Guilherme", 456789);

        agendaDeContatos.exibirContatos();
    }
}
