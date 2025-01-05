import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Adăugarea unei persoane");
            System.out.println("2. Adăugarea unei excursii");
            System.out.println("3. Iesire");
            System.out.print("Alegeți opțiunea: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 1) {
                // Adăugarea unei persoane
                System.out.print("Introduceți numele: ");
                String nume = scanner.nextLine();
                System.out.print("Introduceți vârsta: ");
                int varsta = scanner.nextInt();
                addPerson(nume, varsta);
            } else if (option == 2) {
                // Adăugarea unei excursii
                System.out.print("Introduceți ID-ul persoanei: ");
                int idPersoana = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Introduceți destinația: ");
                String destinatie = scanner.nextLine();
                System.out.print("Introduceți anul excursiei: ");
                int anul = scanner.nextInt();
                addExcursion(idPersoana, destinatie, anul);
            } else if (option == 3) {
                System.out.println("Ieșire...");
                break;
            }
        }

        scanner.close();
    }

    public static void addPerson(String nume, int varsta) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nume);
                stmt.setInt(2, varsta);
                stmt.executeUpdate();
                System.out.println("Persoana adăugată cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addExcursion(int idPersoana, String destinatie, int anul) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idPersoana);
                stmt.setString(2, destinatie);
                stmt.setInt(3, anul);
                stmt.executeUpdate();
                System.out.println("Excursie adăugată cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

