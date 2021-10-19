public class Einstiegsbeispiel {

    public int [] a;
    public int [] b;

    public Einstiegsbeispiel(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

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
        int c = a.length-1;
        int skpro = 0;
        if (c > 0) {
            skpro += a[c] * b[c];
            c--;
        }
        System.out.println(skpro);
        return skpro;
    }

}
