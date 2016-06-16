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
    public ArrayList<Map<String, String>> getData() {
        return data;
    }

    public void setData(ArrayList<Map<String, String>> data) {
        this.data = data;
    }

    public String execute() throws Exception
    {
        data = new ArrayList<>();
        StockOutDBHelper helper = new StockOutDBHelper(DBConnection.getConnection());
        HashMap<String, String> map = new HashMap<>();
        data.addAll(helper.getAll());
        return SUCCESS;
    }
}
