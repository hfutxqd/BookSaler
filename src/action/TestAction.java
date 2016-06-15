package action;

import DAO.UserDBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by imxqd on 2016/6/15.
 *
 */
public class TestAction extends ActionSupport {
    public final static String MESSAGE = "Hello world ...";
    private String message;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String execute() throws Exception
    {
        setMessage(MESSAGE);
        return LOGIN;
    }
}
