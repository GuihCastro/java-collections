package set.operacoes_basicas.convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> conjuntoDeConvidados;

    public ConjuntoConvidados() {
        this.conjuntoDeConvidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoDoConvite) {
        conjuntoDeConvidados.add(new Convidado(nome, codigoDoConvite));
    }

    public void removerConvidado(int codigoDoConvite) {
        Convidado convidadoParaRemover = null;
        if (!conjuntoDeConvidados.isEmpty()) {
            for (Convidado convidado : conjuntoDeConvidados) {
                if (convidado.getCodigoDoConvite() == codigoDoConvite) {
                    convidadoParaRemover = convidado;
                    break;
                }
                throw new RuntimeException("Nenhum convidado encontrado para o código de convite informado.");
            }
            conjuntoDeConvidados.remove(convidadoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio.");
        }
    }

    public int contarConvidados() {
        return conjuntoDeConvidados.size();
    }

    public void exibirConvidados() {
        System.out.println("Convidados: \n" + conjuntoDeConvidados);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Guilherme", 666);
        conjuntoConvidados.adicionarConvidado("Joãozinho", 666);
        conjuntoConvidados.adicionarConvidado("Mariana", 1000);

        conjuntoConvidados.exibirConvidados();

        System.out.println("O conjunto tem " + conjuntoConvidados.contarConvidados() + " convidados.");

        System.out.println("Removendo convidado...");
        conjuntoConvidados.removerConvidado(666);

        conjuntoConvidados.exibirConvidados();
    }
}
