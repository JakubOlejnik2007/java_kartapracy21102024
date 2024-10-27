import java.io.Serializable;

/**
 * Klasa reprezentująca pracownika.
 * Implementuje interfejs {@link Serializable}, co umożliwia serializację obiektów tej klasy.
 */
public class Pracownik implements Serializable {
    /**
     * Numer seryjny wersji klasy do celów serializacji.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Imię pracownika.
     */
    private final String imie;

    /**
     * Nazwisko pracownika.
     */
    private final String nazwisko;

    /**
     * Płaca pracownika.
     */
    private final double placa;

    /**
     * Płeć pracownika.
     */
    private final char plec;

    /**
     * Identyfikator działu, w którym pracownik pracuje.
     */
    private final int dzial;

    /**
     * Konstruktor klasy {@code Pracownik}.
     *
     * @param imie Imię pracownika.
     * @param nazwisko Nazwisko pracownika.
     * @param placa Płaca pracownika.
     * @param plec Płeć pracownika (np. 'M' dla mężczyzny lub 'K' dla kobiety).
     * @param dzial Identyfikator działu, w którym pracownik pracuje.
     */
    public Pracownik(String imie, String nazwisko, double placa, char plec, int dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    /**
     * Zwraca tekstową reprezentację obiektu {@code Pracownik}.
     * Format wyjścia to: "imię nazwisko płaca płeć dział"
     *
     * @return Tekstowa reprezentacja pracownika.
     */
    @Override
    public String toString() {
        return this.imie + "\t" + this.nazwisko + "\t" + this.placa + "\t" + this.plec + "\t" + this.dzial;
    }

    /**
     * Sprawdza, czy pracownik pracuje w określonym dziale.
     *
     * @param dzial Identyfikator działu do sprawdzenia.
     * @return {@code true} jeśli pracownik pracuje w podanym dziale; {@code false} w przeciwnym wypadku.
     */
    public boolean czyPracujeWDziale(int dzial) {
        return this.dzial == dzial;
    }

    /**
     * Zwraca płacę pracownika.
     *
     * @return Płaca pracownika.
     */
    public double getPlaca() {
        return placa;
    }

    /**
     * Zwraca identyfikator działu, w którym pracownik pracuje.
     *
     * @return Identyfikator działu pracownika.
     */
    public int getDzial() {
        return dzial;
    }
}