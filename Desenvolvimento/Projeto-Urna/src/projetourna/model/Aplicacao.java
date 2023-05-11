package projetourna.model;



import java.util.List;


public class Aplicacao{
    public static void main(String[] args) {
            //classe para testes
            
            // String caminho = System.getProperty("user.dir");
            // System.out.println(caminho);
            Arquivos arquivos = new Arquivos();
            arquivos.lerAnimesFilme();
            arquivos.lerAnimesSerie();
            arquivos.lerCritico();
            arquivos.lerAssinante();
            arquivos.iniciarListas();

            List<AnimeSerie> animeSerie = arquivos.getListAnimesSerie();
            List<AnimeFilme> animeFilmes = arquivos.getListAnimeFilmes();

            for(AnimeSerie anime : animeSerie){
                anime.receberVotos();
            }
            for(AnimeFilme anime : animeFilmes){ //testando votos
                anime.receberVotos();   
                anime.receberVotos();             
            }
           

            arquivos.pushAnimesFilme(animeFilmes);
            arquivos.pushAnimesSerie(animeSerie);
            
            List<EleitorAssinante> listaAssinantes = arquivos.getListAssinantes();
            List<Critico> listaCriticos = arquivos.getListCriticos();
            
            String nome = "ALEFE FREIRE SANTOS";
            String senha = "alefefreiresantos123@gmail.com";

            
            // for (EleitorAssinante assinante : listaAssinantes) { //lendo array de assinantes
            //     if (assinante.getNome().equals(nome) && assinante.getEmail().equals(senha)) { //verificando se os dados batem com algum assinante
            //         if (arquivos.lerJaVotaram(nome, senha, null) != false){ // verificando se o assinante ja votou
            //             arquivos.addVotaram(nome, senha, null);
            //             System.out.println("não encontrou");
            //         }else{
            //             System.out.println("encontrou");
            //         }
            //     }else{
            //         break;
            //     }

            // }
            if (arquivos.lerJaVotaram(nome, senha, null) == null){ // verificando se o assinante ja votou
                arquivos.addVotaram(nome, senha, null);
                System.out.println(true);
            }else{
                System.out.println(false);
            }

            
            System.out.println(nome + senha +arquivos.lerJaVotaram(nome, senha, null));
        }
}