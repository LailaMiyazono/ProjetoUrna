package eleitores;
public class Admin extends EleitorBase {
    private String email;

    public Admin (String nome, String email){
        super(nome);
        this.email = email;
    }
    public void votar(){
        System.out.println("Insira o numero do anime que deseja votar, " + nome);
    }
}