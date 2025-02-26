public class movieFunction {
    public static void tampilkanPilihanMenu() { // ⚠️ Function
        System.out.println("\n|==============================================|");
        System.out.println("|>>               Menu Utama                 <<|");
        System.out.println("|==============================================|");
        System.out.printf("| %-2s | %-39s |\n", "1", "Tampilkan Jadwal");
        System.out.println("|----------------------------------------------|");
        System.out.printf("| %-2s | %-39s |\n", "2", "Cari Jadwal");
        System.out.println("|----------------------------------------------|");
        System.out.println("|==============================================|");
        System.out.printf("| %-2s | %-39s |\n", "3", "Keluar");
        System.out.println("|==============================================|");
        System.out.print("> Pilih menu: ");
    }

    public static void tampilkanJudul() {
        System.out.println("╔==============================================╗");
        System.out.println("|>>>                                        <<<|");
        System.out.println("|>>             Aplikasi Bioskop             <<|");
        System.out.println("|>>>                                        <<<|");
        System.out.println("╚==============================================╝");
    }
}
