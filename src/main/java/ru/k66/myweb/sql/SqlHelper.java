package ru.k66.myweb.sql;



import ru.k66.myweb.model.Human;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by ikydp on 28.07.2016.
 */
public class SqlHelper {


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
private static final String TABBLE_NAME = "HUMANSLIST";


    // TESTING
    public static void main(String[] args) throws SQLException {
        SqlHelper www = new SqlHelper();
        Human kaka = new Human(Integer.valueOf(0) ,"kaka", "kaka2", "kaka3", "kaka4","kaka5");

        www.addHuman(kaka);
    }


    public ArrayList<Human> getSQLData(String string){


        ArrayList<Human> humans = new ArrayList<Human>();


        String query = "SELECT * from " +
                TABBLE_NAME +
                " where concat(id,first,second,last,car,city) like '%"
                + string+ "%';";
        //System.out.println(query);
        try {
            con = DriverManager.getConnection(url1, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);


        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String second = rs.getString(3);
            String last = rs.getString(4);
            String car = rs.getString(5);
            String city = rs.getString(6);
            humans.add(new Human(id,name,second,last,car,city));

        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
finally {
            //close connection ,stmt and resultset here
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
            if (rs !=null) {


                try {
                    rs.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
        }
        return humans;
    }

    public   void  addHuman(Human human){

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url1, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

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


            String queryMAX_ID =   "SELECT MAX(id) AS id FROM " + TABBLE_NAME          ;

            rs = stmt.executeQuery(queryMAX_ID);
            int maxID = 0;
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
            human.setId((maxID+1));

            String query = "INSERT INTO " +
                    TABBLE_NAME +
                    " (id,  first, second, last, car, city) " +
                    " VALUES (" +
                    Integer.valueOf(maxID+1) + ",'" +
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
     catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
    } finally {
        //close connection ,stmt and resultset here
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }

    }
    }

}



