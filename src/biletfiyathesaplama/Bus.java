package biletfiyathesaplama;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    public String numberPlate;

    public List<String> saets = new ArrayList<>();

    public Bus(String numberPlate) {
        this.numberPlate = numberPlate;

        for (int i = 1; i <33 ; i++) {
            this.saets.add(i+""); // String.valueOf()
        }
    }
}
