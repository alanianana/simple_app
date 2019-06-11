package sample.service;

import org.apache.log4j.Logger;

import java.sql.*;

public class BookServ{
    private static final Logger log=Logger.getLogger(BookServ.class);
    public static boolean addBook(String bk_name, String aut_name, String aut_surname, String genre, Date year) throws SQLException {
        boolean isAdded = false;
        String conn = "jdbc:sqlserver://localhost;databaseName=mybase;integratedSecurity=true;";
        Connection myConn = DriverManager.getConnection(conn);
        PreparedStatement st = myConn.prepareStatement("INSERT INTO Book(bk_name,aut_name,aut_surname,genre,year) VALUES  ('"+bk_name+"','"+aut_name+"','"+aut_surname+"','"+genre+"','"+year+"')");

        st.execute();
        int rows = st.executeUpdate();
        if (rows>0){
            isAdded = true;
        }
        if (isAdded==true) {
            log.info("წიგნის მონაცემები წარმატებით დაემატა");
            return true;
        }else {
            log.error("შეცდომა : წიგნის მონაცემები ვერ დაემატა");
            return false;}
    }
}
