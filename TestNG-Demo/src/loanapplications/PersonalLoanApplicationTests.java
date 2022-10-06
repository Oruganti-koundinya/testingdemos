package loanapplications;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class PersonalLoanApplicationTests {

	@Parameters({"URL"})
	@Test()
	public void PersonalLoanLoginWeb(String url) {
		System.out.println("Personal loan application - web login test");
		System.out.println("Weg login url= " + url);
	}
	
	@Test
	public void PersonalLoanLoginMobile() {
		System.out.println("Personal loan application - mobile login test");
	}
	
	@Test
	public void PersonalLoanLoginAPI() {
		System.out.println("Personal loan application - API login test");
	}
}