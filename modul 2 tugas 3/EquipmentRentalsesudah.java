// SESUDAH REFACTORING

class EquipmentRentalsesudah {
    public static final int RENTAL_LIMIT = 7;
    public static final int FINE_PER_DAY = 5000;
    // Info Peralatan
    private String itemName;
    private String itemCode;

    // Info Peminjam
    private String borrowerName;

    // Info Peminjaman
    private boolean isRented;
    private int daysRented;
    private int rentalLimit; // Batas hari peminjaman

    public EquipmentRentalsesudah(String itemName, String itemCode, String borrowerName) {
        this.setItemName(itemName);
        this.setItemCode(itemCode);
        this.setBorrowerName(borrowerName);
        this.setRented(false);
        this.setDaysRented(0);
        this.setRentalLimit(RENTAL_LIMIT); // Batas pinjam 7 hari (Magic Number)
    }

    // Method untuk meminjam barang
    public void rent(int days) {
        if (!isRented()) {
            this.setRented(true);
            this.setDaysRented(days);
            System.out.println(getBorrowerName() + " meminjam " + getItemName() + " selama " + days + " hari.");
        } else {
            System.out.println("Maaf, " + getItemName() + " sedang dipinjam.");
        }
    }

    // Method untuk mengembalikan barang dan menghitung denda
    public void returnItem() {
        if (isRented()) {
            System.out.println(getItemName() + " telah dikembalikan oleh " + getBorrowerName() + ".");
            // Logika denda ada di sini
            if (getDaysRented() > getRentalLimit()) {
                // Denda Rp 5000 per hari (Magic Number)
                double fine = getFine();
                System.out.println("Keterlambatan: " + (getDaysRented() - getRentalLimit()) + " hari. Denda: Rp" + fine);
            }
            this.setRented(false);
            this.setDaysRented(0);
        } else {
            System.out.println(getItemName() + " tidak sedang dalam status dipinjam.");
        }
    }

    private double getFine() {
        double fine = (getDaysRented() - getRentalLimit()) * FINE_PER_DAY;
        return fine;
    }

    // Menampilkan status lengkap
    public void showStatus() {
        System.out.println("\n--- Status Peralatan ---");
        System.out.println("Nama Barang: " + getItemName() + " (" + getItemCode() + ")");
        if (isRented()) {
            System.out.println("Status: Dipinjam oleh " + getBorrowerName());
            System.out.println("Durasi Pinjam: " + getDaysRented() + " hari");
        } else {
            System.out.println("Status: Tersedia");
        }
    }
    // Encapsulate Field
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    public int getRentalLimit() {
        return rentalLimit;
    }

    public void setRentalLimit(int rentalLimit) {
        this.rentalLimit = rentalLimit;
    }

    public void processRental(int i) {
    }

    public void processReturn() {
        
    }
}