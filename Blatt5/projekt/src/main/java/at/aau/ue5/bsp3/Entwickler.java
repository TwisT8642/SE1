package at.aau.ue5.bsp3;

public class Entwickler extends Person {
    private String bevorzugteProgrammierSprache;
    private Ide ide;
    private boolean datenbanken;

    public Entwickler(String vorname, String nachname, Integer alter, String bevorzugteProgrammierSprache, Ide ide, boolean datenbanken) {
        super(vorname, nachname, alter);
        this.bevorzugteProgrammierSprache = bevorzugteProgrammierSprache;
        this.ide = ide;
        this.datenbanken = datenbanken;
    }

    public String getBevorzugteProgrammierSprache() {
        return bevorzugteProgrammierSprache;
    }

    public Ide getIde() {
        return ide;
    }

    public boolean isDatenbanken() {
        return datenbanken;
    }

    @Override
    public String getJobBeschreibung() {
        return "Entwickelt Code.";
    }
}
