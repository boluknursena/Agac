package dortluagac.quadtree;

class Dugum {

    int x, y;
    Dugum dogu, batı, kuzey, guney;
    String bilgi;

    Dugum(String bilgi, int x, int y) {
        this.bilgi = bilgi;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Bilgi: " + bilgi + " x: " + x + " y: " + y;
    }
}

public class DortluAgacQuadtree {

    Dugum kok;

    public void dugumEkle(String bilgi, int x, int y) {
        Dugum yeniDugum = new Dugum(bilgi, x, y);
        if (kok == null) {
            kok = yeniDugum;
        } else {
            Dugum odaklananDugum = kok;

        }
    }

    public static void main(String[] args) {

    }

}
