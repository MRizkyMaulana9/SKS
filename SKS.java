import java.util.ArrayList;
import java.util.Scanner;

public class SKS {

    public static void main(String[] args) {
        ArrayList<String> kodeMatkul = new ArrayList<>();
        ArrayList<String> namaMatkul = new ArrayList<>();
        ArrayList<Integer> sksMatkul = new ArrayList<>();
        ArrayList<String> HurufMutu = new ArrayList<>();
        ArrayList<String> NilaiMatkul = new ArrayList<>();

        // Mata kuliah dengan kode, nama matkul, sks, dan nilai
        kodeMatkul.add("PS0101"); namaMatkul.add("nilai dasar shalih akram"); sksMatkul.add(2); HurufMutu.add("B"); NilaiMatkul.add("70,00");
        kodeMatkul.add("PS0102"); namaMatkul.add("Teknologi Aswaja"); sksMatkul.add(2); HurufMutu.add("A-"); NilaiMatkul.add("83,10");
        kodeMatkul.add("PS0104"); namaMatkul.add("Civic education"); sksMatkul.add(2); HurufMutu.add("A-");NilaiMatkul.add("88,00");
        kodeMatkul.add("PS0201"); namaMatkul.add("Ulumul Quran"); sksMatkul.add(2); HurufMutu.add("A-");NilaiMatkul.add("80,60");
        kodeMatkul.add("PS0203"); namaMatkul.add("Sejarah pemikiran dan keuangan perbankan"); sksMatkul.add(2); HurufMutu.add("B+"); NilaiMatkul.add("79,50");
        kodeMatkul.add("PS0205"); namaMatkul.add("Bahasa Arab I"); sksMatkul.add(2); HurufMutu.add("B-"); NilaiMatkul.add("68,00");
        kodeMatkul.add("PS0207"); namaMatkul.add("Bahasa Inggris I"); sksMatkul.add(2);HurufMutu.add("B"); NilaiMatkul.add("72,45");
        kodeMatkul.add("PS0209"); namaMatkul.add("Pengantar ekonomi mikro"); sksMatkul.add(3); HurufMutu.add("A-"); NilaiMatkul.add("82,00");
        kodeMatkul.add("PS0218"); namaMatkul.add("Manajemen Syariah"); sksMatkul.add(2); HurufMutu.add("A-"); NilaiMatkul.add("84,50");
        kodeMatkul.add("PS0227"); namaMatkul.add("Pengantar Filsafat"); sksMatkul.add(2); HurufMutu.add("A-"); NilaiMatkul.add("83,80");
        kodeMatkul.add("PS0416"); namaMatkul.add("Bahasa Indonesia"); sksMatkul.add(2); HurufMutu.add("A-"); NilaiMatkul.add("80,00");
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan Nama Mahasiswa: ");
            String nama = input.nextLine();
            System.out.print("Masukkan jumlah matkul: ");
            int semester = input.nextInt();

            System.out.println("\nDaftar Nilai Mata Kuliah Semester " + semester + " untuk " + nama);
            System.out.println("======================================================================");
            System.out.println("NO  | KODE   | MATAKULIAH       | SKS | Huruf Mutu | Bobot | Nilai");
            System.out.println("----------------------------------------------------------------------");

            double totalSKS = 0;
            double totalNilai = 0;
            double totalBobot = 0;

            for (int i = 0; i < kodeMatkul.size(); i++) {
                if (semester >= (i+1)) {
                    String kode = kodeMatkul.get(i);
                    String Matkul = namaMatkul.get(i);
                    int sks = sksMatkul.get(i);
                    String Huruf = HurufMutu.get(i);
                    String Nilai = NilaiMatkul.get(i);
                    double bobot = sks * 1.5;

                    System.out.println((i+1) + "   | " + kode + " | " + Matkul + " | " + sks + " | " + Huruf + " | " + bobot + " | " + Nilai);

                    totalSKS += sks;
                    totalNilai += sks * getNilaiBobot(Huruf);
                    totalBobot += bobot;
                }
            }

            System.out.println("======================================================================");
            System.out.println("Jumlah SKS: " + totalSKS);
            System.out.println("IP Semester: " + totalBobot / 11);
            System.out.println("SKS Maksimal yang bisa diambil semester depan:" + " " + 24);
        }
    }
    public static double getNilaiBobot(String nilai) {
        double bobot = 0;
        switch (nilai) {
            case "A": bobot = 4.00;  break;
            case "A-": bobot = 3.50; break;
            case "B+": bobot = 3.25; break;
            case "B": bobot = 3.00; break;
            case "B-": bobot = 2.75; break; 
        }
        return bobot;
    }

    public static double getIPSemester(double totalNilai, double totalBobot) {
        return totalNilai / totalBobot;
    }
}