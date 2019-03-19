package com.evry.util;
import java.sql.*;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection conn;
    private Statement statement;
    public static DataBaseConnection db;
    private DataBaseConnection() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "evryBank";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Root@123";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized DataBaseConnection getDbCon() {
    	System.out.println("get conn------------------------------------------");
        if ( db == null ) {
            db = new DataBaseConnection();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet getQuery(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
}




