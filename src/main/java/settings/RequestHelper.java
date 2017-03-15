package settings;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RequestHelper {
    String line = "";
    HttpClient client = new DefaultHttpClient();
    HttpResponse response;


    public HttpResponse getRequest(String url){
        HttpGet request = new HttpGet(url);
        try {
            response = this.client.execute(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    public HttpResponse postRequest(String url, JSONObject paramsJson){
        HttpPost post = new HttpPost(url);
        try {
            StringEntity params = new StringEntity(paramsJson.toString(), "UTF-8");
            post.setEntity(params);
            post.setHeader("Content-type", "application/json");
            response = client.execute(post);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}

