package bonusTasks;

/**
 * Klass som beskriver vattenflaskor.
 *
 * @version 1.0 2018-01-27
 * @author Oscar Brink
 */
public class Vattenflaska {

    private String ägare;
    /* kapacitet och innehåll ges i milliliter (ml). */
    private int kapacitet;
    private int innehåll;

    public static void main(String[] args) {
        Vattenflaska håkansFlaska = new Vattenflaska("Håkan", 1000);
        Vattenflaska oscarsFlaska = new Vattenflaska("Oscar", 800);
        System.out.println(
                oscarsFlaska.toString() + "\n" + håkansFlaska.toString() + "\n"
        );

        oscarsFlaska.fyllPå(1200);
        håkansFlaska.fyllPå(600);
        System.out.println(
                oscarsFlaska.toString() + "\n" + håkansFlaska.toString() + "\n"
        );

        oscarsFlaska.tömUt(400);
        håkansFlaska.fyllPå(600);
        System.out.println(
                oscarsFlaska.toString() + "\n" + håkansFlaska.toString() + "\n"
        );

        oscarsFlaska.tömUt(800);
        håkansFlaska.tömUt(2000);
        System.out.println(
                oscarsFlaska.toString() + "\n" + håkansFlaska.toString() + "\n"
        );
    }

    public Vattenflaska(String ägare, int kapacitet) {
        this.ägare = ägare;
        this.kapacitet = kapacitet;
        this.innehåll = 0; // Flaskan börjar som tom, därav innehållet 0 ml.
    }

    public int kapacitet() {
        return kapacitet;
    }

    public int innehåll() {
        return innehåll;
    }

    public void fyllPå(int mängd) {
        innehåll += mängd;
        /* Om flaskan blir överfylld av påfyllningen så tolkas det som att
         * flaskan fylls till maxkapacitet.
         */
        if (innehåll > kapacitet) {
            innehåll = kapacitet;
        }
    }

    public void tömUt(int mängd) {
        innehåll -= mängd;
        /* Om metoden tömt flaskan på mer än vad som var i den så sätts
         * innehållet till 0.
         */
        if (innehåll < 0) {
            innehåll = 0;
        }
    }

    public String toString() {
        return ägare + "s flaska kan innehålla max " + kapacitet()
                + " ml och innehåller nu " + innehåll() + " ml.";
    }
}
