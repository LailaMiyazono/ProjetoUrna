public class Aplicacao{
    public static void main(String[] args) {
            Arquivos arquivos = new Arquivos();
            arquivos.lerAnimesFilme("C:/GitProjetos/ProjetoUrna/Desenvolvimento/Testando Conceitos/bancoCandidatos/CandidatosAnimesFilme.txt");
            arquivos.lerAnimesSerie("C:/GitProjetos/ProjetoUrna/Desenvolvimento/Testando Conceitos/bancoCandidatos/CandidatosAnimesSerie.txt");
            arquivos.pushAnimesFilme();
            arquivos.pushAnimesSerie();

        }
}