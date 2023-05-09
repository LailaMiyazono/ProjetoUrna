public class AnimeFilme implements Candidato {
    
    private String nomeAnimeFilme;
    private String votos;

    public AnimeFilme(String nomeAnimeFilme, String votos) {
        this.nomeAnimeFilme = nomeAnimeFilme;
        this.votos = votos;
    }

    public AnimeFilme(String nomeAnimeFilme) {
        this.nomeAnimeFilme = nomeAnimeFilme;
        this.votos = "0";
    }

    public String getNomeAnimeFilme() {
        return nomeAnimeFilme;
    }
    public void setNomeAnimeFilme(String nomeAnimeFilme) {
        this.nomeAnimeFilme = nomeAnimeFilme;
    }

    @Override
    public String enviarDados(){
        return  this.nomeAnimeFilme + " "+ this.votos;
    }

    @Override
    public void receberVotos() {
        int votos = Integer.parseInt(this.votos);
       votos++;
       this.votos = String.valueOf(votos);

    }
}
