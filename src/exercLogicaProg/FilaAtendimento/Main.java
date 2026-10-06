package exercLogicaProg.FilaAtendimento;

import java.util.List;

/**
 * Um banco possui uma fila de clientes, cada um com nome, idade e indicador se é cliente preferencial.
 * A ordem de atendimento segue as seguintes regras: clientes com 80 anos ou mais passam na frente de todos;
 * depois vêm os preferênciais com 60 anos ou maisl depois os demais preferênciais,; por fim os clientes comuns.
 * Dentro de cada grupo, vale a ordem de chegada. Dada a lista de clientes na ordem em que chegaram, gere a ordem
 * final de atedimento e informe em que posição final cada pessoa ficou em relação à posição em que chegou.
 */
public class Main {
    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente("Ana", 30, false),
            new Cliente("Bruno", 85, false),
            new Cliente("Carla", 65, true),
            new Cliente("Diego", 40, true),
            new Cliente("Elisa", 90, true),
            new Cliente("Fabio", 25, false)
        };

        FilaAtendimento fila = new FilaAtendimento();
        for (Cliente c : clientes) {
            fila.adicionar(c);
        }

        List<Cliente> ordem = fila.gerarOrdemAtendimento();
        for (int i = 0; i < ordem.size(); i++) {
            Cliente c = ordem.get(i);
            System.out.printf("%d° atendido: %s (chegou em %d°)%n",
                    i + 1, c.getNome(), fila.posicaoChegada(c));
        }
    }
}
