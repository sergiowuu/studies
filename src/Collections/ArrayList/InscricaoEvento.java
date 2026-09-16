package Collections.ArrayList;

import java.util.ArrayList;

public class InscricaoEvento {
    private ArrayList<String> participantes = new ArrayList<>();

    public String inscreverParticipante(String nome){
        if (candidatoInscrito(nome)){
            return "Candidato já inscrito";
        } else {
            participantes.add(nome);
            return "Participante inscrito";
        }
    }

    public String cancelarInscricao(String nome){
        if (candidatoInscrito(nome)){
            participantes.remove(nome);
            return "Participante removido";
        } else {
            return "Participante não está inscrito";
        }
    }

    public boolean candidatoInscrito(String nome){
        return participantes.contains(nome);
    }

    public void listarParticipantes(){
        for (String participante : participantes){
            System.out.println(participante);
        }
    }
}
