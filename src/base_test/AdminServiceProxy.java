package base_test;

public class AdminServiceProxy implements AdminService {

	private AdminService adminServe;
	
	public AdminServiceProxy(AdminService adminSer) {
		// TODO Auto-generated constructor stub
		this.adminServe = adminSer;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("proxy start update data");
		adminServe.update();
		System.out.println("proxy end update data");
	}

	@Override
	public Object find() {
		// TODO Auto-generated method stub
		System.out.println("proxy check data");
		return adminServe.find();
	}

}
