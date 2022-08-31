import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.PrintWriter;

public class AtividadeUm {

    public static void main(String[] args) {
       
       try{
            File arquivoDesordenado = new File("arquivo.txt.txt"); // abre o arquivo
            Scanner arq = new Scanner(arquivoDesordenado);  // separar a entrada dos textos
            int num = 0;
            while (arq.hasNext()) { // pergunta se tem próximo? Caso sim, entra em while, caso contrário pula pra fora
                num++; // contador
                arq.nextInt(); //pulando para a próxima linha do arquivo               
            }
            arq.close(); // fecha o arquivo
            arq = new Scanner(arquivoDesordenado); // separar a entrada dos textos
            int array [] = new int [num]; // coleção de inteiros
            SortedSet<Integer> lista = new TreeSet<Integer>(); // não deixa elementos repetidos
            int  i = 0;

            while (arq.hasNext()) {  // retorna o próximo objeto da iteração
                array [i] = arq.nextInt(); // lê o valor digitado e o armazena em uma variável do tipo int
                lista.add(array[i]); // controla na lista onde cada elemento é inserido
                i++; // contador
            }
            arq.close(); //fecha o arquivo
            
            ordenar(array); 

            for(i=0;i<array.length;i++){
                System.out.println(array[i]);
            }
            System.out.println("Mostrando a Collection: "); // mostra a collection
            FileWriter file = new FileWriter("ordenado.txt.txt"); // para escrever diretamente no arquivo
            PrintWriter escritaNoArquivo = new PrintWriter(file); // usado para enviar caracteres para um texto Arquiv

            for(int valores:lista){
                System.out.println(valores);
                escritaNoArquivo.println(valores);
            }
            escritaNoArquivo.close(); //fecha o arquivo

       } catch(Exception e ) {
            System.out.println(e);
        }
    }
    private static void ordenar(int[] valores) { //  não podem ser acessados ou usados por nenhuma outra classe
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores.length - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    int temp = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = temp;
                }
                System.out.println("Valores sendo Ordenados: " + valores[j]); // mostra os valores ordenados
            }
        }
    }}