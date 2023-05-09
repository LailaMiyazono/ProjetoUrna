
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
    public String enviarDados() {
        String dados = this.nome +","+ this.votos;
        return dados;
    }
    public void receberVotos(){
        this.votos++;
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