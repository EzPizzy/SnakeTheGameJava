import java.util.Scanner;
public class FirstMenu extends ForQueries {
static  int chose;
static int chose2;
    public static void MenuChoose(){

        System.out.println("MENU- podaj liczbe");
        System.out.println("1. Zaloguj się");
        System.out.println("2. Zarejestruj się");

        Scanner scan = new Scanner(System.in);

        chose = scan.nextInt();
        if (chose==1){
            Login.LogInUser();
        }
        else Register.RegisterUser();

    }

}
