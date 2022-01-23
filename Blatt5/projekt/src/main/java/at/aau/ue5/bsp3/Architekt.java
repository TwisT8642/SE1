package at.aau.ue5.bsp3;

public class Architekt extends Person {
    private Feld feld;

    public Architekt(String vorname, String nachname, Integer alter, Feld feld) {
        super(vorname, nachname, alter);
        this.feld = feld;
    }

    public Feld getFeld() {
        return feld;
    }

    public void setFeld(Feld feld) {
        this.feld = feld;
    }

    @Override
    public String getJobBeschreibung() {
        return "Designed die Architektur des Projekts";
    }
}
