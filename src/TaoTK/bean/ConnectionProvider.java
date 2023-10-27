/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaoTK.bean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sontr
 */
class ConnectionProvider {
       private static final String DATABASE_SERVER = "localhost";
    private static final String DATABASE_NAME = "QLDA";
    private static final String DATABASE_USERNAME = "sa";
    private static final String DATABASE_PASSWORD = "12345678";

    private static Connection conn;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            /* Bước 1. Tải DB driver. */
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            /* Bước 2. Tạo Connection String. */
            String strConnection = String.format("jdbc:sqlserver://%s;DatabaseName=QLDA;TrustServerCertificate=true;",
                    DATABASE_SERVER, DATABASE_NAME);

            /* Bước 3. Tạo Connection Object. */
            conn = DriverManager.getConnection(strConnection, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (Exception ex) {
            conn = null;
        }

        return conn;
    }
}
