import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Register extends Login{

    public static User RegisterUser() {

        int row = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę użytkownika");
        nameU = scan.nextLine();
        System.out.println("Podaj hasło użytkownika");
        passwordU = scan.nextLine();
        if (passwordU != nameU) {
            System.out.println("Twoj nickname: " + nameU + " twoje hasło: " + passwordU);

            try {

                ResultSet result = QueryExecutor.executeSelect("SELECT COUNT(*) AS COUNT FROM \"GameUsers\" ");
                while (result.next()) {
                    row = result.getInt("COUNT") + 100;

                }

                QueryExecutor.executeQuery("INSERT INTO \"GameUsers\"( \"User_id\", \"User_name\", \"User_password\")  Values(" + row + ", '" + nameU + "','" + passwordU + "')");
                return new User(row, nameU, passwordU);

                //String username= result.getString("User_name");


            } catch (SQLException e) {
                e.getStackTrace();
            }

            User u1=new User(row,nameU, passwordU);
            return null;
        }
        else{ return null;}
    }

    }

