package sample.service;
import org.apache.log4j.Logger;

import java.sql.*;
public class AutServ {
    private static final Logger log=Logger.getLogger(AutServ.class);
    public static boolean Authorisation (String login, String password) throws SQLException {
        boolean isAuthorised = false;
        String conn = "jdbc:sqlserver://localhost;databaseName=mybase;integratedSecurity=true;";
        Connection myConn = DriverManager.getConnection(conn);
        Statement st = myConn.createStatement();
        ResultSet myResultSet = st.executeQuery("SELECT * FROM  Users ");
        while (myResultSet.next()) {
            if ( login.equals(myResultSet.getString("login")) && password.equals(myResultSet.getString("password")) ){
                isAuthorised = true;
                break;
            }
        }
        if (isAuthorised==true) {
            log.info("ანგარიშზე წარმატებული შესვლა: login"+login+" password "+password);
            return true;
        }else {
            log.error("ანგარიშზე შესვლის შეცდიომა: პაროლი ან ლოგინი მოიძებნა login "+login+" password " +password);
            return false;}


}
}
