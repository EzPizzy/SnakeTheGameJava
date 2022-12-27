import java.util.Scanner;
public class FirstMenu {

    public static void MenuChoose(){
        int chose;
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
