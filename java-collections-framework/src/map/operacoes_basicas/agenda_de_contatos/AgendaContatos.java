package map.operacoes_basicas.agenda_de_contatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> mapDeContatos;

    public AgendaContatos() {
        this.mapDeContatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        this.mapDeContatos.put(nome, telefone);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato(String nome) {
        if (!mapDeContatos.isEmpty()) {
            this.mapDeContatos.remove(nome);
            System.out.println("Contato removido com sucesso!");
        } else {
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public void exibirContatos() {
        System.out.println(this.mapDeContatos);
    }

    public Integer pesquisarPorNome(String nome) {
        if (!mapDeContatos.isEmpty()) {
            return this.mapDeContatos.get(nome);
        } else {
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Guilherme", 123456);
        agendaContatos.adicionarContato("Mariana", 456789);
        agendaContatos.adicionarContato("Maggie", 123789);
        agendaContatos.adicionarContato("Kurt", 987654);
        agendaContatos.adicionarContato("Guts", 654321);
        agendaContatos.adicionarContato("Red", 987321);
        agendaContatos.adicionarContato("Guilherme", 456789);

        agendaContatos.removerContato("Guilherme");

        agendaContatos.exibirContatos();

        System.out.println("Número do contato pesquisado: " + agendaContatos.pesquisarPorNome("Mariana"));
    }
}
