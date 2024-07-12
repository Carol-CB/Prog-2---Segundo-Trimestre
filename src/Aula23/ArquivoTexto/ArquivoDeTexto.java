package Aula23.ArquivoTexto;
import java.io.*;

    public class ArquivoDeTexto{
        public static void main(String[]args){
            try{
                BufferedWriter arquivoTexto = new BufferedWriter(new FileWriter("./texto.txt"));
                for(int i =0; i<10; i++){
                    arquivoTexto.append("linha").append(String.valueOf(i)).append(" do arquivo \n");
                }
                arquivoTexto.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Erro ao escrever arquivo");
            }
            catch(IOException e){
                System.out.println("Erro ao criar arquivo");
        }
    }
}
