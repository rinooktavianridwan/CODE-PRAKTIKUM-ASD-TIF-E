package pertemuan1.PERTEMUAN1;




public class Generic1 {
    public static void main(String[] args) {
        Printer <Integer> print = new Printer<>(5);
        print.print();
        
        Printer <String> print1 = new Printer<>("kata");
        print1.print();
        
        Printer2<String, Integer> print2 = new Printer2<>("kata", 1);
        print2.print();
    }
    
}

class Printer <X> {
    X  something;
    
    public Printer(X  something){
        this.something = something;
    }
    
    public void print(){
        if (something instanceof Integer) {
            int angka = ((int) something);
             if(angka%2==0){
                 System.out.println(angka+" adalah angka genap");
             }else{
                 System.out.println(angka+" adalah angka ganjil");
             }
        }
        System.out.println(something);
    }
}

class Printer2<X, Y> {
    X  something;
    Y  sesuatu;
    
    
    public Printer2 (X  something, Y  sesuatu){
        this.something = something;
        this.sesuatu = sesuatu;
    }
    
    public void print(){
        System.out.println(something);
        System.out.println(sesuatu);
    }
    
}