package EnumeracaoComposicao.composicao.exercicio02;

import EnumeracaoComposicao.composicao.exercicio02.entities.Coment;
import EnumeracaoComposicao.composicao.exercicio02.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class PostApp {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);

        Coment coment1 = new Coment("Have a nice trip!");
        Coment coment2 = new Coment("wow thats awsome!");

        Post post1 = new Post(sdf.parse(
                "10/04/2023 15:30:00"),
                "Traveling to new Zeeland",
                "I am going to visit this wonderful country!",
                12
        );

        post1.addComment(coment1);
        post1.addComment(coment2);

        System.out.println(post1);
        System.out.println(post1);
    }
}
