import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayisalLoto {

    public static void main(String[] args) {

        lottery();

    }
    public static void lottery() {
        Scanner input = new Scanner(System.in);
        System.out.println("Sayısal Loto içim hane sayısı giriniz: ");
        int slots = input.nextInt();
        System.out.println("Sayılar İçin min değer giriniz: ");
        int min = input.nextInt();
        System.out.println("Sayılar İçin max değer giriniz:");
        int max = input.nextInt();

        // Başlangıçta hepsi 0
        int[] lotoArr = new int[slots];
        int[] ticketArr = new int[slots];

        Random random = new Random();

        int randomNumber1 = 0;
        int randomNumber2 = 0;
        boolean isRepeated;

        for (int i = 0; i < slots; i++) {

            do {
                isRepeated = false;
                randomNumber1=random.nextInt(max-min+1)+min;      // random.nextInt(a) [0,a) aralığında int sayılar uretir.
                for (int j = 0; j < i; j++) {
                    if (lotoArr[j]==randomNumber1){
                        isRepeated = true;
                        break;
                    }
                }
            }while (isRepeated);

            lotoArr[i] = randomNumber1;

            do {
                isRepeated = false;
                randomNumber2=random.nextInt(max-min+1)+min;
                for (int j = 0; j < i; j++) {
                    if (ticketArr[j]==randomNumber2){
                        isRepeated = true;
                        break;
                    }
                }
            }while (isRepeated);

            ticketArr[i]=randomNumber2;
        }

        System.out.print("Bilet : ");

        for (int k : ticketArr) {
            System.out.print(k + " ");
        }
        System.out.println();
        System.out.print("Loto sonucu: ");
        for (int j : lotoArr) {
            System.out.print(j + " ");
        }

        System.out.println();
        int result = compareArr(ticketArr,lotoArr);
        if (result>0){
            System.out.println("Tebrikler! "+result+" eşleşme var.");
        }else {
            System.out.println("Maalesef hiç eşleşme yok, bir daha ki sefere");
        }

    }

    public static int compareArr(int[] arr, int[] brr){
        int counter = 0;
        for (int w : arr) {
            for (int k : brr) {
                if (w == k) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
