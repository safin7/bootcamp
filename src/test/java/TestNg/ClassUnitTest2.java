package TestNg;

import InClassWork.ClassWork;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassUnitTest2 {
    @Test
    @Parameters({"num1","num2","sum"})
    public void testAddition(int num1,int num2, int sum){
        Assert.assertEquals(ClassWork.Addition(num1,num2),sum);

    }


}
