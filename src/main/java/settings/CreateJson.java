package settings; /**
 * Created by o.nikolskaya on 21.02.2017.
 */
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class CreateJson {
    int length;
    String [][] key = new String [length][2];
    JSONObject resultJson = new JSONObject();

    public CreateJson(String key [][], int length){
        this.key = key;
        this.length = length;
    }

    public String createJson(){

             for(int i = 0; i <= this.length; i++){
                 try {
                     resultJson.put(this.key[0][i],this.key[1][i]);
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
             }


    return resultJson.toString();
    }

}
