import java.util.Scanner;

public class HaloNama {
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan nama anda: ");
            String name = input.nextLine();
            
            System.out.println("Halo, " + name);
            System.out.println(" ");
            System.out.println("- By Lazuardi Akbar");
        }
    }
}
