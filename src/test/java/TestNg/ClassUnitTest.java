package TestNg;

import InClassWork.ClassWork;
import InClassWork.StackExample;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TestNG (Test Next Generation) is a popular testing framework for Java, designed to make testing easier and more flexible.
 * It provides functionalities for writing and running tests, organizing test suites, generating reports, and supporting various
 * types of testing such as unit, integration, and functional testing.
 *
 * ---------Features---------
 * 1> Annotation
 * 2> Test Suits
 * 3> Parameterized Tests
 * 4> Dependency Management
 * 5> Parallel Execution
 * 6> Reporting
 * 7> Listeners
 *
 * -------TestNg Annotations-------
 * @Test
 * @BeforeClass / @AfterClass
 * @BeforeSuite / @AfterSuite
 * @BeforeMethod / @AfterMethod
 *
 */
public class ClassUnitTest {
    @Test

    public void testArray123(){
        int arr1[] = {1, 1, 2, 3, 1};
        int arr2[] = {1, 1, 2, 4, 1};
        int arr3[] = {1, 1, 2, 1, 2, 3};

        Assert.assertTrue(ClassWork.array123(arr1));
        Assert.assertFalse(ClassWork.array123(arr2));
        Assert.assertTrue(ClassWork.array123(arr3));
    }
    @Test
    public void testStringBits(){
        String tst = "abc";
        Assert.assertEquals("Hlo",ClassWork.stringBits("Hello"));
        Assert.assertNotEquals(tst,ClassWork.stringBits("Hello"));
    }
    @Test
    public void testStringSplosion(){
        Assert.assertEquals("hhehelhellhello",ClassWork.stringSplosion("hello"));
        Assert.assertNotEquals("sfaasf", ClassWork.stringSplosion("hello"));

    }
    @Test
    public void testFrontTimes(){
        String expectedResult = "chochocho";
        String incorrectOutput = "null";

        Assert.assertTrue(expectedResult.equals(ClassWork.frontTimes("chocolate", 3)));
        Assert.assertFalse(incorrectOutput.equals(ClassWork.frontTimes("chocolate", 3)));


    }
    @Test
    public void testHelloNames(){
        Assert.assertTrue(("Hello Rifat").equals(ClassWork.helloName("Rifat")));


    }
    @Test
    public void testFirstHalf() {
        Assert.assertEquals("afs", ClassWork.firstHalf("afsbds"));
    }

    @Test
    public void testCommonEnd(){
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {4,5,2,4,5,6};

        Assert.assertTrue(ClassWork.commonEnd(arr1,arr2));
    }
    @Test
    public void testStart1(){
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {4,5,2,4,5,6};
        Assert.assertEquals(1,ClassWork.start1(arr,arr2));
        Assert.assertNotEquals(2,ClassWork.start1(arr,arr2));

    }
    @Test
    public void testReverseString(){
        String str = "Palindrome";
        String str2 ="civic";
        Assert.assertTrue(str2.equals(StackExample.reverseString(str2)));
        Assert.assertFalse(str.equals(StackExample.reverseString("Palindrome")));

    }

    @DataProvider(name = "myData")
    public  Object[][] dataProvider(){
        return new Object[][]{
                {1,2,3},
                {10,2,12},
                {15,5,20}
        };
    }
    @Test(dataProvider= "myData")
    public void testSum(int a , int b, int c){
        Assert.assertEquals(ClassWork.Addition(a,b),c);
    }



}
