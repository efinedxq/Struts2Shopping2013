package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = arg0.getInvocationContext();
		
		String user = (String)ctx.getSession().get("user");
		
		if(user != null && user.equals("123")){
			return arg0.invoke();
		}
		
		ctx.put("tip", "您还没有登录，请使用123登录系统");
		
		return Action.LOGIN;
	}

}
