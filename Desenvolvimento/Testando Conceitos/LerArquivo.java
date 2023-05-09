import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LerArquivo{
    public static void main(String[] args) {
            
        Locale.setDefault(Locale.US);
        List<AnimeFilme> listCandidatos= new ArrayList<>();

        String filePath = "C:/Users/Jeferson/OneDrive/Área de Trabalho/Java/Arquivos/Candidatos.txt";
        Path caminho = Paths.get(filePath);

        File sourceFile = caminho.toFile();
        String direitorioArquivos = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        
        boolean sucess = new File(direitorioArquivos + "//out").mkdir(); // criando nova pasta para saida  

        String resultadoTxt = direitorioArquivos + "//out/AnimeFilmeResultado.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){ // Lendo arquivo Candidatos.txt
            
            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo

            while(itemTxt != null){ // lendo demais linhas
                String[] linhaCandidato = itemTxt.split(",");
                String name = linhaCandidato[0];

                listCandidatos.add(new AnimeFilme(name)); // Adcionando candidatos do txt a lista de candidatos local.
                
            
                itemTxt = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoTxt))) {// criando arquivo resultados.txt
                    for(AnimeFilme candidato : listCandidatos){
                        bw.write(candidato.enviarDados());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
            
            
        } catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }

    }
}