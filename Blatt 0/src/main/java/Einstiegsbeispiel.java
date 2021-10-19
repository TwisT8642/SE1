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

    public void getInnerProduct () {
        int fill = a.length-1;
        int skpro = 0;
            while (fill >= 0){
            skpro = skpro + a[fill] * b[fill];
            fill = fill - 1;
        }
        System.out.println(skpro);
    }
}
