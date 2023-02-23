package loginpage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<User> userList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private User getUser(String usernameOrEmail) {
        for (User user : userList) {
            if (user.getUsername().equals(usernameOrEmail)) {
                return user;
            } else if (user.getEmail().equals(usernameOrEmail)) {
                return user;
            }
        }
        return null;
    }

    private static boolean validateEmail(String email) {
        boolean isValid;

        boolean isExistsSpace = email.contains(" ");
        boolean isContainsAt = email.contains("@");

        if (isExistsSpace) {
            System.out.println("Email boşluk içeremez!..");
            isValid = false;
        } else if (!isContainsAt) {
            System.out.println("Email @ sembolü içermelidir.");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];
            boolean valid = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").isEmpty();
            boolean checkStart = valid && firstPart.length() > 0;
            boolean checkLast = secondPart.equals("gmail.com") ||
                    secondPart.equals("yahoo.com") || secondPart.equals("hotmail.com");

            if (!checkStart) {
                System.out.println("Email harf sayı ve -._ semböllerini içerebilir!..");
            }
            if (!checkLast) {
                System.out.println("email gmail,hotmail ya da yahoo ile bitmelidir.");
            }
            isValid = checkStart && checkLast;
        }
        if (!isValid) {
            System.out.println("Tekrar deneyiniz.");
        }

        return isValid;
    }

    private static boolean validatePassword(String password) {
        boolean isValid;

        boolean isExistSpace = password.contains(" ");
        boolean isLengthGThanSix = password.length() >= 6;
        boolean isExistUpperLetter = password.replaceAll("[^A-Z]", "").length() > 0;
        boolean isExistLowerLetter = password.replaceAll("[^a-z]", "").length() > 0;
        boolean isExistDigit = password.replaceAll("\\D", "").length() > 0;
        boolean isExistSymbol = password.replaceAll("\\P{Punct}", "").length() > 0;
        if (isExistSpace) {
            System.out.println("Şifre boşluk içeremez!");
        } else if (!isLengthGThanSix) {
            System.out.println("Şifre en az 6 karakterli olmalıdır!");
        } else if (!isExistUpperLetter) {
            System.out.println("En az bir büyük harf içermeli!");
        } else if (!isExistLowerLetter) {
            System.out.println("En az bir küçük harf içermeli!");
        } else if (!isExistDigit) {
            System.out.println("En az bir rakam içermeli!");
        } else if (!isExistSymbol) {
            System.out.println("En az bir sembol içermeli!");
        }

        isValid = !isExistSpace && isLengthGThanSix && isExistUpperLetter &&
                isExistLowerLetter && isExistDigit && isExistSymbol;
        if (!isValid) {
            System.out.println("Geçersiz şifre, Tekrar deneyiniz.");
        }

        return isValid;
    }

    public void register() {
        System.out.println("Ad - Soyad: ");
        String name = input.next();

        String username = getUsername();

        String email = getEmail();
        String password = getPassword();

        User user = new User(name,username,email,password);
        this.userList.add(user);
        System.out.println("Tebrikler İşleminiz Başarıyla gerçekleştirildi.");
        System.out.println("Sisteme kullanıcı adı ya da email ve şifrenizle giriş yapabilirsiniz.");

    }

    private String getUsername() {
        String username;
        boolean existsUsername;
        do {
            System.out.println("Kullanıcı Adı giriniz: ");
            username = input.next();
            existsUsername = getUser(username) != null;
            if (existsUsername) {
                System.out.println("Bu username kullanılamaz!");
            }

        } while (existsUsername);

        return username;
    }

    private String getEmail() {
        String email;
        boolean existEmail;
        boolean isValid;
        do {
            System.out.println("Email giriniz: ");
            email = input.next();
            isValid = validateEmail(email);
            existEmail = getUser(email) != null;
            if (existEmail) {
                System.out.println("Bu email kullanılamaz!");
                isValid = false;
            }

        } while (!isValid);

        return email;
    }

    private String getPassword() {
        String password;
        boolean isValid;
        do {
            System.out.println("Password giriniz: ");
            password = input.next();
            isValid = validatePassword(password);

        }while(!isValid);

        return password;

    }

    public void login(){

        System.out.println("Kullanıcı adı ya da email giriniz:");
        String usernameOrEmail = input.next();
        if (getUser(usernameOrEmail)!=null) {
            User user = getUser(usernameOrEmail);
            boolean isWrong=true;
            while (isWrong){
                System.out.println("Şifrenizi giriniz: ");
                String password = input.next();
                if (user.getPassword().equals(password)){
                    System.out.println("Sisteme giriş yaptınız.");
                    isWrong = false;
                }else {
                    System.out.println("Şifreniz yanlış, tekrar deneyiniz.");
                }
            }
        }else{
            System.out.println("Sistemde kayıtlı kullanıcı adı veya email bulunamadı.");
            System.out.println("Bilgilerinizi kotrol edip yeniden giriniz.");
            System.out.println("Eğer üye değilseniz üye olunuz");
        }

    }

}
