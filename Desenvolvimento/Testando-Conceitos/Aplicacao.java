import apuração.Arquivos;
import candidatos.AnimeFilme;
import candidatos.AnimeSerie;

import java.util.List;

public class Aplicacao{
    public static void main(String[] args) {
            Arquivos arquivos = new Arquivos();
            arquivos.lerAnimesFilme();
            arquivos.lerAnimesSerie();

            List<AnimeSerie> animeSerie = arquivos.getListAnimesSerie();
            List<AnimeFilme> animeFilmes = arquivos.getListAnimeFilmes();

            

            for(AnimeSerie anime : animeSerie){
                anime.receberVotos();
            }
            for(AnimeFilme anime : animeFilmes){ //testando votos
                anime.receberVotos();
            }
            arquivos.pushAnimesFilme(animeFilmes);
            arquivos.pushAnimesSerie(animeSerie);

        }
}