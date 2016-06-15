package action;

import DAO.UserDBHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imxqd on 2016/6/15.
 * 登录动作
 */
public class LoginAction extends ActionSupport{
    ActionContext ctx = ActionContext.getContext();
    HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
    HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);

    public String execute() throws Exception
    {
        ActionContext ct = ActionContext.getContext();
        String user = request.getParameter("user_name");
        String pwd = request.getParameter("user_pwd");
        if(user != null && pwd != null)
        {
            String type = UserDBHelper.login(user, pwd);
            if(type != null)
            {
                return type;
            }
        }
        return LOGIN;
    }
}
