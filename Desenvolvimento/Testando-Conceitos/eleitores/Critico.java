package eleitores;
public class Critico extends EleitorBase {
    private String id;

    public Critico (String nome, String id){
        super(nome);
        this.id = id;
    }
    public void votar(){
        System.out.println("Critico " + nome + "esta votando.");
    }
}