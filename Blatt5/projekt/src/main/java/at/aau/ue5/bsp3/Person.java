package at.aau.ue5.bsp3;

public abstract class Person {
    public String vorname,nachname;
    public Integer alter;

    public Person(String vorname, String nachname, Integer alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Integer getAlter() {
        return alter;
    }

    public abstract String getJobBeschreibung();

}

