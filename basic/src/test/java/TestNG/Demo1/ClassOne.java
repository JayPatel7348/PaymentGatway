package TestNG.Demo1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ClassOne {

    @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("beforeMySuite");
    }
    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("afterMySuite");
    }



    @Test //(enabled = false) //this will disable the test case during execution
    public void classOneTest1()
    {

        System.out.println("classOneTest1");

    }
    @Test (groups = "email")
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }
    @Test (groups = "email",invocationCount = 2) //(invocationCount=x) will execute test case for multiple(x) times
    public void classOneTest3()
    {
        System.out.println("classOneTest3");
    }

}
