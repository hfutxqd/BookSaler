package action;

import DAO.DBConnection;
import DAO.StockOutDBHelper;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imxqd on 2016/6/16.
 *
 */
public class StockInAction extends ActionSupport {
    private ArrayList<Map<String, String>> data;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Map<String, String>> getData() {
        return data;
    }

    public void setData(ArrayList<Map<String, String>> data) {
        this.data = data;
    }

    public String execute() throws Exception
    {
        data = new ArrayList<>();
        setMessage("test_message");

        StockOutDBHelper helper = new StockOutDBHelper(DBConnection.getConnection());
        HashMap<String, String> map = new HashMap<>();
        map.put("test_key", "test_value");
        map.put("test_key2", "test_valu2e");
        map.put("test_key3", "test_value3");
        map.put("test_key4", "test_value4");
        map.put("test_key5", "test_value5");
        map.put("test_key6", "test_value6");
        map.put("test_key7", "test_value7");

        data.add(map);
        data.add(map);
        data.add(map);
        data.add(map);
        data.addAll(helper.getAll());
        return SUCCESS;
    }
}
