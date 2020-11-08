package base_test;

public class test_proxy {
	public static void main(String[] args) {
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
		
	}
}
