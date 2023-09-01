package zadacha_1;

import java.util.Scanner;

public class PasswordVerifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        
        try {
            verify(password);
            System.out.println("Пароль корректный");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void verify(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Пароль должен быть не менее 8 символов");
        }
        
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Пароль должен содержать хотя бы одну цифру");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Пароль должен содержать хотя бы одну заглавную букву");
        }
    }

    static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
}
