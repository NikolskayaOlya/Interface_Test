package settings;

import org.junit.Test;

import java.sql.*;

/**
 * Created by o.nikolskaya on 21.02.2017.
 */
public class ConnectDB {

    String password;
    String user;
    String url;

    ResultSet result;
    Connection connect;
    Statement state;

    public ConnectDB(String password, String user, String url){
         this.password = password;
         this.user =user;
         this.url = url;
    }

    public void connectDB() throws SQLException, ClassNotFoundException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://" + this.url;

        Class.forName(JDBC_DRIVER);
        this.connect = DriverManager.getConnection(DB_URL, this.user, this.password);
    }

    public ResultSet getQueruResult (String sql) throws SQLException {
        this.state = this.connect.createStatement();
        this.result = this.state.executeQuery(sql);

        return result;
    }

    public void disconnectDB() throws SQLException {
        this.result.close();
        this.state.close();
        this.connect.close();
    }

}
