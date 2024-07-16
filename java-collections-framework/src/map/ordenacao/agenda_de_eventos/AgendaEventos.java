package map.ordenacao.agenda_de_eventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaDeEventos;

    public AgendaEventos() {
        this.agendaDeEventos = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String evento, String atracoes) {
        this.agendaDeEventos.put(data, new Evento(evento, atracoes));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosOrdenados = new TreeMap<>(this.agendaDeEventos);
        for (Map.Entry<LocalDate, Evento> entry : eventosOrdenados.entrySet()) {
            LocalDate data = entry.getKey();
            Evento evento = entry.getValue();
            System.out.println(data + ": " + evento.getEvento() + " com a atração: " + evento.getAtracao());
        }
    }

    public void obterProximoEvento() {
        if (!agendaDeEventos.isEmpty()) {
            LocalDate dataAtual = LocalDate.now();
            LocalDate proximaData = null;
            Evento proximoEvento = null;
            for (Map.Entry<LocalDate, Evento> entry : agendaDeEventos.entrySet()) {
                if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                    proximaData = entry.getKey();
                    proximoEvento = entry.getValue();
                    break;
                }
            }
            if (proximoEvento != null) System.out.println("O próximo evento " + proximoEvento.getEvento() + " acontecerá na data: " + proximaData);
            else System.out.println("Não há eventos futuros na agenda.");
        } else {
            throw new RuntimeException("A agenda de eventos está vazia.");
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 10), "Evento A", "Muito badalado");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 7, 21), "Evento B", "Maisoumenos");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.MARCH, 20), "Evento C", "Melhor de todos");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 12, 25), "Natal", "Top");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
