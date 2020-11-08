package base_test;

import java.lang.reflect.*;

public class AdminServiceInvoketion implements InvocationHandler {
	
	private Object target;
	
	public AdminServiceInvoketion(Object target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("start proxy");
		Object obj = method.invoke(target);
		System.out.println("end proxy");
		return obj;
	}

}
