package Aula23.ArquivoTexto;
import java.io.*;
public class LerTexto {
    public static void main(String[] args) {
        try{
            BufferedReader arquivoTexto = new BufferedReader (new FileReader(
                    "./texto.txt"));
            String texto ="";
            String linha ="";
            while(linha!=null){
                linha = arquivoTexto.readLine();
                if(linha!=null){
                    texto+=linha+"\n";
                }
            }
            System.out.println(texto);
            arquivoTexto.close();
        }
        catch(IOException e){
            System.out.println("Erro ao ler o arquivo.");
        }
    }
}
