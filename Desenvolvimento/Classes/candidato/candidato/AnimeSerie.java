package candidato;

public class AnimeSerie implements Candidato {

    private String nome;
    private int votos;

    public AnimeSerie(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() { return nome;  }

    public void setNome(String nome) {this.nome = nome;  }

    public int getVotos() { return votos; }


    @Override
    public String imprimirDados() {
        System.out.printf("Nome do anime: %s \nQuantidade de votos: %d ",this.nome, this.votos);
        return null;
    }
    public void receberVotos(){
        this.votos++;
        System.out.printf("O anime %s recebeu %d", this.nome, this.votos);
    }
}
/*-nome: String
-categoria: String
-eleito: Boolean
-votos: int
-posição: int
+getNome()
+getCategoria()
+getEleito()
getVotos()
+getPosição()
+setNome()
+setCategoria()
+setEleito()
+setVotos()
+setPosição()
+imprimir_r */