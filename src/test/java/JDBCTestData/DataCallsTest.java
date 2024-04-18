package JDBCTestData;

import InClassWork.InputOutput;
import JDBC_PostGreSql.DATA_CALLS;
import JDBC_PostGreSql.JDBC_CONNECTION;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;
import java.sql.Connection;

public class DataCallsTest {


    @Test

    public void getDataTest() throws Exception {
        String expectedData = InputOutput.readFile();
        String actualData = DATA_CALLS.Read();


        System.out.println("Expected Data:\n" + expectedData);

        System.out.println("Actual Data:\n" + actualData);
        actualData.length();
        System.out.println("Expected Data size "+ expectedData.length());
        System.out.println("Actual Data size " + actualData.length());



        Assert.assertEquals(actualData.trim(), expectedData.trim(), "Data returned does not match expected data.");
    }
}

