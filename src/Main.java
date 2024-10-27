//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Pracownik pracownik1 = new Pracownik("Adam", "Nowak", 4000, 'M', 1);
//        Pracownik pracownik2 = new Pracownik("Adam", "Nowak", 1000, 'M', 2);
//        Pracownik pracownik3 = new Pracownik("Adam", "Nowak", 5000, 'M', 1);

        Kadry kadra = new Kadry();

        kadra.importujZPlikuTekstowego();

//        kadra.dodajPracownika(pracownik1);
//        kadra.dodajPracownika(pracownik2);
//        kadra.dodajPracownika(pracownik3);

//        kadra.dodajPracownikaInteraktywnie();

        kadra.pisz();

    }
}