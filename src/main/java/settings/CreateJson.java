package settings; /**
 * Created by o.nikolskaya on 21.02.2017.
 */
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class CreateJson {

    public  JSONObject jsonData (String jsonString){
        JSONObject  jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
