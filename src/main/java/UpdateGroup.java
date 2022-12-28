import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateGroup extends ForQueries {


    public static void UpdatingGroups(int j){
        try {
            Scanner stringScanner = new Scanner(System.in);
            System.out.println("Wprowadź nazwę grupy");
            String GroupName = stringScanner.next();


             resultCHECK = QueryExecutor.executeQuery(" UPDATE \"GameUsers\" " +
                    "SET \"Group\"='"+GroupName+"'" +
                    "WHERE \"User_id\"="+j);

            System.out.println("GRUPA ZOSTAŁA ZAKTUALIZOWANA");

            throw new SQLException("I am Exception alfa!");
        }
        catch (SQLException e)
        {
            e.getStackTrace();
        }

    }


}
