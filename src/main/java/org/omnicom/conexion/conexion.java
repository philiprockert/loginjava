        package org.omnicom.conexion;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

        public class conexion {
    private static String url = "jdbc:mysql://localhost:3306/omnicom";
    private static String user = "root";
    private static String password = "dimebag1971";
    private static Connection conection;


    public static Connection getInstance () throws SQLException {
        if (conection == null){
            conection = DriverManager.getConnection(url, user, password);
        }
        return conection;
    }
}
