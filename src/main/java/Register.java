import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Register {

    public static User RegisterUser(){
        String name, password;
        int row=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę użytkownika");
        name = scan.nextLine();
        System.out.println("Podaj hasło użytkownika");
        password = scan.nextLine();
        System.out.println("Twoj nickname: "+name+" twoje hasło: "+password);

         try{

           ResultSet result= QueryExecutor.executeSelect("SELECT COUNT(*) AS COUNT FROM \"GameUsers\" ");
             while(result.next()) {
                 row=result.getInt("COUNT")+1;

             }

             QueryExecutor.executeQuery("INSERT INTO \"GameUsers\"( \"User_id\", \"User_name\", \"User_password\")  Values("+row+", '"+name+"','"+ password +"')");
             return new User(row, name, password);

        //String username= result.getString("User_name");


         }
        catch (SQLException e) {
        e.getStackTrace();
        }


        return null;
    }

    }

