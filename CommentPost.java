package EnumeracoesComposicao;

import java.text.ParseException; // Importa a classe ParseException do pacote java.text para lidar com exceções relacionadas a análise de texto.
import java.text.SimpleDateFormat; // Importa a classe SimpleDateFormat do pacote java.text para formatar datas.

import entities.composicao.Comment; // Importa a classe Comment do pacote entities.composicao.
import entities.composicao.Post; // Importa a classe Post do pacote entities.composicao.

public class CommentPost {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Cria um objeto SimpleDateFormat para formatar datas no formato "dd/MM/yyyy HH:mm:ss".

        // Criação de comentários.
        Comment c1 = new Comment("Have a nice trip!"); // Cria um comentário com o texto "Have a nice trip!".
        Comment c2 = new Comment("Wow that's awesome!"); // Cria um comentário com o texto "Wow that's awesome!".
        
        // Criação de postagens e adição de comentários.
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand","I'm going to visit this wonderful country!", 12); // Cria uma postagem com a data, título, conteúdo e número de curtidas fornecidos.
        p1.addComment(c1); // Adiciona o comentário c1 à postagem p1.
        p1.addComment(c2); // Adiciona o comentário c2 à postagem p1.

        Comment c3 = new Comment("Good night"); // Cria um comentário com o texto "Good night".
        Comment c4 = new Comment("May the Force be with you"); // Cria um comentário com o texto "May the Force be with you".
        Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomorrow", 5); // Cria uma postagem com a data, título, conteúdo e número de curtidas fornecidos.
        p2.addComment(c3); // Adiciona o comentário c3 à postagem p2.
        p2.addComment(c4); // Adiciona o comentário c4 à postagem p2.

        // Exibe as postagens.
        System.out.println(p1); // Exibe os detalhes da postagem p1.
        System.out.println(p2); // Exibe os detalhes da postagem p2.
    }
}