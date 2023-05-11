package projetourna.model.abstractAndInterfaces;

abstract public class EleitorBase implements Eleitor {
    protected  String nome;

    public EleitorBase(String nome){
        this.nome = nome.toUpperCase();
    }

    public String getNome() {
        return nome;
    }
}