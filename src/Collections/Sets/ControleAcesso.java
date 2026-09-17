package Collections.Sets;

import java.util.HashSet;
import java.util.Set;

public class ControleAcesso {
    private Set<String> cpfs = new HashSet<>();

    public String registrarEntrada(String cpf){
        if (cpfs.add(cpf)) {
            return "CPF registrado";
        } else {
            return "CPF já registrado";
        }
    }

    public void listarCpf(){
        for (String cpf : cpfs){
            System.out.println(cpf);
        }
    }

    public int totalPessoas(){
        return cpfs.size();
    }
}
