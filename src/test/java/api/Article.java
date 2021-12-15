
package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private List<String> categories;
    private String content;
    private String date;
    private String lang;
    private String layout;
    private List<Object> tags;
    private String title;
    private String url;
    //private List<String> topics;

    public Article(ArrayList<String> strings) {
    }

//    public Article(Article art1) {
//        this.categories = art1.getCategories();
//        this.content = art1.getContent();
//        this.date = art1.getDate();
//        this.lang = art1.getLang();
//        this.layout = art1.layout;
//        this.tags = art1.getTags();
//        this.title= art1.getTitle();
//        this.url = art1.getUrl();
//    }
//
//    public <E> Article(ArrayList<String> strings, String s, String s1, String s2, String s3, ArrayList<E> es, String s4, String s5) {
//    }
}
