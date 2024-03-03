package pertemuan1;


import pertemuan1.Manusia;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Manusia rino = new Manusia("rino", 10);
        rino.makan();
        Mahasiswa irul = new Mahasiswa("202002020", "irul", 20);
        irul.makan();
        
        
        Mahasiswa arrayMahasiswa[] = new Mahasiswa[2];
        for (int i = 0; i < 2; i++) {
            String nama = in.nextLine();
            int umur = in.nextInt();
            in.nextLine();
            String nim = in.nextLine();
            arrayMahasiswa[i] = new Mahasiswa(nim, nama, umur);
            
        }
        
        System.out.println(arrayMahasiswa[0].getNama()+ arrayMahasiswa[0].getNim());
    }

}
