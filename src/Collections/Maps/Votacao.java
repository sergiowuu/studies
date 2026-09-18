package Collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class Votacao {
    private Map<String, Integer> votos = new HashMap<>();

    public void registrarVoto(String candidato){
        int votosAtuais = votos.getOrDefault(candidato, 0);
        votos.put(candidato, ++votosAtuais);
    }

    public void exibirResultados(){
        for (Map.Entry<String, Integer> voto : votos.entrySet()){
            System.out.printf("Candidato: %s; Total de Votos: %s\n", voto.getKey(), voto.getValue());
        }
    }
}
