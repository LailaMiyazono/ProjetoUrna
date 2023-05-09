import java.util.List;

public class Aplicacao{
    public static void main(String[] args) {
            Arquivos arquivos = new Arquivos();
            arquivos.lerAnimesFilme("C:/GitProjetos/ProjetoUrna/Desenvolvimento/Testando Conceitos/bancoCandidatos/CandidatosAnimesFilme.txt");
            arquivos.lerAnimesSerie("C:/GitProjetos/ProjetoUrna/Desenvolvimento/Testando Conceitos/bancoCandidatos/CandidatosAnimesSerie.txt");


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