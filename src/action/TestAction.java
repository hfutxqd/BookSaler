package action;

import DAO.UserDBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

/**
 * Created by imxqd on 2016/6/15.
 *
 */
public class TestAction extends ActionSupport {
    public final static String MESSAGE = "Hello world ...";
    private ArrayList<String> message;

    public ArrayList<String> getMessage()
    {
        return message;
    }

    public void setMessage(ArrayList<String> message)
    {
        this.message = message;
    }

    public String execute() throws Exception
    {
        message = new ArrayList<>();
        message.add("1 ----------------------------");
        message.add("2 ----------------------------");
        message.add("3 ----------------------------");
        message.add("4 ----------------------------");
        return LOGIN;
    }
}
