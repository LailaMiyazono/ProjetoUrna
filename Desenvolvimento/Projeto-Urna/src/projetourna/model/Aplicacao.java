package projetourna.model;



import java.util.List;
import projetourna.controller.Arquivos;


public class Aplicacao{
    public static void main(String[] args) {
            //classe para testes
            
            // String caminho = System.getProperty("user.dir");
            // System.out.println(caminho);
            Arquivos arquivos = new Arquivos();
            arquivos.lerAnimesFilme();
            arquivos.lerAnimesSerie();
            arquivos.lerCritico();
            arquivos.lerAssinante();

            List<AnimeSerie> animeSerie = arquivos.getListAnimesSerie();
            List<AnimeFilme> animeFilmes = arquivos.getListAnimeFilmes();

            for(AnimeSerie anime : animeSerie){
                anime.receberVotos();
            }
            for(AnimeFilme anime : animeFilmes){ //testando votos
                anime.receberVotos();   
                anime.receberVotos();             
            }
           

            arquivos.pushAnimesFilme(animeFilmes);
            arquivos.pushAnimesSerie(animeSerie);
            arquivos.push();
            
        }
}