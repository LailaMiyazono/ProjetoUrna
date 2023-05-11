package projetourna.model;

import projetourna.model.abstractAndInterfaces.EleitorBase;


public class Critico extends EleitorBase {
    private String id;
    private String email;
    

    public Critico (String nome, String email, String id){
        super(nome);
        this.email = email.toLowerCase();
        this.id = id;
    }
    public void votar(){
        System.out.println("Critico " + nome + "esta votando.");
    }
    
    public String enviarDados(){
        String dados = super.nome+","+this.email+","+this.id;
        return dados;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
}