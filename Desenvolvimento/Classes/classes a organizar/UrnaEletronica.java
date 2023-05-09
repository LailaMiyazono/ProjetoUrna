import java.util.ArrayList;
import java.util.List;

public class UrnaEletronica implements Urna {
    private List<EleitorBase> eleitores;
    private List<Candidato> animes;

    public UrnaEletronica() {
        this.eleitores = new ArrayList<>();
    }
    public void configurarUrna(){
        System.out.println("Urna eletronica configurada com sucesso!");
    }
    public void exibirResultado(){
        for (Candidato anime : animes) {
            anime.imprimirDados();
        }
    }
    public void adicionarEleitor(EleitorBase eleitor) {
        eleitores.add(eleitor);
    }
    public void adicionarCandidato(Candidato anime) {
        animes.add(anime);
    }
    public void votar(EleitorBase eleitor, Candidato anime) {
        eleitor.votar();
        anime.receberVotos();
    }
}