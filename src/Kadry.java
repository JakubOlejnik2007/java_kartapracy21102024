import java.util.Scanner;

public class Kadry {
    private Pracownik[] pracownicy_;
    private int zatrudnienie_;

    public Kadry() {
        this.pracownicy_ = new Pracownik[100];
        this.zatrudnienie_ = 0;
    }

    void dodajPracownika(Pracownik pracownik) {
        if (this.zatrudnienie_ < 100) {
            this.pracownicy_[this.zatrudnienie_++] = pracownik;
            System.out.println("Dodano pracownika");
            return;
        }
        System.out.println("Nie można dodać pracownika");
    }

    void dodajPracownikaInteraktywnie() {
        if (this.zatrudnienie_ < 100) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Wprowadź imię:\t");
            String imie = sc.nextLine();

            System.out.println("Wprowadź nazwisko:\t");
            String nazwisko = sc.nextLine();

            System.out.println("Wprowadź placę:\t");
            double placa = sc.nextDouble();

            System.out.println("Wprowadź plec:\t");
            char plec = sc.next().charAt(0);

            System.out.println("Wprowadź imię:\t");
            int dzial = sc.nextInt();

            this.dodajPracownika(new Pracownik(imie, nazwisko, placa, plec, dzial));

            return;
        }
        System.out.println("Nie można dodać pracownika");
    }
}
