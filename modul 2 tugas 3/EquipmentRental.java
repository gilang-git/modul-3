// SEBELUM REFACTORING

class EquipmentRental {
    // Info Peralatan
    public String itemName;
    public String itemCode;

    // Info Peminjam
    public String borrowerName;

    // Info Peminjaman
    public boolean isRented;
    public int daysRented;
    public int rentalLimit; // Batas hari peminjaman

    public EquipmentRental(String itemName, String itemCode, String borrowerName) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.borrowerName = borrowerName;
        this.isRented = false;
        this.daysRented = 0;
        this.rentalLimit = 7; // Batas pinjam 7 hari (Magic Number)
    }

    // Method untuk meminjam barang
    public void processRental(int days) {
        if (!isRented) {
            this.isRented = true;
            this.daysRented = days;
            System.out.println(borrowerName + " meminjam " + itemName + " selama " + days + " hari.");
        } else {
            System.out.println("Maaf, " + itemName + " sedang dipinjam.");
        }
    }

    // Method untuk mengembalikan barang dan menghitung denda
    public void processReturn() {
        if (isRented) {
            System.out.println(itemName + " telah dikembalikan oleh " + borrowerName + ".");
            // Logika denda ada di sini
            if (daysRented > rentalLimit) {
                // Denda Rp 5000 per hari (Magic Number)
                double fine = (daysRented - rentalLimit) * 5000;
                System.out.println("Keterlambatan: " + (daysRented - rentalLimit) + " hari. Denda: Rp" + fine);
            }
            this.isRented = false;
            this.daysRented = 0;
        } else {
            System.out.println(itemName + " tidak sedang dalam status dipinjam.");
        }
    }

    // Menampilkan status lengkap
    public void showStatus() {
        System.out.println("\n--- Status Peralatan ---");
        System.out.println("Nama Barang: " + itemName + " (" + itemCode + ")");
        if (isRented) {
            System.out.println("Status: Dipinjam oleh " + borrowerName);
            System.out.println("Durasi Pinjam: " + daysRented + " hari");
        } else {
            System.out.println("Status: Tersedia");
        }
    }

    public static void main(String[] args) {
        EquipmentRentalsesudah rental1 = new EquipmentRentalsesudah("Kamera DSLR", "CAM-001", "Andi");
        rental1.showStatus();
        rental1.processRental(10); // Andi pinjam 10 hari
        rental1.showStatus();
        rental1.processReturn();
    }

    public void returnItem() {
    }

    public void rent(int i) {
    }
}