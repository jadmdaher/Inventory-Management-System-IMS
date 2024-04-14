package com.example.ims;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;

public class Model {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "ims";
        String databaseUser = "root";
        String databasePassword = "Mmh_j96_titan";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
}
