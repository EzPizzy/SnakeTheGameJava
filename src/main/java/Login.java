import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Login {
static String nameU;
   static String passwordU;

    public static void LogInUser(){


        int correct=0;
        int userID=0;
        AfterLoginID a1= new AfterLoginID();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę użytkownika");
        nameU = scan.nextLine();
        System.out.println("Podaj hasło użytkownika");
        passwordU = scan.nextLine();

        try{




            ResultSet result= QueryExecutor.executeSelect("SELECT COUNT(*) AS COUNT FROM \"GameUsers\" WHERE \"User_name\"='"+nameU+"' AND \"User_password\"='"+passwordU+"'  ");



            while(result.next()) {
                correct=result.getInt("COUNT");
               // userID=result.getInt("User_id");


            }

            if (correct==1){
                try {
                    ResultSet result2= QueryExecutor.executeSelect("SELECT \"User_id\"  AS USERID FROM \"GameUsers\" WHERE \"User_name\"='"+nameU+"' AND \"User_password\"='"+passwordU+"'  ");
                    while(result2.next()) {
                        userID=result2.getInt("USERID");
                        // userID=result.getInt("User_id");


                    }
                    a1.setUserID(userID);

                    throw new SQLException("I am Exception beta!");
                }
                catch (SQLException e) {
                    e.getStackTrace();
                }




                System.out.println(a1.getUserID());
                new SecondMenu();
                SecondMenu.MenuChoose(a1);

            }
            else System.out.println("Niestety w naszej bazie nie ma uzytkownika o takich danych dostepowych");



            throw new SQLException("I am Exception Alpha!");
        }
        catch (SQLException e) {
            e.getStackTrace();
        }




    }

}
