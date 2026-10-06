package exercLogicaProg.FilaAtendimento;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FilaAtendimento {
    private final Map<Categoria, Queue<Cliente>> filas = new EnumMap<>(Categoria.class);
    private final List<Cliente> ordemChegada = new ArrayList<>();

    public FilaAtendimento(){
        for (Categoria c : Categoria.values()) {
            filas.put(c, new LinkedList<>());
        }
    }

    public void adicionar(Cliente cliente) {
        ordemChegada.add(cliente);
        filas.get(cliente.getCategoria()).add(cliente);
    }

    public List<Cliente> gerarOrdemAtendimento(){
        List<Cliente> ordem = new ArrayList<>();
        for (Categoria c : Categoria.values()){
            ordem.addAll(filas.get(c));
        }
        return ordem;
    }

    public int posicaoChegada(Cliente cliente){
        return ordemChegada.indexOf(cliente) + 1;
    }
}
