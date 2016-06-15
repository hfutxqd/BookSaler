package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imxqd on 2016/6/15.
 * 登录动作
 */
public class LoginAction extends ActionSupport {
    public String execute() throws Exception
    {
        ActionContext ct = ActionContext.getContext();
        Map<String, Object> data = ct.getParameters();
        if(data.get("user_name") != null && data.get("user_name").equals("admin"))
        {
            return SUCCESS;
        }else {
            return LOGIN;
        }
    }
}
