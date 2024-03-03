package pertemuan1;


import pertemuan1.Manusia;


public class Mahasiswa extends Manusia{
    String nim;

    public Mahasiswa(String nim, String nama, int umur) {
        super(nama, umur);
        this.nim = nim;
    }
   

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public void makan() {
        super.makan(); 
        System.out.println("ini mahasiswa");
    }
    
    
    
    
    
}
