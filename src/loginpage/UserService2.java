package loginpage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService2 {

    List<String> usernames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ad-Soyad giriniz: ");
        String name = input.nextLine();

        String username;
        boolean existsUsername;
        do {
            System.out.print("Kullanıcı Adı giriniz: ");
            username = input.nextLine();

            existsUsername = this.usernames.contains(username);

            if (existsUsername) {
                System.out.println("Bu kullanıcı adı alınamaz. Yeniden giriniz.");
            }
        } while (existsUsername);

        String email;
        boolean existsEmail;
        do {
            System.out.print("Email giriniz: ");
            email = input.nextLine();

            existsEmail = this.emails.contains(email);

            if (existsEmail) {
                System.out.println("Bu email kullanılmış. Yeni bir email giriniz.");
            }

        } while (existsEmail);

    }

    public boolean validateEmail(String email) {
        boolean isValid;

        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");

        if (space) {
            System.out.println("email boşluk içeremez");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("Email @ sembolü içermeli");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean checkStart = firstPart.replaceAll("[a-zA-Z0-9._-]", "").length() == 0;  // isEmpty() kullanılabilir
            boolean checkEnd = secondPart.equals("gmail.com") || secondPart.equals("hotmail.com") || secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("Email harf rakam ve -._  sembolleri dışında karakterleri içermemelidir!..");
            } else if (!checkEnd) {
                System.out.println("Email gmail,hotmail ya da yahoo olamlıdır.");
            }

            isValid = checkEnd && checkStart;
        }

        if (!isValid){
            System.out.println("Geçersiz Email! Tekrar deneyiniz.");
        }

        return isValid;
    }

    public boolean validatePassword(String password){
        boolean isValid;
        String upperLetter = password.replaceAll("[^A-Z]","");
        String lowerLetter = password.replaceAll("[^a-z]","");
        String digit = password.replaceAll("\\D","");
        String symbol = password.replaceAll("\\P{Punct}","");

        boolean space = password.contains(" ");
        boolean lengthGt6= password.length()>=6;

        boolean existUpper = upperLetter.length()>0;
        boolean existLower = lowerLetter.length()>0;
        boolean existDigit = digit.length()>0;
        boolean existSymbol= symbol.length()>0;

        isValid = !space && lengthGt6 && existUpper && existLower && existDigit && existSymbol;

        return isValid;
    }

}
