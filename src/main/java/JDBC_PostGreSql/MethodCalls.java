package JDBC_PostGreSql;

import java.sql.SQLException;

public class MethodCalls {
    public static void main(String[] args)  throws SQLException {

        //Create
//        DATA_CALLS.create("Safin","Messi","121-412-4214","smessi@gsu.com");
        //read
           String Student = DATA_CALLS.Read();
           System.out.println(Student);
        //update
//         DATA_CALLS.update("Safin","Messi",7);

        //Delete
//        DATA_CALLS.delete(7);



    }
}
