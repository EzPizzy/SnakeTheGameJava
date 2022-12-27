import java.util.Scanner;
public class SecondMenu {

    public static void MenuChoose(){
        int chose;
        System.out.println("MENU- podaj liczbe");
        System.out.println("1. Rozpocznij grę");
        System.out.println("2. Ranking graczy");
        System.out.println("3. Ustawienia mojego konta");

        Scanner scan = new Scanner(System.in);

        chose = scan.nextInt();
        if (chose==1){

            new Game(0);
        }
        if (chose==2){
            System.out.println("W przygotowaniu");
        }
        else  System.out.println("W przygotowaniu");

    }

    public static void MenuChoose(AfterLoginID a1){
        int chose;
        System.out.println("MENU- podaj liczbe");
        System.out.println("1. Rozpocznij grę");
        System.out.println("2. Ranking graczy");
        System.out.println("3. Ustawienia mojego konta");
        System.out.println("TWOJE UNIKATOWE ID = "+a1.getUserID());

        Scanner scan = new Scanner(System.in);

        chose = scan.nextInt();
        if (chose==1){


            new Game(a1.UserID);
        }
        if (chose==2){
            System.out.println("W przygotowaniu");
        }
        else  System.out.println("W przygotowaniu");

    }



}
