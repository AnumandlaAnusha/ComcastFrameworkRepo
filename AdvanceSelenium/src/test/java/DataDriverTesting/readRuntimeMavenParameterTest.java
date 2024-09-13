package DataDriverTesting;

import org.testng.annotations.Test;

public class readRuntimeMavenParameterTest {
	@Test
	public void runtimeParameterTest() {
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String BROWSER = System.getProperty("browser");
		
		System.out.println("env data ====>url====>"+URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
        System.out.println(BROWSER);

		
	}
	
	

}
