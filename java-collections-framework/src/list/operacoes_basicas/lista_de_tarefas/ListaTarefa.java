package list.operacoes_basicas.lista_de_tarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> listaDeTarefas;

    public ListaTarefa() {
        this.listaDeTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        listaDeTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        if (!listaDeTarefas.isEmpty()) {
            List<Tarefa> tarefasParaRemover = new ArrayList<>();
            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) tarefasParaRemover.add(tarefa);
            }
            listaDeTarefas.removeAll(tarefasParaRemover);
        } else {
            System.out.println("A lista está vazia.");
        }

    }

    public int obterNumeroTotalTarefas() {
        return listaDeTarefas.size();
    }

    public void obterDescricoesTarefas() {
        System.out.println(listaDeTarefas);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("Número de tarefas na lista: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Comprar batata");
        listaTarefa.adicionarTarefa("Fazer feijão");
        listaTarefa.adicionarTarefa("pipipipopopo");
        listaTarefa.adicionarTarefa("pipipipopopo");

        System.out.println("Número de tarefas na lista: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("pipipipopopo");

        System.out.println("Número de tarefas na lista: " + listaTarefa.obterNumeroTotalTarefas());

        System.out.println("Lista de tarefas:");
        listaTarefa.obterDescricoesTarefas();
    }
}
