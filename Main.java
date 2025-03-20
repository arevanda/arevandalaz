class Util {
    public static String formatRupiah(double amount) {
        String amountStr = String.format("%,.2f", amount).replace(',', '.');
        return "Rp" + amountStr;
    }
}

class Perusahaan {
    private final String namaPerusahaan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

class Karyawan {
    private String nama;
    private int gajiPokok;
    private Perusahaan perusahaan;

    public Karyawan(String nama, int gajiPokok, Perusahaan perusahaan) {
        setNama(nama);
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama.length() < 4) {
            throw new IllegalArgumentException("Nama harus memiliki minimal 4 karakter!");
        }
        this.nama = nama;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public int hitungGaji() {
        return gajiPokok;
    }

    public void infoGaji() {
        System.out.println("Nama: " + nama + " | Total Gaji: " + Util.formatRupiah(hitungGaji()) + 
            " | Perusahaan: " + perusahaan.getNamaPerusahaan());
    }
}

class Programmer extends Karyawan {
    private double bonus;

    public Programmer(String nama, int gajiPokok, double bonus, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    @Override
    public int hitungGaji() {
        return (int) (getGajiPokok() + bonus);
    }
}

class Manager extends Karyawan {
    private double insentif;
    private String divisi;

    public Manager(String nama, int gajiPokok, double insentif, String divisi, Perusahaan perusahaan) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
        this.divisi = divisi;
    }

    @Override
    public int hitungGaji() {
        return (int) (getGajiPokok() + insentif);
    }

    public void tampilkanInfo() {
        System.out.println("Nama Manager: " + getNama() + " | Divisi: " + divisi + 
            " | Total Gaji: " + Util.formatRupiah(hitungGaji()) + 
            " | Perusahaan: " + getPerusahaan().getNamaPerusahaan());
    }
}

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("PT. Inovasi Teknologi");

        Karyawan karyawan = new Karyawan("Arev", 5000000, perusahaan);
        Programmer programmer = new Programmer("Reyhan", 6000000, 2000000, perusahaan);
        Manager manager = new Manager("Budi", 8000000, 3000000, "IT", perusahaan);

        karyawan.infoGaji();
        programmer.infoGaji();
        manager.tampilkanInfo();
    }
}
