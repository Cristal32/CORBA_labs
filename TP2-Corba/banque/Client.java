package banque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;

import hello.Hello;
import hello.HelloHelper;

public class Client {
	public static void main(String args[]) {
		 
		 java.util.Properties props = System.getProperties();
		
		 int status = 0;
		 ORB orb = null;
		
		 try {
			 // Initialize orb
			 orb = ORB.init(args, props);
			 status = run(orb);
		 } catch(Exception ex) {
			 ex.printStackTrace();
			 status = 1;
		 }
		
		 if(orb != null) {
			 try {
				 orb.destroy();
			 } catch(Exception ex) {
				 ex.printStackTrace();
				 status = 1;
			 }
		 }
		
		 System.exit(status);
	 }
	
	 static int run(ORB orb) throws IOException {
		 org.omg.CORBA.Object obj = null;
		 
		 // Link to distant object
		 String ref = null;
		 String refFile = "Hello.ref";
		 FileInputStream file = new FileInputStream(refFile);
		 BufferedReader in = new BufferedReader(new InputStreamReader(file));
		 ref = in.readLine();
		 file.close();

		 obj = orb.string_to_object(ref);
		 
		 Hello hello = HelloHelper.narrow(obj);
		 
		 // Call operations
		 try {
			 hello.sayHello();
		 } catch(SystemException ex) {
			 System.err.println(" -- Erreur CORBA -- \n" + ex.getMessage());
			 ex.printStackTrace();
			 return 1;
		 }
		 
		 return 0;
	}
}
