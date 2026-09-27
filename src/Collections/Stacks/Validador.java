package Collections.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Validador {
    private Deque<Character> validador = new ArrayDeque<>();

    public boolean ehBalanceado(String expressao){
        for(char c : expressao.toCharArray()){
            if(c == '('){
                validador.push(c);
            } else if(c == ')'){
                if(validador.isEmpty()){
                    return false;
                }
                validador.pop();
            }
        }
        return validador.isEmpty();
    }
}
