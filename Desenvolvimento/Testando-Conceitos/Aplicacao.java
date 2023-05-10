import apuração.*;
import candidatos.*;
import eleitores.Critico;
import eleitores.EleitorAssinante;

import java.util.List;


public class Aplicacao{
    public static void main(String[] args) {

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