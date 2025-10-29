public class RentalApp {
    public static void main(String[] args) {
        EquipmentRentalsesudah rental1 = new EquipmentRentalsesudah("Kamera DSLR", "CAM-001", "Andi");
        rental1.showStatus();
        rental1.rent(10); // Andi pinjam 10 hari
        rental1.showStatus();
        rental1.returnItem();
    }
}
