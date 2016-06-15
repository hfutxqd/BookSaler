package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by imxqd on 2016/6/15.
 *
 */
public class UserDBHelper {
    public static String login(String user, String pwd)
    {
        try {
            Connection connection = DBConnection.getConnection();
            ResultSet resultSet =  connection.createStatement()
                    .executeQuery("SELECT * FROM [user] WHERE  [user_name] = '"+user+"' AND [user_pwd] = '"+pwd+"';");
            if(resultSet.next())
            {
                return resultSet.getString(resultSet.findColumn("user_type"));
            }else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
