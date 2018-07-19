
package com.di;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class jdbc {

    /*

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_data`( username varchar(20) ,  age Int(3),  gender varchar (10))
    //BEGIN
    //insert into details values(username,age,gender);
    //END
    */
    @Autowired
    private DataSource dataSource;

    static int re_new = 0;

    private Connection conn;
public String getUserData() throws SQLException {
     conn = dataSource.getConnection();

     return "ok";
}


    public static void main(String[] args) {
        Connection con = null;
//

//        try {
//            Class.forName("com.mysql.jdbc.Driver"); // register the driver
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trig","root","password");


        // Callable

        CallableStatement cs = con.prepareCall("call insert_data('Lohit','22','Male')");
        CallableStatement cs1 = con.prepareCall("call insert_data('Rishabh','20','Male')");
        CallableStatement cs2 = con.prepareCall("call insert_data('Shubham','18','Male')");


        cs.execute();
        cs1.execute();
        cs2.execute();


        // PreparedStatement
        String preparedQuery = "SELECT * FROM details  ;";

        PreparedStatement stmt = con.prepareStatement(preparedQuery);


        ResultSet r = stmt.executeQuery();
        HashMap<String, ArrayList> hm = new HashMap<>();


        while (r.next()) {
            ArrayList<String> al = new ArrayList();
            al.add(r.getString("age"));
            // System.out.println(r.getString("username"));
            hm.put(r.getString("username"), al);


        }

        hm.forEach((x, y) -> {
            System.out.println(x);
            y.forEach(z -> System.out.println(z));

        });


    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }
}
}