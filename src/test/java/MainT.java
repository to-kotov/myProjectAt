import api.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import exel.ExelWork;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainT {
    public static void main(String[] args) throws IOException {

        ExelWork.readFromExcel("C:\\Users\\Василий\\IdeaProjects\\myProject\\src\\test\\java\\exel\\ex1.XLS");
        System.out.println();

//        List<Article> articles = new ArrayList<>();
//        Article art1 = new Article(new ArrayList<String>(),"1","2","","",new ArrayList<>(),"","");
//
//        Article art2 = new Article(art1);
//        ObjectMapper mapper = new ObjectMapper();
//        //JSON file to Java object
//        Article obj = mapper.readValue(new File("C:\\Users\\Василий\\IdeaProjects\\myProject\\src\\test\\java\\api\\article.json"), Article.class);
//        System.out.println(obj.toString());
    }
}
