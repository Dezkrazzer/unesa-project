import java.util.ArrayList;

public class CobaArray {
  public static void main(String[] args) {
    String[] arrayNama = new String[4]; 
    arrayNama[0] = "Fais";
    arrayNama[1] = "Akbar";
    arrayNama[2] = "Faqih";
    arrayNama[3] = "Rifki";

    

    System.out.println();
    System.out.println("Menggunakan Array:");
    for (int i = 0; i < arrayNama.length; i++) {
      System.out.println("Nama ke-" + (i + 1) + ": " + arrayNama[i]);
    }

    // =======================================


    ArrayList<String> namaList = new ArrayList<>();
    namaList.add("Fais");
    namaList.add("Akbar");
    namaList.add("Faqih");
    namaList.add("Rifki");
    
    System.out.println();
    System.out.println("Menggunakan ArrayList:");
    for (int i = 0; i < namaList.size(); i++) {
        System.out.println("Nama ke-" + (i + 1) + ": " + namaList.get(i));
    }
  }
}