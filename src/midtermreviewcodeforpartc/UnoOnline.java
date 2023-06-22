package midtermreviewcodeforpartc;

import java.util.Scanner;

public class UnoOnline {
    private User users[] = new User[100]; // room for 100 online players!

    public static void main(String[] args) {
        UnoOnline newPortal = new UnoOnline();
        newPortal.run();
    }

    private void run() {
        int userCount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your desired user name:");
        String userName = sc.nextLine();
        boolean validPassword = false;
        String password = "";

        while (!validPassword) {
            System.out.println("Passwords must have at least 8 characters");
            System.out.println("Passwords must have at least one special character");
            System.out.println("Please enter your desired password:");

            password = sc.nextLine();

            if (validatePassword(password)) {
                validPassword = true;
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        }

        User newUser = new User(userName, password);
        users[userCount] = newUser;
        userCount++;
        System.out.println("New User Added");
        System.out.println("UserName: " + userName);
        System.out.println("Password: just kidding can't show password");
    }

    private boolean validatePassword(String password) {
        if (password.length() < 10) {
            return true;
        }

        boolean hasSpecialChar = false;
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
                break;
            }
        }

        return hasSpecialChar;
    }
}
