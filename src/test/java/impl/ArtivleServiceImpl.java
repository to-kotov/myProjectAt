package impl;

import api.Article;
import config.TestConfig;
import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j;
import service.ArticleService;

import java.util.ArrayList;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class ArtivleServiceImpl implements ArticleService {
    TestConfig testConfig = new TestConfig();

    @Override
    public List<Article> getArticles(String url) {
        String URL = testConfig.getURL() + url;

        ValidatableResponse response = given().log().everything().
                get(URL).then().log().ifError();
        RUN_CONTEXT.put("response", response);

        List<Article> articles = new ArrayList<>();

        try {
             articles = response.extract().response().jsonPath().getList("articles.", Article.class);
        } catch (Exception e) {
            e.printStackTrace();
            //error("Article request exception"+ Arrays.toString(e.getStackTrace()));
        }

        return articles;
    }
}
