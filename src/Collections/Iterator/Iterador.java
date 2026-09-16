package Collections.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterador {
    public static void main(String[] args) {
        ArrayList<String> documentos = new ArrayList<>();

        documentos.add("arquivo1.txt");
        documentos.add("arquivo2.txt");
        documentos.add("arquivo3.tmp");
        documentos.add("arquivo4.tmp");
        documentos.add("arquivo5.tmp");

        removerArquivosTmp(documentos);

        for (String documento : documentos){
            System.out.println(documento);
        }
    }

    static void removerArquivosTmp(ArrayList<String> listaDocumentos){

        Iterator<String> iterator = listaDocumentos.iterator();

        while (iterator.hasNext()){
            String nomeDocumento = iterator.next();

            if (nomeDocumento.endsWith(".tmp")){
                iterator.remove();
            }
        }
    }
}
