import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Klasa reprezentująca zasoby kadrowe firmy.
 * Umożliwia dodawanie pracowników, obliczanie średnich zarobków,
 * zapisywanie i odczytywanie danych z plików binarnych oraz import danych z plików tekstowych.
 */
public class Kadry {
    private final Pracownik[] pracownicy_;
    private int zatrudnienie_;

    /**
     * Konstruktor domyślny klasy Kadry.
     * Tworzy tablicę na maksymalnie 100 pracowników.
     */
    public Kadry() {
        this.pracownicy_ = new Pracownik[100];
        this.zatrudnienie_ = 0;
    }

    /**
     * Dodaje nowego pracownika do tablicy.
     *
     * @param pracownik Obiekt klasy {@code Pracownik} do dodania.
     */
    void dodajPracownika(Pracownik pracownik) {
        if (this.zatrudnienie_ < 100) {
            this.pracownicy_[this.zatrudnienie_++] = pracownik;
            return;
        }
        System.out.println("Nie można dodać pracownika");
    }

    /**
     * Dodaje nowego pracownika na podstawie danych wprowadzonych interaktywnie z konsoli.
     */
    void dodajPracownikaInteraktywnie() {
        System.out.println("Podaj dane nowego pracownika:\t");
        if (this.zatrudnienie_ < 100) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Wprowadź imię:\t");
            String imie = sc.nextLine();

            System.out.print("Wprowadź nazwisko:\t");
            String nazwisko = sc.nextLine();

            System.out.print("Wprowadź placę:\t");
            double placa = sc.nextDouble();

            System.out.print("Wprowadź plec:\t");
            char plec = sc.next().charAt(0);

            System.out.print("Wprowadź dzial:\t");
            int dzial = sc.nextInt();

            this.dodajPracownika(new Pracownik(imie, nazwisko, placa, plec, dzial));
            return;
        }
        System.out.println("Nie można dodać pracownika");
    }

    /**
     * Oblicza średnią płacę wszystkich pracowników.
     *
     * @return Średnia płaca pracowników.
     */
    double sredniZarobek() {
        double suma = 0;
        for (int i = 0; i < this.zatrudnienie_; i++) suma += this.pracownicy_[i].getPlaca();

        return suma / this.zatrudnienie_;
    }

    /**
     * Oblicza średnią płacę w wybranym dziale.
     *
     * @param dzial Identyfikator działu.
     * @return Średnia płaca w dziale.
     */
    double sredniZarobek(int dzial) {
        double suma = 0;
        int count = 0;
        for (int i = 0; i < this.zatrudnienie_; i++) {
            if (!this.pracownicy_[i].czyPracujeWDziale(dzial)) continue;
            suma += this.pracownicy_[i].getPlaca();
            count++;
        }

        return suma / count;
    }

    /**
     * Zapisuje dane wszystkich pracowników do domyślnego pliku binarnego "pracownicy.bin".
     */
    void zapiszDoPliku() {
        zapiszDoPliku("pracownicy.bin");
    }

    /**
     * Zapisuje dane wszystkich pracowników do pliku binarnego o podanej nazwie.
     *
     * @param fileName Nazwa pliku do zapisu.
     */
    public void zapiszDoPliku(String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (int i = 0; i < zatrudnienie_; i++) {
                out.writeObject(this.pracownicy_[i]);
            }
            System.out.println("Obiekt zapisany do pliku " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Odczytuje dane pracowników z domyślnego pliku binarnego "pracownicy.bin".
     */
    public void odczytajZPliku() {
        odczytajZPliku("pracownicy.bin");
    }

    /**
     * Odczytuje dane pracowników z pliku binarnego o podanej nazwie.
     *
     * @param fileName Nazwa pliku do odczytu.
     */
    public void odczytajZPliku(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            int count = 0;
            while (true) {
                try {
                    Pracownik obiekt = (Pracownik) in.readObject();
                    count++;
                    this.dodajPracownika(obiekt);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Wczytano poprawnie dane " + count + " pracowników z pliku:\t" + fileName);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zwraca unikalny zbiór identyfikatorów działów, w których pracują pracownicy.
     *
     * @return Tablica z identyfikatorami działów.
     */
    public int[] dajDzialy() {
        Set<Integer> dzialy = new HashSet<>();

        for (int i = 0; i < zatrudnienie_; i++) {
            dzialy.add(this.pracownicy_[i].getDzial());
        }
        return dzialy.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Importuje dane pracowników z domyślnego pliku tekstowego "pracownicy.txt".
     * Dane są oddzielone spacjami, a każdy pracownik znajduje się w osobnej linii.
     */
    void importujZPlikuTekstowego() {
        importujZPlikuTekstowego("pracownicy.txt");
    }

    /**
     * Importuje dane pracowników z pliku tekstowego o podanej nazwie.
     * Dane są oddzielone spacjami, a każdy pracownik znajduje się w osobnej linii.
     *
     * @param fileName Nazwa pliku do importu.
     */
    void importujZPlikuTekstowego(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linia;
            int count = 0;
            while ((linia = br.readLine()) != null) {
                count++;
                String[] dane = linia.split(" ");
                String imie = dane[0];
                String nazwisko = dane[1];
                double placa = Double.parseDouble(dane[2]);
                char plec = dane[3].charAt(0);
                int dzial = Integer.parseInt(dane[4]);

                Pracownik pracownik = new Pracownik(imie, nazwisko, placa, plec, dzial);
                this.dodajPracownika(pracownik);
            }
            System.out.println("Wczytano poprawnie dane " + count + " pracowników z pliku:\t" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wyświetla listę wszystkich pracowników wraz ze średnimi zarobkami.
     */
    void pisz() {
        System.out.println("Liczba pracowników: \t" + this.zatrudnienie_);
        for (int i = 0; i < zatrudnienie_; i++) {
            System.out.println(this.pracownicy_[i]);
        }

        System.out.println("Średnie zarobki w firmie:\t" + this.sredniZarobek());

        for (int dzial : this.dajDzialy()) {
            System.out.println("Średnie zarobki w dziale " + dzial + ":\t" + this.sredniZarobek(dzial));
        }
    }
}