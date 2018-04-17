package bungaefektif;

import java.util.Scanner;

class Pinjaman {

    float Pinjam;
    float Angsuran, AngsuranBulan, AngsuranTotal, bungaBulan;
    float Kali, Bunga, i;
    float Sisa;

    public void setPinjam(long Pinjam) {
        this.Pinjam = Pinjam;
        Sisa = Pinjam;
    }

    public void setBunga(int Bunga) {
        this.Bunga = Bunga;

    }

    public void setKali(int Kali) {
        this.Kali = Kali;
    }

    public void membuatNol() {
        AngsuranTotal = 0;
    }

    public void bungaPerbulan() {

        bungaBulan = (float) Sisa * (Bunga / 100) / Kali;

    }

    public void angsuranPokokPerbulan() {
        AngsuranBulan = Pinjam / Kali;
    }

    public void jumlahAngsuran() {
        Angsuran = AngsuranBulan + bungaBulan;
    }

    public void totalAngsuran() {
        AngsuranTotal = AngsuranTotal + Angsuran;
    }

    public void inSisa() {
        Sisa = (long) ((float) Sisa - AngsuranBulan);

    }
//
//    public void setSisa() {
//        Sisa = Sisa - (Pinjam / Kali);
//    }
//
//    public void setAngsuran() {
//
//        Angsuran = (Pinjam / Kali) + (((float) Bunga / 100) * Sisa);
//
//    }

    public void PrintScr() {

        membuatNol();
        angsuranPokokPerbulan();
        System.out.println("\n"
                + "======================================================================================================================");
        System.out.println("| Angsuran ke- | Saldo Angsuran     | Besar Angsuran          |     Bunga                 |    Jumlah Angsuran  |");
        System.out.println("=================================================================================================================");

        for (i = 1; i <= Kali; i++) {
            if (i == 1) {
                
            }
            else{
                inSisa();
            }
            
            bungaPerbulan();
            jumlahAngsuran();
            totalAngsuran();

            System.out.println("|      " + i + " |   Rp. " + (long) Sisa + "  |   Rp. " + AngsuranBulan + "                 | "
                    + "Rp.  " + bungaBulan + "             |   Rp." + Angsuran + " |");
            
            System.out.println("=============================================================================================================");

        }
        System.out.println("|      Jumlah |     |   Rp. "+ (long) Pinjam + "                 | "
                    + "Rp.  " + + (long)(AngsuranTotal-Pinjam) + "             |   Rp." + (long)AngsuranTotal + " |");
        System.out.println("=============================================================================================================");
    }

}

public class BungaEfektif {

    public static void main(String[] args) {
        Pinjaman rent = new Pinjaman();
        Scanner sn = new Scanner(System.in);

        System.out.print("Masukan Besar Pinjaman : ");
        rent.setPinjam(sn.nextLong());
        System.out.print("Masukan Besar Bunga    : ");
        rent.setBunga(sn.nextInt());
        System.out.print("Masukan Banyak Angsuran: ");
        rent.setKali(sn.nextInt());

        rent.PrintScr();
    }

}
