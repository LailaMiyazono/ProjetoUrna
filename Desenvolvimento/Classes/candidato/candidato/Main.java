package candidato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //testando
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do anime e quando for encerrar digite *");
        String iniciar = input.nextLine().toUpperCase();

        List<String> listaAnimesSelecionados = new ArrayList<>();
        List<String> animesNome = new ArrayList<>();
        List<Integer> votosAnimes = new ArrayList<>();
        List<String> separando = new ArrayList<>();


        int primeiro = 0;


        AnimeFilme dragonBall = new AnimeFilme("Dragon Ball");
        AnimeFilme onePierce = new AnimeFilme("One Pierce");
        AnimeFilme jujutsu = new AnimeFilme("Jujutsu");

        while (!iniciar.equals("*")) {

            switch (iniciar) {
                case ("DRAGON"):
                    dragonBall.receberVotos();
                    break;
                case ("ONE"):
                    onePierce.receberVotos();
                    break;
                case ("JUJUTSU"):
                    jujutsu.receberVotos();
                    break;
            }
            iniciar = input.nextLine().toUpperCase();

        }
        //test
        System.out.println(dragonBall.enviarDados());
        System.out.println(onePierce.enviarDados());
        System.out.println(jujutsu.enviarDados());

        listaAnimesSelecionados.add(dragonBall.enviarDados());
        listaAnimesSelecionados.add(onePierce.enviarDados());
        listaAnimesSelecionados.add(jujutsu.enviarDados());
    }



}

