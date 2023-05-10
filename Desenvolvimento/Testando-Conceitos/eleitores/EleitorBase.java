package eleitores;
abstract public class EleitorBase implements Eleitor {
    protected  String nome;

    public EleitorBase(String nome){
        this.nome = nome.toUpperCase();
    }
}