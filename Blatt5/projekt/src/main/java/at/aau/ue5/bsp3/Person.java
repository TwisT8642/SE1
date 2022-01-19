package at.aau.ue5.bsp3;

public class Person {
    public String vorname,nachname;
    public Integer alter;
    public String beruf;
    public String bevorzugteProgrammierSprache;
    public String ide;
    public boolean datenbanken;
    public String feld;
    public String bevorzugtesTestFramework;

    public String getJobBeschreibung() {
        switch(beruf) {
            case "Entwickler": return "Entwickelt Code.";
            case "Architekt": return "Designed die Architektur des Projekts.";
            case "Tester": return "Testet Code.";
            default: return "";
        }
    }
}
