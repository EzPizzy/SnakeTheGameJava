import java.util.Scanner;
public class SecondMenu extends FirstMenu{

//    public static void MenuChoose(){
//        int chose;
//        System.out.println("MENU- podaj liczbe");
//        System.out.println("1. Rozpocznij grę");
//        System.out.println("2. Ranking graczy");
//        System.out.println("3. Ustawienia mojego konta");
//
//        Scanner scan = new Scanner(System.in);
//
//        chose = scan.nextInt();
//        if (chose==1){
//
//            new Game(0);
//        }
//        if (chose==2){
//            TopPlayers tp1=new TopPlayers();
//            tp1.TopGames();
//        }
//        else  System.out.println("W przygotowaniu");
//
//    }

    public static void MenuChoose(AfterLoginID a1){

        System.out.println("MENU- podaj liczbe");
        System.out.println("1. Rozpocznij grę");
        System.out.println("2. Ranking graczy");
        System.out.println("3. Dodaj grupę");
        System.out.println("4. Usuń konto oraz dane o rozgrywkach");
        System.out.println("TWOJE UNIKATOWE ID = "+a1.getUserID());

        Scanner scan = new Scanner(System.in);

        chose = scan.nextInt();
        if (chose==1){


            new Game(a1.UserID);
        }
        if (chose==2){

            TopPlayers tp=new TopPlayers();
            tp.TopGames();
            System.out.println("--------------------------------------------");
            System.out.println("1. Rozpocznij grę");
            System.out.println("2. Statystyki grup");
            System.out.println("Każdy inna liczba- wyjdź z gry");
             chose2 = scan.nextInt();
            if (chose2==1){
                new Game(a1.UserID);
            }
            else System.out.println( "Do zobaczenia");
        }
        if (chose==3){
            UpdateGroup ug= new UpdateGroup();
            ug.UpdatingGroups(a1.UserID);
            System.out.println("--------------------------------------------");
            System.out.println("1. Rozpocznij grę");
            System.out.println("Każdy inna liczba- wyjdź z gry");
             chose2 = scan.nextInt();
            if (chose2==1){
                new Game(a1.UserID);
            }
            else System.out.println( "Do zobaczenia");

        }
        if (chose==4){

            DeleteUserAndScore du=new DeleteUserAndScore();
            du.DeleteAll(a1.UserID);
            System.out.println("--------------------------------------------");

        }
        else  System.out.println("W przygotowaniu");

    }



}
