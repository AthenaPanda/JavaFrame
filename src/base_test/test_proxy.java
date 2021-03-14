package base_test;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class test_proxy {
	public static void main (String[] args) throws ClassNotFoundException {
		/*
		 * static proxy 
		 * 
		 */
		/*
		AdminService adService = new AdminServiceImpl();
		AdminServiceProxy adminServiceProxy = new AdminServiceProxy(adService);
		
		adminServiceProxy.update();
		
		adminServiceProxy.find();*/
		
		/*
		 * Dynamic Proxy
		 */
		AdminService adminService = new AdminServiceImpl();
		AdminServiceInvoketion invoketion = new AdminServiceInvoketion(adminService);
		AdminService proxy = (AdminService)new AdminServiceDynamicProxy(adminService, invoketion).getPersonProxy();
		
		proxy.find();
		proxy.update();
		
		Employee stuffEmployee = new Employee("John", 1000, 2011, 3, 20);
		stuffEmployee.raiseSalary(0.2);
		
		readAnnotation();
		
	}
	
	public static void readAnnotation() throws ClassNotFoundException {
		Field[] fileds = Class.forName("base_test.Employee").getDeclaredFields();
		
	
		for(Field field: fileds)
		{
			boolean hasAnnotation = field.isAnnotationPresent(DemoAnnotation.class);
			if(hasAnnotation) {
			DemoAnnotation demoAnnotation =(DemoAnnotation)field.getAnnotation(DemoAnnotation.class);
			System.out.println("name ="+ demoAnnotation.name());
			}
		}
		
	}
}
