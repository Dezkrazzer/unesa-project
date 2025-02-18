import java.util.ArrayList;

public class LoopingTest {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> menu = new ArrayList<>();
        ArrayList<Integer> harga = new ArrayList<>();


        menu.add("Nasi Goreng");
        menu.add("Mie Ayam");
        menu.add("Sate Ayam");
        menu.add("Bakso");
        menu.add("Soto Ayam");


        harga.add(15000);
        harga.add(12000);
        harga.add(20000);
        harga.add(13000);
        harga.add(14000);

        System.out.println("=======[ Menu Makanan ]=======\n|");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("| " + (i + 1) + ". " + menu.get(i) + " - Rp " + harga.get(i));
        }
        System.out.println("|\n==============================");
        System.out.println("\n- By Lazuardi Akbar");
    }
}
