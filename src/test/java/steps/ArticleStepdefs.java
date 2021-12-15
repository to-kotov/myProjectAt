package steps;

import api.Article;
import impl.ArtivleServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.ArticleService;

import java.util.List;

import static context.RunContext.RUN_CONTEXT;

public class ArticleStepdefs {
    StepsImpl steps = new StepsImpl();
    @Given("Отправить запрос статей  с {string} и получить ответ со статусом")
    public void sendRequestArticlesAndGetResponse(String url) {
        steps.sendRequestArticlesAndGetResponse(url);
    }

    @Then("Код ответа : {string}")
    public void checkStatusCode(String status) {
        ValidatableResponse response = RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatusCode = response.extract().statusCode();
        int expectedStatusCode = Integer.parseInt(status);

        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }
}
