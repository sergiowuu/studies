package Collections.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Atendimento {
    private Queue<String> atendimentoQueue = new LinkedList<>();

    public String entrarFila (String nome){
        atendimentoQueue.offer(nome);
        return nome + " entrou na fila.";
    }

    public String atenderCliente(){
        String cliente;
        if ((cliente = atendimentoQueue.poll()) != null) {
            return cliente + " sendo atendido.";
        } else {
            return "Fila vazia";
        }
    }
}
