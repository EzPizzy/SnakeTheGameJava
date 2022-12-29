import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupStats extends  TopPlayers{
    public static void GroupAVGScore(){
        try {

            QueryStat2=" SELECT \"GameUsers\".\"Group\" as GRUPA, AVG(Score) AS WYNIK FROM \"GameUsers\"\n" +
                    "LEFT JOIN \"Games\" ON \"GameUsers\".\"User_id\"=\"Games\".\"Id_user\"\n" +
                    "GROUP BY \"Group\"\n" +
                    "ORDER BY 2 DESC";
             result = QueryExecutor.executeSelect(QueryStat2);
            for (int i=0;i<5;i++){
                result.next();
                System.out.println(i+"- GRUPA: "+result.getString("GRUPA")+"- wynik: "+result.getInt("WYNIK"));
            }

            throw new SQLException("I am Exception alfa!");
        }
        catch (SQLException e)
        {
            e.getStackTrace();
        }

    }
}
