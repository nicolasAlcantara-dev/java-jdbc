package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/teste_service";
    private static final String USER = "root";
    private static final String PASS = "Bmn262252";

    public static Connection getConnection () {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
        try {
            if(ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}


