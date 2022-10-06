import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("SucccessListener: TestSuccess");
	}
	
}