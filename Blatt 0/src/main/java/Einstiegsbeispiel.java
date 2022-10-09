//Andreas Marius Baisan 12008073
public class Einstiegsbeispiel {

    public int [] a;
    public int [] b;

    public Einstiegsbeispiel(int[] a, int[] b) {
        if(a.length != b.length) {
            throw new IllegalArgumentException("Arraylängen nicht gleich lang");
        }
        if(a.length == 0) { // da a und b immer gleich lang sein müssen, aufgrund der vorherigen Überprüfung, muss nur a überprüft werden.
            throw new IllegalArgumentException("Arraylänge darf nicht 0 betragen");
        }
        this.a = a;
        this.b = b;
    }

//hallo
    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }

    public int getInnerProduct () {
        int fill = a.length-1;
        int skpro = 0;
            while (fill >= 0){
            skpro = skpro + (a[fill] * b[fill]);
            fill = fill - 1;
        }
            return skpro;
    }
}
