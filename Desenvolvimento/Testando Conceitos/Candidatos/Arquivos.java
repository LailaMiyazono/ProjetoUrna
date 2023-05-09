import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Arquivos {
    
    private Path caminhoLeitura;
    private List<AnimeFilme> listAnimeFilmes;
    private List<AnimeSerie> listAnimesSerie;
    private String diretorioAnimesFilme;
    private String diretorioAnimesSerie;

    public String getDiretorioAnimesFilme() {
        return diretorioAnimesFilme;
    }
    public String getDiretorioAnimesSerie() {
        return diretorioAnimesSerie;
    }                                                                       //geterrs e seterrs
    public Path getCaminhoLeitura() {
        return caminhoLeitura;
    }
    public List<AnimeFilme> getListAnimeFilmes() {
        return listAnimeFilmes;
    }
    public List<AnimeSerie> getListAnimesSerie() {
        return listAnimesSerie;
    }

    public void setCaminhoLeitura(Path caminhoLeitura) {
        this.caminhoLeitura = caminhoLeitura;
    }                                                                   


    public void lerAnimesSerie(String filePath){
        this.listAnimesSerie = new ArrayList<>();

        this.caminhoLeitura = Paths.get(filePath);

        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesSerie = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){ // Lendo arquivo Candidatos.txt
            
            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo

            while(itemTxt != null){ // lendo demais linhas
                String[] linhaCandidato = itemTxt.split(",");
                String name = linhaCandidato[0];

                listAnimesSerie.add(new AnimeSerie(name)); // Adcionando candidatos do txt a lista de candidatos local.
            
                itemTxt = br.readLine();
            }
        }catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }
    }
    public void lerAnimesFilme(String filePath){
        
        this.listAnimeFilmes = new ArrayList<>();

        this.caminhoLeitura = Paths.get(filePath);

        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesFilme = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){ // Lendo arquivo Candidatos.txt
            
            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo

            while(itemTxt != null){ // lendo demais linhas
                String[] linhaCandidato = itemTxt.split(",");
                String name = linhaCandidato[0];

                listAnimeFilmes.add(new AnimeFilme(name)); // Adcionando candidatos do txt a lista de candidatos local.
            
                itemTxt = br.readLine();
            }
        }catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }

    }
    public void pushAnimesFilme(List<AnimeFilme> animeFilmes){
        

        String diretorioSaida = this.diretorioAnimesSerie;
        boolean sucess = new File(diretorioSaida + "//resultado").mkdir();// criando pasta para arquivos de saida
        System.out.println("Pasta out criada!");

        String resultadoTxt = diretorioSaida + "//resultado/AnimeFilmeResultado.txt"; // nomeando arquivo de resultados
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoTxt))) {// criando arquivo resultados.txt
            
            System.out.println("Arquivo AnimesFilme.txt criado!");

            for(AnimeFilme candidato : animeFilmes){
                bw.write(candidato.enviarDados());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }


    }
    public void pushAnimesSerie(List<AnimeSerie> anime){
        

        String diretorioSaida = this.diretorioAnimesSerie;

        String resultadoTxt = diretorioSaida + "//resultado/AnimesSerieResultado.txt"; // nomeando arquivo de resultados
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoTxt))) {// criando arquivo resultados.txt
            
            System.out.println("Arquivo AnimesSerie.txt criado!");

            for(AnimeSerie candidato : anime){
                bw.write(candidato.enviarDados());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    
    }
}
