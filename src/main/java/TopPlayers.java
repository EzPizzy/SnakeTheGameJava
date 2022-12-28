import java.sql.ResultSet;
import java.sql.SQLException;

public class TopPlayers {
    public static void TopGames(){
        try {
            ResultSet resultCHECK = QueryExecutor.executeSelect(" SELECT COUNT(*) as COUNT FROM \"Games\" " +
                    "LEFT JOIN \"GameUsers\" ON \"Games\".\"Id_user\"=\"GameUsers\".\"User_id\" ");
            resultCHECK.next();

            ResultSet result = QueryExecutor.executeSelect(" SELECT \"Games\".\"score\" as \"score\", \"GameUsers\".\"User_name\"  as name FROM \"Games\" \n" +
                    "LEFT JOIN \"GameUsers\" ON \"Games\".\"Id_user\"=\"GameUsers\".\"User_id\"\n" +
                    "order by \"score\" desc ");
            for (int i=0;i<resultCHECK.getInt("COUNT");i++){
                result.next();
                System.out.println(i+"- Nazwa gracza: "+result.getString("name")+"- wynik: "+result.getInt("score"));
            }

            throw new SQLException("I am Exception alfa!");
        }
        catch (SQLException e)
        {
            e.getStackTrace();
        }

    }

//    public void TopGames() {
//        try {
//            ResultSet result = QueryExecutor.executeSelect(" SELECT \"Games\".\"score\" as \"score\", \"GameUsers\".\"User_name\"  as name FROM \"Games\" \n" +
//                    "LEFT JOIN \"GameUsers\" ON \"Games\".\"Id_user\"=\"GameUsers\".\"User_id\"\n" +
//                    "order by \"score\" desc LIMIT 5  ");
//            for (int i=1;i<6;i++){
//                result.next();
//                System.out.println(i+"Nazwa gracza: "+result.getString("name")+"- wynik: "+result.getInt("score"));
//            }
//
//            throw new SQLException("I am Exception alfa!");
//        }
//        catch (SQLException e)
//        {
//            e.getStackTrace();
//        }
//
//
//    }
}
