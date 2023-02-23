package AppointmentApp;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {

    Scanner input = new Scanner(System.in);

    List<Appointment> appointments = new ArrayList<>();

    List<LocalDate> dates = new ArrayList<>();

    // uygulama başladığında ertesi günden itibaren 7 günlük takvim olsun
    public AppointmentService() {

        LocalDate day = LocalDate.now();

        for (int i = 0; i < 7; i++) {
            day = day.plusDays(1);
            if (day.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                continue;
            }
            dates.add(day);
        }

    }

    public void getAppointment() {
        if (this.dates.isEmpty()) {
            System.out.println("Bu Hafta tüm randevular dolmuştur!");
        } else {
            System.out.println("İsminizi giriniz: ");
            String name = input.nextLine();
            System.out.println("Sayın " + name + ", randevu alabileceğiniz tarihler: ");
            for (int i = 0; i < this.dates.size(); i++) {
                System.out.println(i + 1 + " - " + this.dates.get(i));
            }
            System.out.println("Randevu almak istedğiniz tarihin numarasını giriniz: ");
            int numberOfDate = input.nextInt();
            input.nextLine();

            if (numberOfDate > 0 && numberOfDate <= this.dates.size()) {
                Appointment appointment = new Appointment(name, this.dates.get(numberOfDate - 1));
                this.appointments.add(appointment);
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("Sayın " + name + ", randevu tarihiniz: " + appointment.getDate());
                System.out.println("Randevu no : " + appointment.getId() + " ile randevunuzu görüntüleyebilirsiniz.");
                System.out.println("----------------------------------------------------------------------------");
                this.dates.remove(numberOfDate - 1);
            } else {
                System.out.println("Hatalı giriş!");
            }

        }

    }

    public void printAppointment() {
        System.out.println("Randevu no giriniz");
        boolean isExists = true;
        int appNo = input.nextInt();
        input.nextLine();
        for (Appointment app : this.appointments) {
            if (app.getId() == appNo) {
                System.out.println("----------------------------------------");
                System.out.println(appNo + " nolu Randevu Bilgileri:");
                System.out.println("İsim : " + app.getName());
                System.out.println("Randevu Tarihi : " + app.getDate());
                System.out.println("----------------------------------------");
                isExists = true;
                break;
            } else {
                isExists = false;
            }
        }
        if (!isExists) {
            System.out.println("Randevu bulunamadı!..");
        }
    }

    public void cancelAppointment() {
        System.out.println("Randevu no giriniz");
        boolean isExists = true;
        int appNo = input.nextInt();
        input.nextLine();
        for (Appointment app : this.appointments) {
            if (app.getId() == appNo) {
                this.dates.add(app.getDate());
                this.appointments.remove(app);
                System.out.println(app.getDate() + " tarihli randevunuz iptal edildi.");
                isExists = true;
                break;
            } else {
                isExists = false;
            }
        }
        if (!isExists) {
            System.out.println("Randevu bulunamadı!..");
        }

    }

}
