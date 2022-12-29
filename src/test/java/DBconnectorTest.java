
import static org.testng.AssertJUnit.assertNotNull;


import org.testng.annotations.Test;

import java.sql.Connection;

public class DBconnectorTest { // Tworzymy nową klasę testową o nazwie DBconnectorTest

    @Test // Oznaczamy metodę testConnect() jako test jednostkowy
    public void testConnect() {
        // Arrange - przygotowanie do testu
        DBconnector connector = new DBconnector(); // Tworzymy nowy obiekt klasy DBconnector

        // Act - wywołanie metody, którą chcemy przetestować
        Connection connection = connector.connect(); // Wywołujemy metodę connect() i przypisujemy zwracany obiekt Connection do zmiennej connection

        // Assert - sprawdzenie czy wynik działania jest zgodny z oczekiwaniami
        assertNotNull(connection); // Sprawdzamy czy obiekt connection nie jest null, co oznacza, że połączenie z bazą danych zostało utworzone pomyślnie
    }
}