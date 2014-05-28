package Test_4.test_4;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
	private String user;
	private String password;
	private UserValidator validator;
	
	public TaskValidator(String user,String password,UserValidator validator){
		this.user = user;
		this.password = password;
		this.validator = validator;
	}
	public String call() throws Exception {
		// TODO Auto-generated method stub
		if(!this.validator.validate(user, password)){
			System.out.printf("%s: The user has not been found\n",validator.getName());
			throw new Exception("Error validating user");
		}
			System.out.printf("%s: The user has been found\n",validator.getName());
			return validator.getName();
	}

}
