package steps;

import api.Article;
import impl.ArtivleServiceImpl;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import service.ArticleService;

import java.util.List;

public class StepsImpl {
    ArticleService articleService = new ArtivleServiceImpl();

    public void sendRequestArticlesAndGetResponse(String url) {
        List<Article> articleList = articleService.getArticles(url);

    }



}
