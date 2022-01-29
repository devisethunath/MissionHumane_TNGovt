package revisePavan;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisationTest {

	//@Parameters("a")
	@Parameters({"a","b"})
	@	Test
	public void m1(String s1 ,String s2)
	{
		System.out.print(s1+s2);
	}
}
