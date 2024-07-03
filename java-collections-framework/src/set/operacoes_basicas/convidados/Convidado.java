package set.operacoes_basicas.convidados;

import java.util.Objects;

public class Convidado {
    private String nome;
    private int codigoDoConvite;

    public Convidado(String nome, int codigoDoConvite) {
        this.nome = nome;
        this.codigoDoConvite = codigoDoConvite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoDoConvite() {
        return codigoDoConvite;
    }

    public void setCodigoDoConvite(int codigoDoConvite) {
        this.codigoDoConvite = codigoDoConvite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convidado convidado = (Convidado) o;
        return codigoDoConvite == convidado.codigoDoConvite;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoDoConvite);
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "nome='" + nome + '\'' +
                ", codigoDoConvite=" + codigoDoConvite +
                '}';
    }
}
