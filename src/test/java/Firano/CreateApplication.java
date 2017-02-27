package Firano;

import org.junit.Assert;
import org.testng.annotations.Test;

import settings.CreatPost;
import settings.CreateJson;

/**
 * Created by o.nikolskaya on 27.02.2017.
 */
public class CreateApplication {

    @Test
    public void sendPostRequest () {
        String [][] key = {{"surname", "name", "mobile"},{"Иван", "Иванович", "+7(911)901-99-83"}};
        int responseCode;
        String urlParameters = "?wm_id=4pMd&bank_id=1088&offer_id=28404&token=BqD7Xv2a9zcA9YXB";
        String query = "http://ff.duser046.test/api/rest/v1/applications.json";
        String body_paramm;

        body_paramm = (new CreateJson(key, key.length)).createJson();

        CreatPost requestPost = new CreatPost(query, body_paramm, urlParameters);
        requestPost.connect();
        responseCode = requestPost.createApplication();
        requestPost.disconnect();

        Assert.assertEquals(responseCode,200);
    }
}
