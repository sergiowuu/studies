public class Loop {
    public static void main(String[] args){
        for (int i = 1; i <= 30; i++){
            if (i % 3 == 0){
                continue;
            }
            if (i == 25){
                break;
            }
            System.out.println(i);
        }
    }    
}
