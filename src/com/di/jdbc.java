
package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

@Component("jdbc")
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

    private JdbcTemplate jdbcTemplate;



    public void getUserData() throws SQLException {
        conn = dataSource.getConnection();
        String preparedQuery = "SELECT * FROM details  ;";

        PreparedStatement stmt = conn.prepareStatement(preparedQuery);


        ResultSet r = stmt.executeQuery();
        while (r.next()) {
            System.out.println(r.getString("username"));
        }



    }



    public  String getdata()
    {
        //for single value
        return  jdbcTemplate.queryForObject("select username from details",new Object[]{},String.class);
    }

    public  String getSaradata()
    {
        return  jdbcTemplate.queryForObject("select * from details",RowMapper<details>);
    }





    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);

        this.dataSource = dataSource;
    }

//    public static void main(String[] args) {
//        Connection con = null;
////
//
////        try {
////            Class.forName("com.mysql.jdbc.Driver"); // register the driver
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////        try {
////            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trig","root","password");
//
//
//        // Callable
//
//        CallableStatement cs = con.prepareCall("call insert_data('Lohit','22','Male')");
//        CallableStatement cs1 = con.prepareCall("call insert_data('Rishabh','20','Male')");
//        CallableStatement cs2 = con.prepareCall("call insert_data('Shubham','18','Male')");
//
//
//        cs.execute();
//        cs1.execute();
//        cs2.execute();
//
//
//        // PreparedStatement
//        String preparedQuery = "SELECT * FROM details  ;";
//
//        PreparedStatement stmt = con.prepareStatement(preparedQuery);
//
//
//        ResultSet r = stmt.executeQuery();
//        HashMap<String, ArrayList> hm = new HashMap<>();
//
//
//        while (r.next()) {
//            ArrayList<String> al = new ArrayList();
//            al.add(r.getString("age"));
//            // System.out.println(r.getString("username"));
//            hm.put(r.getString("username"), al);
//
//
//        }
//
//        hm.forEach((x, y) -> {
//            System.out.println(x);
//            y.forEach(z -> System.out.println(z));
//
//        });
//
//
//    } catch(
//    SQLException e)
//
//    {
//        e.printStackTrace();
//    }
}
