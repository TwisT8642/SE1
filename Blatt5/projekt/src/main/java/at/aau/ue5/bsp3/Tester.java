//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp3;

public class Tester extends Person {
    private String bevorzugtesTestFramework;

    public Tester(String vorname, String nachname, Integer alter, String bevorzugtesTestFramework) {
        super(vorname, nachname, alter);
        this.bevorzugtesTestFramework = bevorzugtesTestFramework;
    }

    public String getBevorzugtesTestFramework() {
        return bevorzugtesTestFramework;
    }

    @Override
    public String getJobBeschreibung() {
        return "Testet Code.";
    }
}
