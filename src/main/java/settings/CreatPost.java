package settings;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import static org.jboss.netty.handler.codec.rtsp.RtspHeaders.Names.USER_AGENT;

/**
 * Created by o.nikolskaya on 25.02.2017.
 */
public class CreatPost {

    int responseCode;
    String query;
    String body_paramm;
    String urlParameters;
    HttpURLConnection connection = null;


    public CreatPost(String query, String body_paramm, String urlParameters){
        this.query = query;
        this.body_paramm = body_paramm;
        this.urlParameters = urlParameters;
    }

    public void connect(){
        try {
            connection = (HttpURLConnection) new URL(this.query + this.urlParameters).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int createApplication(){

        try {
            OutputStream os = connection.getOutputStream();
            byte[] data = this.body_paramm.getBytes("UTF-8");
            os.write(data);
            this.responseCode = connection.getResponseCode();
        } catch (Throwable cause){
            cause.printStackTrace();
        }
        System.out.println(responseCode);

        return this.responseCode;
    }

    public void disconnect(){
        connection.disconnect();
    }

}
