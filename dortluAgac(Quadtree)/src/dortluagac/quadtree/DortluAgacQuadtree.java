package dortluagac.quadtree;

class Dugum {

    int x, y;
    Dugum gb, gd, kd, kb;

    Dugum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return " x: " + x + " y: " + y;
    }
}

public class DortluAgacQuadtree {

    Dugum kok;

    public void dugumEkle(String bilgi, int x, int y) {
        
        
        Dugum yeniDugum = new Dugum(x,y);
        if (kok == null) {
            kok = yeniDugum;
        } else {
            Dugum odaklananDugum = kok;
            Dugum aile;
            while (true) {
                aile = odaklananDugum;
                if (x < odaklananDugum.x && y < odaklananDugum.y) {
                    odaklananDugum = odaklananDugum.gb;
                    if (odaklananDugum == null) {
                        aile.gb = yeniDugum;
                        return;
                    }
                }
                else if (x >= odaklananDugum.x && y < odaklananDugum.y) {
                    odaklananDugum = odaklananDugum.gd;
                    if (odaklananDugum == null) {
                        aile.gd = yeniDugum;
                        return;
                    }
                }
                else if (x >= odaklananDugum.x && y >= odaklananDugum.y) {
                    odaklananDugum = odaklananDugum.kd;
                    if (odaklananDugum == null) {
                        aile.kd = yeniDugum;
                        return;
                    }
                }else {
                    odaklananDugum = odaklananDugum.kb;
                    if (odaklananDugum == null) {
                        aile.kb = yeniDugum;
                        return;
                    }
                }
            }
        }
        
        
    }

    public static void main(String[] args) {

    }

}
