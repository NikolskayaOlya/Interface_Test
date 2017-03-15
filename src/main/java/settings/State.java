package settings;

import settings.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by o.nikolskaya on 24.02.2017.
 */
public class State {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id, bank_application_id FROM ApplicationBank WHERE application_id =2976624";
        String db_url = "81.177.161.195:3306/alpha_firano";
        String password ="ek77SGxFQG";
        String user = "o.nikolskaya";
        int id = 0;
        int bank_application_id = 0;
        ResultSet result;

        ConnectDB conDB = new ConnectDB(password, user, db_url);
        Statement stmt;
        conDB.connectDB();

        result = conDB.getQueruResult(sql);

        System.out.println(result);
        while(result.next()){
            id = result.getInt("id");
            bank_application_id = result.getInt("bank_application_id");
        }
        conDB.disconnectDB();

        System.out.println("id = " + id);
        System.out.println("bank_application_id = " + bank_application_id);



    }
}
