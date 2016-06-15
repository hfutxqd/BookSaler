package DAO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class DBConnection {
    public static final String DRIVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DATABASE = "BOOK_SALES";
    public static final String HOST = "172.16.21.36:1433";
    
    public static Connection getConnection() {
        String driverName = DRIVERNAME;  //加载JDBC驱动
        String dbURL = "jdbc:sqlserver://"+HOST+"; DatabaseName="+DATABASE;  //连接服务器和数据库
        try {
            Class.forName(DRIVERNAME);
            return DriverManager.getConnection(dbURL, "sa", "517517");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void BackUP(String filename, Connection connection) throws SQLException
    {
        Statement statement = connection.createStatement();
        String SQL =
                "BACKUP DATABASE "+DATABASE+"\n" +
                "TO DISK = '"+filename+"' \n" +
                "WITH FORMAT;";
        statement.execute(SQL);
        statement.close();
    }
    
    public static void Restore(String filename, Connection connection) throws SQLException
    {
        Statement statement = connection.createStatement();
        //使数据库离线
        statement.execute("ALTER DATABASE "+DATABASE+" SET OFFLINE WITH ROlLBACK IMMEDIATE;");
        //恢复数据库
        statement.execute("USE master RESTORE DATABASE "+DATABASE+" FROM DISK='"+
                filename+"' WITH REPLACE,RECOVERY");
        statement.close();
    }

    public static void main(String[] args)
    {
        System.out.println(UserDBHelper.login("admin", "admin"));
    }
}