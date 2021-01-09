
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static ArrayList<Integer> icerik = new ArrayList<Integer>();
    public static void dosyaOku(){
        File file = new File("yalanlar.mp3");
        try{
            FileInputStream in = new FileInputStream(file);
            int oku ;
            while((oku = in.read())!=-1){
                icerik.add(oku);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void dosyaKopyala(String dosyaİsmi){
        try {
            FileOutputStream out = new FileOutputStream(dosyaİsmi);
            for(int deger : icerik){
                out.write(deger);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        dosyaOku();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                dosyaKopyala("yalanlar2.mp3");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                dosyaKopyala("yalanlar58.mp3");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                dosyaKopyala("yalanlarThreadProject.mp3");
            }
        });
        long baslangıc = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        long bitis = System.currentTimeMillis();
        System.out.println("3 DOSYA Kopyalanması : "+((bitis-baslangıc)/1000)+" saniye sürdü.");
    
    }
    
}
