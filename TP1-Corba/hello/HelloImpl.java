package hello;

import org.omg.CORBA.ORB;

public class HelloImpl extends HelloPOA {
	private ORB orb;

	@Override
	public void sayHello() {
		System.out.println("Hello World!");
	}
	
	public void setORB(ORB orb_val) {
        orb = orb_val;
    }

}
