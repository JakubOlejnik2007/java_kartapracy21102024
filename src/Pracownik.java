public class Pracownik {
    private String imie;
    private String nazwisko;
    private double placa;
    private char plec;
    private int dzial;

    public Pracownik(String imie, String nazwisko, double placa, char plec, int dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    @Override
    public String toString() {
        return this.imie+" "+this.nazwisko+" "+this.placa+" "+this.plec+" "+this.dzial;
    }

    public boolean czyPracujeWDziale(int dzial) {
        return this.dzial == dzial;
    }
}