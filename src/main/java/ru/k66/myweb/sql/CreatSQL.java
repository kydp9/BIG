package ru.k66.myweb.sql;



import ru.k66.myweb.model.Human;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ikydp on 27.07.2016.
 */
public class CreatSQL {



    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/mybase";
    private static final String url1 = "jdbc:mysql://localhost:3306/mybase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    private static final String user = "root";
    private static final String password = "admin";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;



    public void  createNewTabble() throws SQLException {



        try{
            //STEP 2: Register JDBC driver
            //      Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(url1, user, password);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = con.createStatement();

            String sql = "CREATE TABLE HUMANSLIST " +
                    "(id INTEGER AUTO_INCREMENT , " +
                   // "(id INT(11) AUTO_INCREMENT FIRST,"+
                    " first VARCHAR(255), " +
                    " second VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " car  VARCHAR(255), " +
                    " city  VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    con.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }

    public void  createWeatherTabble() throws SQLException {



        try{
            //STEP 2: Register JDBC driver
            //      Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(url1, user, password);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = con.createStatement();

            String sql = "CREATE TABLE WEATHER  " +
                     // "(id INT(11) AUTO_INCREMENT FIRST,"+
                    "(city VARCHAR(100), " +
                    " PRIMARY KEY ( city ),"+
                            "date DATE, " +
                    " wDay1Day INT (10), " +
                    " wDay1Evng INT (10), " +
                    " wDay2Day INT (10), " +
                    " wDay2Evng INT (10), " +
                    " wDay3Day INT (10), " +
                    " wDay3Evng INT (10) " +
                    ")" ;


            /*
            private  String city;
    private Date date;
    private int wDay1Day;
    private int wDay1Evng;
    private int wDay2Day;
    private int wDay2Evng;
    private int wDay3Day;
    private int wDay3Evng;
             */
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    con.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }

    public void  createUserTabble() throws SQLException {



        try{
            //STEP 2: Register JDBC driver
            //      Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(url1, user, password);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = con.createStatement();

            String sql = "CREATE TABLE USERDATA " +
                    "(userId INTEGER AUTO_INCREMENT , " +
                    // "(id INT(11) AUTO_INCREMENT FIRST,"+
                    " name VARCHAR(50), " +
                    " second VARCHAR(50), " +
                    " surname VARCHAR(50), " +
                    " sendto  VARCHAR(50), " +
                    " email  VARCHAR(50), " +
                    " subject  VARCHAR(50), " +
                    " text  VARCHAR(254), " +
                    " PRIMARY KEY ( userId ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    con.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

    }

            public static void main(String[] args) throws SQLException {
SqlHelper sqlHelper = new SqlHelper();
                CreatSQL creatSQL = new CreatSQL();

                creatSQL.createNewTabble();
                creatSQL.addRandomHumans(100);

creatSQL.createWeatherTabble();
                creatSQL.createUserTabble();

    }//end main

// добавление Х записей в таблицу
private  void addRandomHumans(int x ) {


    try {
        // opening database connection to MySQL server
        con = DriverManager.getConnection(url1, user, password);

        // getting Statement object to execute query
        stmt = con.createStatement();

        // executing SELECT query

        RandomList randomHumans = new RandomList();

       ArrayList<Human>  humanArrayList = randomHumans.getRandomhumans(x);
Human human;
for(int i = 0 ; i < x; i++) {

    human = humanArrayList.get(i);
    String name = human.getName();
    if(name.length()>253){
        name = name.substring(0, 253);
    }

    String second = human.getSecondName();
    if(second.length()>253){
        second = second.substring(0, 253);
    }

    String surname   = human.getSurname();
    if(surname.length()>253){
        surname = surname.substring(0, 253);
    }


    String car = human.getCar();
    if(car.length()>253){
        car = car.substring(0, 253);
    }

    String city = human.getCity();
    if(city.length()>253){
        city = city.substring(0, 253);
    }


    String query = "INSERT INTO HUMANSLIST (id,  first, second, last, car, city) " +
    " VALUES (" +
            Integer.valueOf(i+1) + ",'" +
            name + "','" +
            second + "','" +
            surname + "','" +
            car + "','" +
            city + "');"  ;




    /*

     */

// executing SELECT query
    stmt.executeUpdate(query);
}


    } catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        //close connection ,stmt and resultset here
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }

    }
}


}
