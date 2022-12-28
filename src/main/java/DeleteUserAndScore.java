import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUserAndScore extends SecondMenu{

    public static void DeleteAll(int j){

        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Czy na pewno chcesz usnac swoje konto? 1-Tak usuń 2-Nie, wyjdź z gry");
        chose= stringScanner.nextInt();
        if (chose==1){
            try {



                 resultDEL1 = QueryExecutor.executeQuery(" DELETE FROM \"GameUsers\" " +
                        "WHERE \"User_id\"="+j);
                 resultDEL2 = QueryExecutor.executeQuery(" DELETE FROM \"Games\" " +
                        "WHERE \"Id_user\"="+j);

                System.out.println("Twoje konto o raz wyniki zostały usunięte z gry");

                throw new SQLException("I am Exception alfa!");
            }
            catch (SQLException e)
            {
                e.getStackTrace();
            }


        }
        if (chose==2){
            System.out.println("Do zobaczenia!");
        }
        else System.out.println("Bywaj!");



    }

}
