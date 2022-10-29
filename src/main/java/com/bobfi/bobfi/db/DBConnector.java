package com.bobfi.bobfi.db;

import java.sql.*;

public class DBConnector {

    String url = "jdbc:mysql://localhost:3300/bobfi";
    String username = "root";
    String password = "your-password";
    Connection con;
    Statement statement;
    ResultSet result;

    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean write(String query) throws SQLException {
        int n = statement.executeUpdate(query);
        return n==1;
    }

    public boolean read(String query) throws SQLException {
        result = statement.executeQuery(query);
        while (result.next()){
            if (result.getInt(1) == 1) {
                return true;
            }
        }
        return false;
    }

    public ResultSet getUser(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = " + id + "";
        result = statement.executeQuery(query);
        return result;
    }

    public int findUser(String email) throws SQLException {
        String query = "SELECT user_id FROM users WHERE email = '" + email + "'";
        result = statement.executeQuery(query);
        if (result.next()){
            return result.getInt(1);
        }
        return 0;
    }

}
