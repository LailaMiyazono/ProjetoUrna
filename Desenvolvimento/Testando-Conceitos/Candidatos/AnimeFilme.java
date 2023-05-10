package candidatos;
public class AnimeFilme implements Candidato {
    
    private String nomeAnimeFilme;
    private Integer votos;

    public Integer getVotos() {
        return votos;
    }

    public AnimeFilme(String nomeAnimeFilme) {
        this.nomeAnimeFilme = nomeAnimeFilme;
        this.votos = 0;
    }

    public String getNomeAnimeFilme() {
        return nomeAnimeFilme;
    }
    public void setNomeAnimeFilme(String nomeAnimeFilme) {
        this.nomeAnimeFilme = nomeAnimeFilme;
    }

    @Override
    public String enviarDados(){
       String dados = this.nomeAnimeFilme + ","+ this.votos;
       return dados;
    }

    @Override
    public void receberVotos() {
       this.votos++;

    }
}
