import static org.junit.Assert.*; // Importujemy klasę Assert z pakietu org.junit
import org.junit.Test; // Importujemy klasę Test z pakietu org.junit

public class RegisterTest { // Tworzymy nową klasę testową o nazwie RegisterTest

    @Test // Oznaczamy metodę testRegisterUserSuccess() jako test jednostkowy
    public void testRegisterUserSuccess() {
        // Arrange - przygotowanie do testu
        String name = "John"; // Tworzymy nazwę użytkownika
        String password = "password123"; // Tworzymy hasło użytkownika, które jest różne od nazwy użytkownika
        Register register = new Register(); // Tworzymy nowy obiekt klasy Register

        // Act - wywołanie metody, którą chcemy przetestować
        User user = register.RegisterUser(); // Wywołujemy metodę RegisterUser() i przypisujemy zwracany obiekt User do zmiennej user

        // Assert - sprawdzenie czy wynik działania jest zgodny z oczekiwaniami
        assertEquals(name, user.getName()); // Sprawdzamy czy nazwa użytkownika jest taka sama jak zadeklarowana w zmiennej name
        assertEquals(password, user.getPassword()); // Sprawdzamy czy hasło użytkownika jest takie samo jak zadeklarowane w zmiennej password
    }

    @Test // Oznaczamy metodę testRegisterUserFailure() jako test jednostkowy
    public void testRegisterUserFailure() {
        // Arrange - przygotowanie do testu
        String name = "John"; // Tworzymy nazwę użytkownika
        String password = "John"; // Tworzymy hasło użytkownika, które jest takie samo jak nazwa użytkownika
        Register register = new Register(); // Tworzymy nowy obiekt klasy Register
        register.nameU=name;
        register.passwordU=password;
        // Act - wywołanie metody, którą chcemy przetestować
        User user = register.RegisterUser(); // Wywołujemy metodę RegisterUser() i przypisujemy zwracany obiekt User do zmiennej user

        // Assert - sprawdzenie czy wynik działania jest zgodny z oczekiwaniami
        assertNull(user); // Sprawdzamy czy zwracany obiekt User jest null, ponieważ podana nazwa użytkownika i hasło są takie same
    }
}