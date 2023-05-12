package projetourna.model;


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
    
    private List<AnimeFilme> listAnimeFilmes;
    private List<AnimeSerie> listAnimesSerie;
    
    private List<Critico> listCriticos;
    private List<EleitorAssinante> listAssinantes;
    private List<EleitorAssinante> listVotaramAssinante;
    private List<Critico> listVotaramCritico;
    

   

    
    private Path caminhoLeitura;
    private String diretorioRaiz;
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
    public List<EleitorAssinante> getListAssinantes() {
        return listAssinantes;
    }
    public List<Critico> getListCriticos() {
        return listCriticos;
    }

    public void setCaminhoLeitura(Path caminhoLeitura) {
        this.caminhoLeitura = caminhoLeitura;
    }                                                                   
    public List<Critico> getListVotaramCritico() {
        return listVotaramCritico;
    }
    public List<EleitorAssinante> getListVotaramAssinante() {
        return listVotaramAssinante;
    }
    

    public void lerAnimesSerie() {
        this.diretorioRaiz = System.getProperty("user.dir");
        this.listAnimesSerie = new ArrayList<>();

        this.caminhoLeitura = Paths.get(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Candidatos/CandidatosAnimesSerie.txt");
        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesSerie = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Candidatos/CandidatosAnimesSerie.txt"))){ // Lendo arquivo Candidatos.txt
            
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
    public void lerAnimesFilme(){
        
        this.listAnimeFilmes = new ArrayList<>();
        
        this.diretorioRaiz = System.getProperty("user.dir");
        this.caminhoLeitura = Paths.get(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Candidatos/CandidatosAnimesFilme.txt");

        System.out.println(this.diretorioRaiz);
        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesFilme = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Candidatos/CandidatosAnimesFilme.txt"))){ // Lendo arquivo Candidatos.txt
            
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
        
        boolean sucess = new File(this.diretorioAnimesFilme + "/..///resultado").mkdir();// criando pasta para arquivos de saida
        System.out.println("Pasta resultado criada!");

        String resultadoTxt = this.diretorioAnimesFilme + "/..///resultado/AnimeFilmeResultado.txt"; // nomeando arquivo de resultados
        
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

        String resultadoTxt = diretorioSaida + "/..//resultado/AnimesSerieResultado.txt"; // nomeando arquivo de resultados
        
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

    public void lerCritico(){
        this.listCriticos = new ArrayList<>();

        this.caminhoLeitura = Paths.get(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/EleitorCritico.txt");
        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesSerie = sourceFile.getParent(); // encontrando caminho da pasta arquivos
        try (BufferedReader br = new BufferedReader(new FileReader(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/EleitorCritico.txt"))){ // Lendo arquivo Candidatos.txt
            
            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo
            System.out.println("Critico.txt lido!");
            while(itemTxt != null){ // lendo demais linhas
                String[] linhaCritico = itemTxt.split(",");
                String name = linhaCritico[0];
                String email = linhaCritico[1];
                String id =linhaCritico[2];
            
                listCriticos.add(new Critico(name,email,id)); // Adcionando candidatos do txt a lista de candidatos local.
            
                itemTxt = br.readLine();
            }
        }catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }
        
    }
    public void lerAssinante(){
        this.listAssinantes = new ArrayList<>();
        
        this.diretorioRaiz = System.getProperty("user.dir");
        this.caminhoLeitura = Paths.get(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/EleitorAssinante.txt");
        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesSerie = sourceFile.getParent(); // encontrando caminho da pasta arquivos

        try (BufferedReader br = new BufferedReader(new FileReader(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/EleitoresAssinantes.txt"))){ // Lendo arquivo Candidatos.txt
            System.out.println("Assinante.txt lido");

            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo

            while(itemTxt != null){ // lendo demais linhas
                String[] linhaAssinante = itemTxt.split(",");
                String name = linhaAssinante[0];
                String email = linhaAssinante[1];

                listAssinantes.add(new EleitorAssinante(name,email)); // Adcionando candidatos do txt a lista de candidatos local.
            
                itemTxt = br.readLine();
            }
        }catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }
        
    }
    
    public void iniciarListas(){
        this.listVotaramAssinante = new ArrayList();
        this.listVotaramCritico = new ArrayList();
        }

    public Boolean addVotaram(String name, String email, String id){ // adcionando quem não votou a jaVotaram.txt
        if(id == null){
            
            EleitorAssinante assinanteLogin = new EleitorAssinante(name, email);

            // Verifica se o assinante já votou
        if (!this.listVotaramAssinante.contains(assinanteLogin)) {
            String diretorioSaida = this.diretorioAnimesSerie;
            String resultadoTxt = diretorioSaida + "/..//Eleitores/jaVotaram.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoTxt, true))) {
                System.out.println("Tudo certo com o jaVotaram!");
                bw.write(assinanteLogin.enviarDados());
                bw.newLine();
                System.out.println("Assinante adicionado em jaVotaram"); 
                System.out.println("testeVotou");
                return false;
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        } else {
            System.out.println("teste não votou");
            return true;
        }
            

        }else{
            Critico criticoLogin = new Critico(name, email, id);
        
            // Verifica se o crítico já votou
            if (!listVotaramCritico.contains(criticoLogin)) {
                String diretorioSaida = this.diretorioAnimesSerie;
                String resultadoTxt = diretorioSaida + "/..//Eleitores/jaVotaram.txt";
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(resultadoTxt, true))) {
                    System.out.println("Tudo certo com o jaVotaram!");
                    bw.write(criticoLogin.enviarDados());
                    bw.newLine();
                    return false;
                } catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
            } else {
                return true;
            }
        }
        return false;

    }
    public String lerJaVotaram(String nomeTxt, String emailTxt, String idTtxt){

        this.listVotaramAssinante = new ArrayList<>();
        this.listVotaramCritico = new ArrayList<>();
        
        this.diretorioRaiz = System.getProperty("user.dir");
        this.caminhoLeitura = Paths.get(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/jaVotaram.txt");
        File sourceFile = caminhoLeitura.toFile();
        this.diretorioAnimesSerie = sourceFile.getParent(); // encontrando caminho da pasta 
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(this.diretorioRaiz + "/src/projetourna/Banco_Dados/Eleitores/jaVotaram.txt"))){ // Lendo arquivo Candidatos.txt
            System.out.println("Ja votaram.txt lido para extração");

            String itemTxt  = br.readLine(); // lendo primeira linha do arquivo
           


            while(itemTxt != null){ // lendo demais linhas
                String[] linhaAssinante = itemTxt.split(",");
                System.out.println(linhaAssinante[0]);
                if (linhaAssinante.length >= 3) {
                    String name = linhaAssinante[0];
                    String email = linhaAssinante[1];
                    String id = linhaAssinante[2];                              
               
                        listVotaramCritico.add(new Critico(name,email,id)); // Adcionando candidatos do txt a lista de candidatos local.
                    
                   
                    for(Critico lendoCritico : this.listVotaramCritico){
                        if(lendoCritico.getNome().equals(nomeTxt) && lendoCritico.getEmail().equals(emailTxt)){  
                            System.out.println("Critico ja votou --leitura");
                            return "Usuário ja votou";
                        }
                    }
                    itemTxt = br.readLine();
                } else {
                    String name = linhaAssinante[0];
                    String email = linhaAssinante[1];
                    listVotaramAssinante.add(new EleitorAssinante(name,email)); // Adcionando candidatos do txt a lista de candidatos local.
                    
                     
                    for(EleitorAssinante lendo : this.listVotaramAssinante){
                        if(lendo.getNome().equals(nomeTxt) && lendo.getEmail().equals(emailTxt)){
                            System.out.println( "Assinante ja votou -leitura");
                            return "Usuário ja votou";
                        }
                    }
                    
                    System.out.println("Linha inválida: " + itemTxt);
                    itemTxt = br.readLine();
                    
                }

               
            }
           
            
        }catch (IOException e) { //excessão caso não consiga ler
            System.out.println("Error na leitura :" + e.getMessage());
        }
        return "Usuário ainda não votou";      
    }
}
