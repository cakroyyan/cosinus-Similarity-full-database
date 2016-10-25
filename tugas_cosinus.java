package coba.pak.bayu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 *
 * @author Recky Davinci
 */
public class tugas_cosinus {
    private static Vector<Integer> no_dbs = new Vector();
    private static Vector<Double> hasil = new Vector();
    private static Vector<String> akata = new Vector();
    private static Vector<String> newakata = new Vector();
    private static Vector<String> kata1 = new Vector();
    private static Vector<String> kata2 = new Vector();
    private static Vector<String> kata_gabung = new Vector();
    private static Vector<Integer> jmlkata1 = new Vector();
    private static Vector<Integer> jmlkata2 = new Vector();

    public static Connection conn;
    public static Statement cn;
    public static ResultSet rs;

    public static boolean cekKata(int n, String x) {
        boolean ketemu = false;

        for (int i = 0; i < n; i++) {
            // jika ada yg sama 
            if (akata.get(i).equalsIgnoreCase(x)) {
                ketemu = true;
                break;
            }
        }
        return ketemu;
    }

    public static boolean cekKata2(int n, String x) {
        boolean ketemu = false;

        for (int i = 0; i < n; i++) {
            // jika ada yg sama 
            if (kata_gabung.get(i).equalsIgnoreCase(x)) {
                ketemu = true;
                break;
            }
        }
        return ketemu;
    }

    public static void as(String teks) {
        Hashtable as = new Hashtable();
        teks = teks.toLowerCase();
        for (int ui = 0; ui < 10; ui++) {
            String we = Integer.toString(ui);
            teks = teks.replace(we, "");
        }
        String temp = "";
        boolean ketemu = false;
        int a, k, n, m, count = 0, jum;
        int s = 0;
        StringTokenizer aas = new StringTokenizer(teks, " ");
        while (aas.hasMoreElements()) {
            akata.add(aas.nextToken());
            s++;
        }
        n = s;
        k = 0;
        a = 0;
        for (int i = 0; i < n; i++) {
            if (!cekKata(a, akata.get(i))) {
                newakata.add(akata.get(i));
                k++;
            }
            a++;
        }
        m = k; // banyaknya kata yg tlah dieliminasi  
        as.clear();
        for (int i = 0; i < m; i++) {
            if (i == count) {
                break;
            }
            jum = 0;
            for (int j = 0; j < n; j++) {
                if (newakata.get(i).equalsIgnoreCase(akata.get(j))) {
                    jum += 1;
                }
            }
            as.put(newakata.get(i), String.valueOf(jum));
        }
        for (int i = 0; i < newakata.size(); i++) {
            kata_gabung.add(newakata.get(i));
        }
    }

    public static void as2() {
        int as = kata1.size();
        int pasti = 0;
        for (int i = 0; i < kata1.size(); i++) {
            int jum = 0;
            for (int j = 0; j < kata_gabung.size(); j++) {
                if (kata1.get(i).equalsIgnoreCase(kata_gabung.get(j))) {
                    jum += 1;
                    pasti += 1;

                }
            }
            jmlkata1.add(jum);
        }
        for (int i = pasti; i < kata_gabung.size(); i++) {
            jmlkata1.add(0);
        }
//        for (int i = 0; i < kata1.size(); i++) {
//            System.out.print(kata1.get(i)+" ");
//        }
//        System.out.println("");
//        
//        for (int i = 0; i < kata2.size(); i++) {
//            System.out.print(kata2.get(i)+" ");
//        }
//        System.out.println("");
//        for (int i = 0; i < kata_gabung.size(); i++) {
//            System.out.print(kata_gabung.get(i)+" ");
//        }
//        System.out.println("");
//        for (int i = 0; i < jmlkata1.size(); i++) {
//            System.out.print(jmlkata1.get(i)+"     ");
//        }

    }

    public static void as3() {
        int as = kata1.size();
        int pasti = 0;
        for (int i = 0; i < kata_gabung.size(); i++) {
            int jum = 0;
            for (int j = 0; j < kata2.size(); j++) {
                if (kata_gabung.get(i).equalsIgnoreCase(kata2.get(j))) {

                    jum += 1;
                    pasti += 1;

                } else {
                }
            }
            jmlkata2.add(jum);
        }
        
//        for (int i = 0; i < jmlkata2.size(); i++) {
//            System.out.print(jmlkata2.get(i)+"     ");
//        }

    }

    public static void akhir() {
        double pembilang = 0;
        double jum_sementara1 = 0;
        double jum_sementara2 = 0;
        for (int i = 0; i < jmlkata1.size(); i++) {
            double angka1 = jmlkata1.get(i);
            double angka2 = jmlkata2.get(i);
            double jum = angka1 * angka2;
            pembilang = pembilang + jum;
            jum = 0;
            angka1 = Math.pow(angka1, 2);
            angka2 = Math.pow(angka2, 2);
            jum_sementara1 = jum_sementara1 + angka1;
            jum_sementara2 = jum_sementara2 + angka2;
            angka1 = 0;
            angka2 = 0;
            //System.out.println("1. "+angka1+"\t2. "+angka2);
        }

//        System.out.println("");
        jum_sementara1 = Math.sqrt(jum_sementara1);
        jum_sementara2 = Math.sqrt(jum_sementara2);

        double jum_total = jum_sementara1 * jum_sementara2;
//        System.out.println("pembilang");
//        System.out.println(pembilang);
//        System.out.println("penyebut");
//        System.out.println(jum_total);
//        System.out.println("Hasil");
//        System.out.println(pembilang / jum_total);
        double hasila = pembilang / jum_total;
        hasil.add(hasila);
    }

    public static void awal(String teks, String teks2) {
        Vector<String> coba = new Vector();
        StringTokenizer ka = new StringTokenizer(teks2, " ");
        while (ka.hasMoreElements()) {
            kata2.add(ka.nextToken());
        }
        String teks3 = teks + " " + teks2;
        coba.add(teks);
        coba.add(teks2);
        as(teks3);
        as2();
//        System.out.println("");
        as3();
        akhir();
        akata.clear();
        newakata.clear();
        kata2.clear();
        kata_gabung.clear();
        jmlkata1.clear();
        jmlkata2.clear();

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in); 
        System.out.print("Masukkan Kata yang di cari : "); 
        String teks = sc.next ();

        //String teks = "singa saya belajar program dengan bahasa java";
        StringTokenizer kata = new StringTokenizer(teks, " ");
        while (kata.hasMoreElements()) {
            kata1.add(kata.nextToken());
        }

        String SQL = "SELECT * FROM kolom ";
        ResultSet rs = KoneksiDB.executeQuery(SQL);
        
        try {
            while (rs.next()) {
                int ber = Integer.parseInt(rs.getString(1));
                no_dbs.add(ber);
                if (ber == 20) {
                    break;
                }
                String teks2 = rs.getString(5);
                awal(teks, teks2);

            }
        } catch (SQLException ex) {
            //Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        int jml_data = hasil.size();
        int no = no_dbs.size();
        double [] data = new double [jml_data];
        int [] no_db = new int [no];
        for (int i = 0; i < data.length; i++) {
            data[i] = hasil.get(i);
            no_db[i] = no_dbs.get(i);
        }
        
        for (int x = 0; x < jml_data - 1; x++) {
            for (int i = 0; i < jml_data - 1; i++) {
                if (data[i] < data[i + 1]) {
                    double j = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = j;
                    int g = no_db[i];
                    no_db[i] = no_db[i + 1];
                    no_db[i + 1] = g;
                }
            }
        }
        for (int i = 0; i < no_db.length; i++) {
            SQL = "SELECT * FROM kolom where id_kolom='"+no_db[i]+"';";
           // System.out.println(SQL);
            rs = KoneksiDB.executeQuery(SQL);
            try {
                while (rs.next()) {
                    System.out.println(rs.getString(2));

                }
            } catch (SQLException ex) {
                //Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        
    }

}
