package com.roman.server;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    public static void main(String[] args) {

        try{

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restaurant_db?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
                    "root",
                    "Wanrltww2591994rs"
            );

            System.out.println("connection works");

        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}
