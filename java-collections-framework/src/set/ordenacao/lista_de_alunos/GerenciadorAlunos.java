package set.ordenacao.lista_de_alunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> setDeAlunos;

    public GerenciadorAlunos() {
        this.setDeAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        this.setDeAlunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        if (!setDeAlunos.isEmpty()) {
            for (Aluno aluno : setDeAlunos) {
                if (aluno.getMatricula() == matricula) {
                    this.setDeAlunos.remove(aluno);
                    System.out.println("Aluno removido com sucesso.");
                    return;
                }
            }
            System.out.println("Nenhum aluno encontrado para a matrícula informada.");
        } else {
            throw new RuntimeException("A lista de alunos está vazia.");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(setDeAlunos);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(setDeAlunos);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        System.out.println(setDeAlunos);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Guilherme", 666, 9.5);
        gerenciadorAlunos.adicionarAluno("Mariana", 1992, 10);
        gerenciadorAlunos.adicionarAluno("Maggie", 15, 9);
        gerenciadorAlunos.adicionarAluno("Kurt", 400, 6);
        gerenciadorAlunos.adicionarAluno("Guts", 1000, 8);
        gerenciadorAlunos.adicionarAluno("Red", 13, 3);
        gerenciadorAlunos.adicionarAluno("Paçoca", 666, 0);

        System.out.println("Alunos por nome: \n" + gerenciadorAlunos.exibirAlunosPorNome());

        System.out.println("Alunos por nota: \n" + gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAluno(666);

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno(666);
    }
}
