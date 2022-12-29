import static org.junit.Assert.*; // Importujemy klasę Assert z pakietu org.junit
import org.junit.Test; // Importujemy klasę Test z pakietu org.junit

import java.sql.ResultSet;

public class QueryExecutorTest { // Tworzymy nową klasę testową o nazwie QueryExecutorTest

    @Test // Oznaczamy metodę testExecuteSelect() jako test jednostkowy
    public void testExecuteSelect() {
        // Arrange - przygotowanie do testu
        String selectQuery = "SELECT * FROM users"; // Tworzymy zapytanie SELECT
        QueryExecutor executor = new QueryExecutor(); // Tworzymy nowy obiekt klasy QueryExecutor

        // Act - wywołanie metody, którą chcemy przetestować
        ResultSet resultSet = executor.executeSelect(selectQuery); // Wywołujemy metodę executeSelect() i przypisujemy zwracany obiekt ResultSet do zmiennej resultSet

        // Assert - sprawdzenie czy wynik działania jest zgodny z oczekiwaniami
        assertNotNull(resultSet); // Sprawdzamy czy obiekt resultSet nie jest null, co oznacza, że zapytanie zostało wykonane pomyślnie
    }

    @Test // Oznaczamy metodę testExecuteQuery() jako test jednostkowy
    public void testExecuteQuery() {
        // Arrange - przygotowanie do testu
        String query = "INSERT INTO users (name, email) VALUES ('John', 'john@example.com')"; // Tworzymy zapytanie INSERT
        QueryExecutor executor = new QueryExecutor(); // Tworzymy nowy obiekt klasy QueryExecutor

        // Act - wywołanie metody, którą chcemy przetestować
        ResultSet resultSet = executor.executeQuery(query); // Wywołujemy metodę executeQuery() i przypisujemy zwracany obiekt ResultSet do zmiennej resultSet

        // Assert - sprawdzenie czy wynik działania jest zgodny z oczekiwaniami
        assertNull(resultSet); // Sprawdzamy czy obiekt resultSet jest null, co oznacza, że zapytanie zostało wykonane pomyślnie
    }
}