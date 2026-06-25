package EnumeracaoComposicao.composicao.exercicio02.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
   private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private String title;
    private String content;
    private Integer likes   ;

    //Associação
    private List<Coment> comments =new ArrayList<Coment>();

    public Post() {
        //construtor vazio
    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    //METODOS
    public void addComment(Coment comment){
        comments.add(comment);
    }

    public void removeComment(Coment comment){
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("title: " + title + "\n");
        sb.append(likes);
        sb.append(" Likes - ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("content: " + content + "\n");
        sb.append("comments: \n");

        for (Coment comment : comments) {
            sb.append(comment.getText() + "\n");
        }

        return sb.toString();
    }
}
