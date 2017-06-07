package br.com.season.springproject.service;

public class HelloWorldServiceImpl implements HelloWorldService{
	String user;

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
		this.setUser(name);
	}
	
	public String getUser() {
		return user;
	}

	private void setUser(String user) {
		this.user = user;
	}
	

}
