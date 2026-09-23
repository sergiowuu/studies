package Collections.Deques;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class ActionHistory {
    private Deque<String> acoes = new ArrayDeque<>();

    public void registrarAcao(String acao){
        acoes.push(acao);
    }

    public String desfazerUltimaAcao(){
        if(acoes.isEmpty()){
            throw new NoSuchElementException("Nenhuma ação para desfazer.");
        }
        return acoes.removeFirst();
    }

    public String inspecionarMaisAntiga(){
        String maisAntiga = acoes.peekLast();
        if(maisAntiga == null){
            throw new NoSuchElementException("Nenhuma ação disponível");
        } else {
            return maisAntiga;
        }
    }
}
