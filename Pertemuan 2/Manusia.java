package pertemuan1;



public class Manusia {

    String nama;
    int umur;

    public Manusia(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void setNmana(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void makan() {
        System.out.println(nama+ "sedang makan");
        
    }
}
