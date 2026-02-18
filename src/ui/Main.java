package src.ui;
import src.model.Flight;
import src.model.Hotel;
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
        
        try {
            User user = new User(name, surName, tcNumber, phoneNumber);
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
                return;
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
                return;
            }

            userService.deleteUser(user.getUserId());

            System.out.println(user.getFullName() + " | " + user.getTcNumber() + " | " + user.getPhoneNumber());
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // ===================================================================================================================

    public void showHotelMenu() {
        System.out.println("1. Yeni Otel Ekle\n" + 
                        "   2. Tüm Otelleri Listele\n" + 
                        "   3. Şehre Göre Ara\n" + 
                        "   4. Yıldıza Göre Ara\n" + 
                        "   5. Ana Menüye Dön");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addHotel();
                break;
            case 2:
                listAllHotels();
                break;
            case 3:
                searchHotelByCity();
                break;
            case 4:
                searchHotelByStars();
                break;
            case 5:
                break;
        }
    }

    public void addHotel() {
        scanner.nextLine();
        System.out.println("Otel adı: ");
        String hotelName = scanner.nextLine();

        System.out.println("Şehir (Mekke/Medine): ");
        String city = scanner.nextLine();

        System.out.println("Yıldız (1-5): ");
        int stars = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Oda tipi: ");
        String roomType = scanner.nextLine();

        System.out.println("Gecelik fiyat: ");
        double perNightFee = scanner.nextDouble();

        Hotel hotel = new Hotel(hotelName, city, stars, roomType, perNightFee);
        try {
            hotelService.addHotel(hotel);
            System.out.println("Otel eklendi");
        } catch (Exception e) {

        }
    }

    public void listAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();

        if (hotels.isEmpty()) {
            System.out.println("Kayıtlı otel yok");
        }

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getHotelName() + " | " + hotel.getCity() + " | " + hotel.getStarDisplay());
        }
    }

    public void searchHotelByCity() {
        scanner.nextLine();
        System.out.println("Şehir girin (Mekke/Medine): ");
        String city = scanner.nextLine();

        List<Hotel> hotels = hotelService.findByCity(city);

        if (hotels == null) {
            System.out.println("Otel bulunamadı");
        }

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getHotelName() + " | " + hotel.getCity() + " | " + hotel.getStarDisplay());
        }
    }

    public void searchHotelByStars() {
        scanner.nextLine();
        System.out.println("Yıldız sayısı (1-5): ");
        int stars = scanner.nextInt();

        List<Hotel> hotels = hotelService.findByStars(stars); 

        if (hotels == null) {
            System.out.println("Otel bulunamadı");
        }

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getHotelName() + " | " + hotel.getCity() + " | " + hotel.getStarDisplay());
        }
    }

    // ===================================================================================================================

    public void showFlightMenu() {
        System.out.println("1. Yeni Uçuş Ekle\n" + 
                        "   2. Tüm Uçuşları Listele\n" + 
                        "   3. Havayoluna Göre Ara\n" + 
                        "   4. Müsait Uçuşları Göster\n" + 
                        "   5. Ana Menüye Dön");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addFlight();
                break;
            case 2:
                listAllFlights();
                break;
            case 3:
                searchByAirline();
                break;
            case 4:
                showAvailableFlights();
                break;
            case 5:
                break;
        }
    }

    public void addFlight() {
        scanner.nextLine();
        System.out.println("Uçuş numarası: ");
        String flightNo = scanner.nextLine();
        
        System.out.println("Havayolu: ");
        String airline = scanner.nextLine();

        System.out.println("Sınıf (Economy/Business): ");
        String flightType = scanner.nextLine();

        System.out.println("Fiyat: ");
        double price = scanner.nextDouble();
        try {
            Flight flight = new Flight(flightNo, airline, flightType, price);

            flightService.addFlight(flight);

            System.out.println("Uçuş eklendi!");
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void listAllFlights() {
        try {

            List<Flight> flights = flightService.getAllFlights();

            if (flights.isEmpty()) {
                System.out.println("Kayıtlı uçuş yok");
                return;
            }

            for (Flight flight : flights) {
                System.out.println(flight.getFlightSummary());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void searchByAirline() {
        scanner.nextLine();
        System.out.println("Havayolu girin: ");
        String airline = scanner.nextLine();
        try {
            List<Flight> flights = flightService.findByAirline(airline);

            if (flights.isEmpty()) {
                System.out.println("Uçuş bulunamadı");
                return;
            }

            for (Flight flight : flights) {
                System.out.println(flight.getFlightSummary());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public void showAvailableFlights() {
        try {
            List<Flight> flights = flightService.getAvailableFlights();

            if (flights.isEmpty()) {
                System.out.println("Müsait uçuş yok");
                return;
            }

            for (Flight flight : flights) {
                System.out.println(flight.getFlightSummary() + " | Koltuk: " + flight.getAvailableSeats());
            }
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    // =============================================================================================================================

    public void showBookingMenu() {
        System.out.println("1. Yeni Rezarvasyon Oluştur\n" + 
                        "   2. Tüm Rezarvasyonlları Listele\n" + 
                        "   3. Rezarvasyon Ara (ID ile)\n" + 
                        "   4. Rezarvasyon Onayla\n" +
                        "   5. Rezarvasyon İptal Et \n"+ 
                        "   6. Ana Menüye Dön");

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
    
}
