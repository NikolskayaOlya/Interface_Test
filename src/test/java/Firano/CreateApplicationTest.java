package Firano;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import settings.CreateJson;
import settings.RequestHelper;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by o.nikolskaya on 27.02.2017.
 */
public class CreateApplicationTest {

    String url = "http://ff.duser046.test/api/rest/v1/applications.json?wm_id=4pMd&bank_id=1088&offer_id=28404&token=BqD7Xv2a9zcA9YXB";
    String jsonString = "{\"surname\":\"Иван\",\"name\":\"Петров\",\"mobile\":\"+7(901)921-90-91\"}";
    CreateJson json = new CreateJson();
    RequestHelper request = new RequestHelper();
    JSONObject param;
    HttpResponse response;
    String content;
    JSONObject jsonAnswer;

    @BeforeTest
    public void start(){
        param = json.jsonData(jsonString);
    }


    @Test(description = "Send application to Firano")
    public void sendBankApplication () {
        response = request.postRequest(url, param);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }
// еще не тест
    @Test(description = "Get id of application in Firano")
    public void getIdApplication () {
        response = request.postRequest(url, param);
        try {
            content = EntityUtils.toString(response.getEntity());
            jsonAnswer = json.jsonData(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonAnswer);
    }

    @Test(description = "Get PROMO")
    public void getPromo () {
        response = request.getRequest("http://cityads.com/api/rest/webmaster/xml/promo/4325?limit=1&start=%202&remote_auth=6420072d37bf14f1df182d0fe0efa2d9");
        try {
            content = EntityUtils.toString(response.getEntity());
         //   jsonAnswer = json.jsonData(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        System.out.println(response.getStatusLine().getStatusCode());

    }

}


