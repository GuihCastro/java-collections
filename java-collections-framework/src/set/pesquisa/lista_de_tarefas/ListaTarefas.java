package set.pesquisa.lista_de_tarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaDeTarefas;

    public ListaTarefas() {
        this.listaDeTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        listaDeTarefas.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = tarefa;
                    break;
                }
            }
            if (tarefaParaRemover != null) listaDeTarefas.remove(tarefaParaRemover);
            else System.out.println("Tarefa não encontrada.");
        } else {
            throw new RuntimeException("A lista de tarefas está vazia.");
        }
    }

    public void exibirTarefas() {
        System.out.println("Tarefas: \n" + listaDeTarefas);
    }

    public int contarTarefas() {
        return listaDeTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.isConcluida()) tarefasConcluidas.add(tarefa);
            }
        }
        if (tarefasConcluidas.isEmpty()) System.out.println("Não há tarefas concluídas na lista.");
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa tarefa : listaDeTarefas) {
                if (!tarefa.isConcluida()) tarefasPendentes.add(tarefa);
            }
        }
        if (tarefasPendentes.isEmpty()) System.out.println("Não há tarefas pendentes na lista.");
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    if (!tarefa.isConcluida()) {
                        tarefa.setConcluida(true);
                        System.out.println("Tarefa concluída!");
                        return;
                    } else {
                        System.out.println("A tarefa já está concluída.");
                    }
                }
            }
            System.out.println("Tarefa não encontrada.");
        } else {
            throw new RuntimeException("A lista de tarefas está vazia.");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    if (tarefa.isConcluida()) {
                        tarefa.setConcluida(false);
                        System.out.println("Tarefa pendente!");
                        return;
                    } else {
                        System.out.println("A tarefa já está pendente.");
                    }
                }
            }
            System.out.println("Tarefa não encontrada.");
        } else {
            throw new RuntimeException("A lista de tarefas está vazia.");
        }
    }

    public void limparListaTarefas() {
        if (!listaDeTarefas.isEmpty()) listaDeTarefas.clear();
        else System.out.println("A lista de tarefas já está vazia.");
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Treinar");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Treinar");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println("Tarefas pendentes: \n" + listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println("Tarefas concluídas: \n" + listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
