package TestNG.Demo1;

import org.testng.annotations.*;

public class ClassThree {

    @BeforeTest
    public void beforeMyTest()
    {
        System.out.println("beforeMyTest");
    }
    @AfterTest
    public void afterMyTest()
    {
        System.out.println("afterMyTest");
    }

    @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("beforeMySuite1");
    }
    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("afterMySuite1");
    }
    @Test
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
    }
    @Test (groups = "email")
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }
    @Test
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }

}
