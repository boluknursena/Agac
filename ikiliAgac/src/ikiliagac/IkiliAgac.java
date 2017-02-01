package ikiliagac;

class Dugum {

    int sayi;
    Dugum solCocuk;
    Dugum sagCocuk;

    Dugum(int sayi) {
        this.sayi = sayi;
    }

    public String toString() {
        return "" + sayi;
    }
}

public class IkiliAgac {

    Dugum kok;

    public void dugumEkle(int sayi) {
        Dugum yeniDugum = new Dugum(sayi);
        if (kok == null) {
            kok = yeniDugum;
        } else {
            Dugum odaklananDugum = kok;
            Dugum ust;
            while (true) {
                ust = odaklananDugum;
                if (sayi < odaklananDugum.sayi) {
                    odaklananDugum = odaklananDugum.solCocuk;
                    if (odaklananDugum == null) {
                        ust.solCocuk = yeniDugum;
                        return;
                    }
                } else {
                    odaklananDugum = odaklananDugum.sagCocuk;
                    if (odaklananDugum == null) {
                        ust.sagCocuk = yeniDugum;
                        return;
                    }
                }
            }
        }
    }

    public boolean dugumSil(int sayi) {
        Dugum odaklananDugum = kok;
        Dugum ust = kok;
        boolean solCocukMu = true;
        while (odaklananDugum.sayi != sayi) {
            ust = odaklananDugum;
            if (sayi < odaklananDugum.sayi) {
                solCocukMu = true;
                odaklananDugum = odaklananDugum.solCocuk;
            } else {
                solCocukMu = false;
                odaklananDugum = odaklananDugum.sagCocuk;
            }
            if (odaklananDugum == null) {
                return false;
            }
        }
        if (odaklananDugum.solCocuk == null && odaklananDugum.sagCocuk == null) {
            if (odaklananDugum == kok) {
                kok = null;
            } else if (solCocukMu) {
                ust.solCocuk = null;
            } else {
                ust.sagCocuk = null;
            }
        } else if (odaklananDugum.sagCocuk == null) {
            if (odaklananDugum == kok) {
                kok = odaklananDugum.solCocuk;
            } else if (solCocukMu) {
                ust.solCocuk = odaklananDugum.solCocuk;
            } else {
                ust.sagCocuk = odaklananDugum.solCocuk;
            }
        } else if (odaklananDugum.solCocuk == null) {
            if (odaklananDugum == kok) {
                kok = odaklananDugum.sagCocuk;
            } else if (solCocukMu) {
                ust.solCocuk = odaklananDugum.sagCocuk;
            } else {
                ust.sagCocuk = odaklananDugum.sagCocuk;
            }
        } else {
            Dugum yenilenen = noduYenile(odaklananDugum);
            if (odaklananDugum == kok) {
                kok = yenilenen;
            } else if (solCocukMu) {
                ust.solCocuk = yenilenen;
            } else {
                ust.sagCocuk = yenilenen;
            }
            yenilenen.solCocuk = odaklananDugum.solCocuk;
        }
        return true;
    }

    public Dugum noduYenile(Dugum yenilenecekDugum) {
        Dugum yenileneceginustu = yenilenecekDugum;
        Dugum yenilenen = yenilenecekDugum;
        Dugum odaklananDugum = yenilenecekDugum.sagCocuk;
        while (odaklananDugum != null) {
            yenileneceginustu = yenilenen;
            yenilenen = odaklananDugum;
            odaklananDugum = odaklananDugum.solCocuk;
        }
        if (yenilenen != yenilenecekDugum.sagCocuk) {
            yenileneceginustu.solCocuk = yenilenen.sagCocuk;
            yenilenen.sagCocuk = yenilenecekDugum.sagCocuk;
        }
        return yenilenen;
    }

    public Dugum dugumBul(int sayi) {
        Dugum odaklananDugum = kok;
        while (odaklananDugum.sayi != sayi) {
            if (sayi < odaklananDugum.sayi) {
                odaklananDugum = odaklananDugum.solCocuk;
            } else {
                odaklananDugum = odaklananDugum.sagCocuk;
            }
            if (odaklananDugum == null) {
                return null;
            }
        }
        return odaklananDugum;
    }

    public void inOrder(Dugum odaklananDugum) {

        if (odaklananDugum != null) {
            inOrder(odaklananDugum.solCocuk);
            System.out.println(odaklananDugum);
            inOrder(odaklananDugum.sagCocuk);
        }
    }

    public void preorder(Dugum odaklananDugum) {
        if (odaklananDugum != null) {
            System.out.println(odaklananDugum);
            preorder(odaklananDugum.solCocuk);
            preorder(odaklananDugum.sagCocuk);
        }
    }

    public void postOrder(Dugum odaklananDugum) {
        if (odaklananDugum != null) {
            postOrder(odaklananDugum.solCocuk);
            postOrder(odaklananDugum.sagCocuk);
            System.out.println(odaklananDugum);
        }
    }

    public static void main(String[] args) {
        IkiliAgac agac = new IkiliAgac();
        agac.dugumEkle(50);
        agac.dugumEkle(25);
        agac.dugumEkle(15);
        agac.dugumEkle(30);
        agac.dugumEkle(75);
        agac.dugumEkle(85);
        agac.dugumEkle(60);
        agac.dugumEkle(65);

        //agac.inOrder(agac.kok);
        //agac.preorder(agac.kok);
        //agac.postOrder(v.kok);
        agac.inOrder(agac.kok);
        agac.dugumSil(50);
        System.out.println(agac.dugumBul(50));
        agac.inOrder(agac.kok);
    }
}
