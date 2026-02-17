package src.ui;
import src.model.User;
import src.service.BookingService;
import src.service.FlightService;
import src.service.HotelService;
import src.service.UserService;

import java.util.List;
import java.util.Scanner;
public class Main {
    private UserService userService;
    private HotelService hotelService;
    private FlightService flightService;
    private BookingService bookingService;
    private Scanner scanner;

    public Main() {
        this.userService = new UserService();
        this.hotelService = new HotelService();
        this.flightService = new FlightService();
        this.bookingService = new BookingService();
        this.scanner = new Scanner(System.in);

    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    public void run() {
        while (true) {
            showMainMenu();
        }
    }

    public void showMainMenu() {
        System.out.println(" ═══════════════════════════\n" + 
                        "   UMRAH TRAVEL MANAGEMENT\n" + 
                        "   ═══════════════════════════\n" + 
                        "   1. Kullanıcı İşlemleri\n" + 
                        "   2. Otel İşlemleri\n" + 
                        "   3. Uçuş İşlemleri\n" + 
                        "   4. Rezervasyon İşlemleri\n" + 
                        "   5. Çıkış");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                showUserMenu();
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                System.exit(0);
                break;
        }
    }

    public void showUserMenu() {
        System.out.println("1. Yeni Kullanıcı Ekle\n" + 
                        "   2. Tüm Kullanıcıları Listele\n" + 
                        "   3. Kullanıcı Ara (TC ile)\n" + 
                        "   4. Kullanıcı Sil\n" + 
                        "   5. Ana Menüye Dön");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;
        }
    }

    public void addUser() {
        scanner.nextLine();
        System.out.println("Ad girin: ");
        String name = scanner.nextLine();

        System.out.println("Soyad girin: ");
        String surName = scanner.nextLine();

        System.out.println("Tc girin: ");
        String tcNumber = scanner.nextLine();

        System.out.println("Telefon girin: ");
        String phoneNumber = scanner.nextLine();
        
        User user = new User(name, surName, tcNumber, phoneNumber);
        try {
            userService.registerUser(user);
            System.out.println("Kullanıcı kaydedildi!");
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void listAllUsers() {
        try {
            List<User> list = userService.getAllUsers();

            if (list.isEmpty()) {
                System.out.println("Kayıtlı Kullanıcı yok");
                return;
            }

            for (User user : list) {
                System.out.println(user.getFullName()+ " | " + user.getTcNumber() + " | " + user.getPhoneNumber());
            } 
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void searchUserByTc() {
        scanner.nextLine();
        System.out.println("Tc girin: ");
        String tcNumber = scanner.nextLine();
        try {
            User user = userService.findByTcNumber(tcNumber);

            if(user == null) {
                System.out.println("Kullanıcı bulunamadı");
            }

            System.out.println(user.getFullName() + " | " + user.getTcNumber() + " | " + user.getPhoneNumber());
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void deleteUser() {
        scanner.nextLine();
        System.out.println("Silinecek kullanıcı TC girin: ");
        String tcNumber = scanner.nextLine();

        try {
            User user = userService.findByTcNumber(tcNumber);
            
            if (user == null) {
                System.out.println("Kullanıcı bulunamadı");
            }

            System.out.println(user.getFullName() + " | " + user.getTcNumber() + " | " + user.getPhoneNumber());
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }


    
}
