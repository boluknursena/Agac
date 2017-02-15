package dortluagac.quadtree;

import java.util.Scanner;

class Dugum {

    int x, y;
    Dugum cocuklar[] = new Dugum[4];
//Gelen koordinatlar. Dizide tutulanlar sırasıyla güneybatı, güneydoğu, kuzeydoğu, kuzeybatı.
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

    public void dugumEkle(int x, int y,int ortaX,int ortaY ) {

        Dugum yeniDugum = new Dugum(x, y);
        if (kok == null) {
            kok = yeniDugum;
        }

        Dugum odaklananDugum = kok;
        Dugum aile;
         int i=0;
        while (true) {
            aile = odaklananDugum;
           
            if (x < odaklananDugum.x && y < odaklananDugum.y) { //günaybatı
                odaklananDugum = odaklananDugum.cocuklar[0];
                
                if (odaklananDugum == null) {
                    aile.cocuklar[0] = yeniDugum;
                    return;
                }
                else if(odaklananDugum != null && odaklananDugum.cocuklar[0] == null ){  //! unnecessary test for null-the expression is never null
                    Dugum araDugum = new Dugum(ortaX, ortaY);
                    Dugum tut=odaklananDugum;
                    aile=araDugum;         //! the assigned value is never used
                    dugumEkle(tut.x, tut.y, ortaX,ortaY);
                    dugumEkle(x,y,ortaX,ortaY);
                    return;
                   
                }
                i=i+2;
                
                
            } 
            
            else if (x >= odaklananDugum.x && y < odaklananDugum.y) { //günaydoğu
                odaklananDugum = odaklananDugum.cocuklar[1];
                if (odaklananDugum == null) {
                    aile.cocuklar[1] = yeniDugum;
                    return;
                }
            } 
            
            
            else if (x >= odaklananDugum.x && y >= odaklananDugum.y) { //kuzeydoğu
                odaklananDugum = odaklananDugum.cocuklar[2];
                if (odaklananDugum == null) {
                    aile.cocuklar[2] = yeniDugum;
                    return;
                }
            } 
            
            
            else {                                                    //kuzeybatı
                odaklananDugum = odaklananDugum.cocuklar[3];
                if (odaklananDugum == null) {
                    aile.cocuklar[3] = yeniDugum;
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int gelenVeriX[] = new int[5];
        int gelenVeriY[] = new int[5];
        for (int i = 0; i < gelenVeriX.length; i++) { //veri girişi
            gelenVeriX[i] = keyboard.nextInt();
            gelenVeriY[i] = keyboard.nextInt();
        }

        int enBuyukX = 0;
        int enKucukX = 0;
        int enBuyukY = 1000;
        int enKucukY = 1000;
        for (int i = 0; i < gelenVeriX.length; i++) {  //en kucuk ve büyük x y bulma
            if (enBuyukX < gelenVeriX[i]) {
                enBuyukX = gelenVeriX[i];
            }
            if (enKucukX > gelenVeriX[i]) {
                enKucukX = gelenVeriX[i];
            }
            if (enBuyukY < gelenVeriY[i]) {
                enBuyukY = gelenVeriY[i];
            }
            if (enKucukY > gelenVeriY[i]) {
                enKucukY = gelenVeriY[i];
            }
        }

        int ortaX = (enBuyukX + enKucukX) / 2;
        int ortaY = (enBuyukY + enKucukY) / 2;

    }

}
