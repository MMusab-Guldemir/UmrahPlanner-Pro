# UmrahPlanner-Pro

# 🕌 Bireysel Umre Planlama Platformu - Proje Yol Haritası

> Bu döküman, projenin tüm yapısını ve her sınıfın içeriğini gösterir.
> Kod yazarken bu dosyaya bakarak ilerle.

---

## 📁 PROJE KLASÖR YAPISI



```
UmrahPlannerV2/
│
├── src/
│   ├── model/                    ← ADIM 1: Veri sınıfları
│   │   ├── Flight.java
│   │   ├── Hotel.java
│   │   ├── VisitPlace.java
│   │   ├── User.java
│   │   ├── Booking.java
│   │   └── UmrahPackage.java
│   │
│   ├── dao/                      ← ADIM 2: Veritabanı işlemleri
│   │   ├── FlightDAO.java
│   │   ├── HotelDAO.java
│   │   ├── VisitPlaceDAO.java
│   │   ├── UserDAO.java
│   │   └── BookingDAO.java
│   │
│   ├── service/                  ← ADIM 3: İş mantığı
│   │   ├── FlightService.java
│   │   ├── HotelService.java
│   │   ├── BookingService.java
│   │   ├── PriceCalculator.java
│   │   └── UserService.java
│   │
│   ├── util/                     ← ADIM 4: Yardımcı sınıflar
│   │   ├── Constants.java
│   │   ├── Validator.java
│   │   └── IdGenerator.java
│   │
│   └── Main.java                 ← ADIM 5: Ana uygulama
│
├── data/                         ← Statik veriler (JSON veya TXT)
│   ├── flights.json
│   ├── hotels.json
│   └── visit_places.json
│
├── PROJECT_ROADMAP.md            ← Bu dosya
└── README.md
```

---

## 🎯 GELİŞTİRME SIRASI

```
1. MODEL KATMANI     →  Önce veri yapılarını oluştur
        ↓
2. DAO KATMANI       →  Verileri okuma/yazma
        ↓
3. SERVICE KATMANI   →  İş mantığı ve hesaplamalar
        ↓
4. MAIN UYGULAMA     →  Her şeyi birleştir
```

---

# 📦 ADIM 1: MODEL KATMANI

Model sınıfları sadece **veri tutar**. Ekrana yazmaz, kullanıcıdan input almaz.

---

## ✈️ Flight.java (Uçuş)

Bir uçuşun tüm bilgilerini tutan sınıf.

### Alanlar (Fields) - Hepsi `private`

| Alan Adı | Tip | Açıklama | Örnek Değer |
|----------|-----|----------|-------------|
| `flightId` | String | Benzersiz ID | "FLT-001" |
| `flightNumber` | String | Uçuş numarası | "TK1234" |
| `airline` | String | Havayolu şirketi | "Turkish Airlines" |
| `departureCity` | String | Kalkış şehri | "İstanbul" |
| `arrivalCity` | String | Varış şehri | "Cidde" |
| `departureTime` | LocalDateTime | Kalkış zamanı | 2026-03-15T08:30 |
| `arrivalTime` | LocalDateTime | Varış zamanı | 2026-03-15T12:45 |
| `flightClass` | String | Uçuş sınıfı | "Economy" / "Business" |
| `price` | double | Bilet fiyatı (USD) | 450.0 |
| `availableSeats` | int | Boş koltuk sayısı | 45 |
| `rating` | double | Puan (1-5) | 4.2 |
| `isDirect` | boolean | Direkt mi? | true |

### Constructor

```java
public Flight(String flightNumber, String airline, String flightClass, double price)
```

### Metodlar

| Metod | Dönüş Tipi | Açıklama |
|-------|------------|----------|
| `getFlightId()` | String | ID döndürür |
| `getFlightNumber()` | String | Uçuş no döndürür |
| `getAirline()` | String | Havayolu döndürür |
| `getPrice()` | double | Fiyat döndürür |
| `setPrice(double)` | void | Fiyat ayarlar (validasyonlu!) |
| `calculateDuration()` | double | Uçuş süresini saat olarak hesaplar |
| `getFlightSummary()` | String | "THY - TK1234 \| Economy \| $450" |
| `toString()` | String | Debug için tüm bilgiler |

### Validasyon Kuralları

- `price` → 0'dan küçük olamaz
- `rating` → 0-5 arasında olmalı
- `flightNumber` → Boş olamaz, 3-10 karakter
- `arrivalTime` → `departureTime`'dan önce olamaz

---

## 🏨 Hotel.java (Otel)

Mekke ve Medine'deki otellerin bilgilerini tutan sınıf.

### Alanlar (Fields) - Hepsi `private`

| Alan Adı | Tip | Açıklama | Örnek Değer |
|----------|-----|----------|-------------|
| `hotelId` | String | Benzersiz ID | "HTL-001" |
| `hotelName` | String | Otel adı | "Hilton Suites" |
| `city` | String | Şehir | "Mekke" / "Medine" |
| `starRating` | int | Yıldız (1-5) | 5 |
| `roomType` | String | Oda tipi | "Standard" / "Deluxe" / "Suite" |
| `distanceToHaram` | int | Harem'e mesafe (metre) | 150 |
| `pricePerNight` | double | Gecelik fiyat (USD) | 120.0 |
| `numberOfNights` | int | Kalınacak gece | 5 |
| `rating` | double | Kullanıcı puanı | 4.5 |
| `amenities` | String[] | Olanaklar | ["WiFi", "Kahvaltı", "Havuz"] |
| `haramView` | boolean | Harem manzarası var mı? | true |

### Constructor

```java
public Hotel(String hotelName, String city, int starRating, String roomType, double pricePerNight)
```

### Metodlar

| Metod | Dönüş Tipi | Açıklama |
|-------|------------|----------|
| `getHotelName()` | String | Otel adı (PARAMETRESİZ!) |
| `getTotalPrice()` | double | numberOfNights × pricePerNight |
| `getStarDisplay()` | String | "★★★★★" veya "★★★☆☆" |
| `getDistanceDescription()` | String | "150m - Çok Yakın" |
| `getHotelSummary()` | String | Özet bilgi |

### Validasyon Kuralları

- `starRating` → 1-5 arasında olmalı
- `pricePerNight` → 0'dan büyük olmalı
- `numberOfNights` → En az 1 olmalı
- `distanceToHaram` → Negatif olamaz

---

## 🕌 VisitPlace.java (Ziyaret Yeri)

Kutsal mekanların bilgilerini tutan sınıf.

### Alanlar (Fields) - Hepsi `private`

| Alan Adı | Tip | Açıklama | Örnek Değer |
|----------|-----|----------|-------------|
| `placeId` | String | Benzersiz ID | "VP-001" |
| `placeName` | String | Yer adı | "Hira Dağı" |
| `city` | String | Şehir | "Mekke" |
| `description` | String | Açıklama | "Hz. Muhammed'e ilk vahyin..." |
| `entryFee` | double | Tur ücreti (USD) | 25.0 |
| `estimatedDuration` | String | Tahmini süre | "2-3 saat" |
| `importance` | String | Önem derecesi | "Çok Önemli" / "Önemli" / "Tavsiye" |
| `type` | String | Tip | "Tarihi" / "Dini" / "Doğal" |
| `isIncluded` | boolean | Seçildi mi? | false |

### Constructor

```java
public VisitPlace(String placeName, String city, double entryFee, String importance)
```

### Metodlar

| Metod | Dönüş Tipi | Açıklama |
|-------|------------|----------|
| `getPlaceName()` | String | Yer adı |
| `getEntryFee()` | double | Ücret |
| `isIncluded()` | boolean | Seçili mi? |
| `setIncluded(boolean)` | void | Seçim durumunu değiştir |
| `getPlaceSummary()` | String | Özet bilgi |

---

## 👤 User.java (Kullanıcı/Umreci)

Umre yapacak kişinin bilgilerini tutan sınıf.

### Alanlar (Fields) - Hepsi `private`

| Alan Adı | Tip | Açıklama | Örnek Değer |
|----------|-----|----------|-------------|
| `userId` | String | Benzersiz ID | "USR-001" |
| `firstName` | String | Ad | "Musab" |
| `lastName` | String | Soyad | "Yılmaz" |
| `tcNumber` | String | TC Kimlik (11 hane) | "12345678901" |
| `passportNumber` | String | Pasaport no | "U12345678" |
| `email` | String | E-posta | "musab@email.com" |
| `phoneNumber` | String | Telefon | "+90 555 123 4567" |
| `dateOfBirth` | LocalDate | Doğum tarihi | 1990-05-15 |
| `gender` | String | Cinsiyet | "Erkek" / "Kadın" |
| `nationality` | String | Uyruk | "TC" |
| `previousUmrahCount` | int | Önceki umre sayısı | 2 |
| `specialNeeds` | String | Özel ihtiyaçlar | "Tekerlekli sandalye" |
| `createdAt` | LocalDateTime | Kayıt tarihi | Otomatik |

### Constructor

```java
public User(String firstName, String lastName, String tcNumber, String phoneNumber)
```

### Metodlar

| Metod | Dönüş Tipi | Açıklama |
|-------|------------|----------|
| `getFullName()` | String | Ad + " " + Soyad |
| `getAge()` | int | Bugünkü yaşı hesaplar |
| `getDiscountRate()` | double | Önceki umrelere göre indirim (0.05, 0.10...) |
| `getUserSummary()` | String | Özet bilgi |

### Validasyon Kuralları

- `tcNumber` → Tam 11 hane, sadece rakam
- `email` → @ içermeli (basit kontrol)
- `phoneNumber` → Boş olamaz
- `dateOfBirth` → Gelecekte olamaz

---

## 📋 Booking.java (Rezervasyon)

Kullanıcının tüm seçimlerini bir arada tutan ana sınıf.

### Alanlar (Fields) - Hepsi `private`

| Alan Adı | Tip | Açıklama |
|----------|-----|----------|
| `bookingId` | String | Rezervasyon no: "BKG-001" |
| `user` | User | Rezervasyonu yapan kişi |
| `outboundFlight` | Flight | Gidiş uçuşu |
| `returnFlight` | Flight | Dönüş uçuşu |
| `makkahHotel` | Hotel | Mekke oteli |
| `madinahHotel` | Hotel | Medine oteli |
| `visitPlaces` | List&lt;VisitPlace&gt; | Seçilen ziyaret yerleri |
| `numberOfTravelers` | int | Toplam kişi sayısı |
| `travelDate` | LocalDate | Seyahat başlangıç tarihi |
| `hasGuide` | boolean | Rehber var mı? |
| `guideFee` | double | Rehber ücreti |
| `hasVisa` | boolean | Vize dahil mi? |
| `visaFee` | double | Vize ücreti |
| `hasInsurance` | boolean | Sigorta var mı? |
| `insuranceFee` | double | Sigorta ücreti |
| `totalPrice` | double | Toplam fiyat |
| `status` | String | Durum: "Beklemede" / "Onaylı" / "İptal" |
| `createdAt` | LocalDateTime | Oluşturma tarihi |
| `notes` | String | Notlar |

### Constructor

```java
public Booking(User user)
```

### Metodlar

| Metod | Dönüş Tipi | Açıklama |
|-------|------------|----------|
| `setOutboundFlight(Flight)` | void | Gidiş uçuşu ata |
| `setReturnFlight(Flight)` | void | Dönüş uçuşu ata |
| `setMakkahHotel(Hotel)` | void | Mekke oteli ata |
| `setMadinahHotel(Hotel)` | void | Medine oteli ata |
| `addVisitPlace(VisitPlace)` | void | Ziyaret yeri ekle |
| `removeVisitPlace(VisitPlace)` | void | Ziyaret yeri çıkar |
| `calculateTotalPrice()` | double | Tüm seçimlerin toplamı |
| `getBookingSummary()` | String | Detaylı özet |
| `getPriceBreakdown()` | String | Fiyat dökümü |

### Fiyat Hesaplama Mantığı

```
TOPLAM = 
    + (gidişUçuş.fiyat × kişiSayısı)
    + (dönüşUçuş.fiyat × kişiSayısı)
    + (mekkeOtel.toplamFiyat × kişiSayısı)
    + (medineOtel.toplamFiyat × kişiSayısı)
    + (seçilenZiyaretYerleri.toplam × kişiSayısı)
    + (rehberÜcreti)
    + (vizeÜcreti × kişiSayısı)
    + (sigortaÜcreti × kişiSayısı)
    - (indirim)
```

---

## 📦 UmrahPackage.java (Hazır Paket) - OPSIYONEL

Hazır paketler için (Economy, Comfort, Premium).

### Alanlar

| Alan Adı | Tip | Açıklama |
|----------|-----|----------|
| `packageId` | String | Paket ID |
| `packageName` | String | "Ekonomi Paketi" |
| `packageType` | String | "Economy" / "Comfort" / "Premium" |
| `description` | String | Açıklama |
| `duration` | int | Süre (gün) |
| `basePrice` | double | Temel fiyat |
| `includedFlightClass` | String | Dahil uçuş sınıfı |
| `includedHotelStars` | int | Dahil otel yıldızı |
| `includedVisitPlaces` | List&lt;String&gt; | Dahil ziyaret yerleri |
| `hasGuide` | boolean | Rehber dahil mi |
| `hasVisa` | boolean | Vize dahil mi |
| `hasInsurance` | boolean | Sigorta dahil mi |

---

# 📂 ADIM 2: DAO KATMANI

DAO (Data Access Object) sınıfları verileri **okur ve yazar**.
Şimdilik dosyadan okuyacağız, ileride veritabanına geçebilirsin.

### Her DAO şunları içerir:

```java
public class FlightDAO {
    
    // Tüm uçuşları getir
    public List<Flight> getAllFlights() { }
    
    // ID ile uçuş bul
    public Flight getFlightById(String id) { }
    
    // Şehre göre filtrele
    public List<Flight> getFlightsByCity(String city) { }
    
    // Fiyata göre sırala
    public List<Flight> getFlightsSortedByPrice() { }
}
```

---

# ⚙️ ADIM 3: SERVICE KATMANI

Service sınıfları **iş mantığını** içerir.

### PriceCalculator.java

```java
public class PriceCalculator {
    
    // Toplam fiyat hesapla
    public double calculateTotal(Booking booking) { }
    
    // İndirim hesapla
    public double calculateDiscount(User user, double total) { }
    
    // Vergi hesapla
    public double calculateTax(double total) { }
}
```

### BookingService.java

```java
public class BookingService {
    
    // Yeni rezervasyon oluştur
    public Booking createBooking(User user) { }
    
    // Rezervasyonu onayla
    public void confirmBooking(Booking booking) { }
    
    // Rezervasyonu iptal et
    public void cancelBooking(String bookingId) { }
}
```

---

# 🛠️ ADIM 4: UTIL (YARDIMCI) SINIFLAR

### Constants.java

```java
public class Constants {
    public static final double TAX_RATE = 0.18;
    public static final double GUIDE_FEE = 200.0;
    public static final double VISA_FEE = 150.0;
    public static final double INSURANCE_FEE = 100.0;
    
    public static final String CURRENCY = "USD";
}
```

### IdGenerator.java

```java
public class IdGenerator {
    public static String generateFlightId() { }
    public static String generateHotelId() { }
    public static String generateBookingId() { }
    public static String generateUserId() { }
}
```

### Validator.java

```java
public class Validator {
    public static boolean isValidTcNumber(String tc) { }
    public static boolean isValidEmail(String email) { }
    public static boolean isValidPhone(String phone) { }
    public static boolean isValidPrice(double price) { }
}
```

---

# ✅ YAPILACAKLAR CHECKLIST

## Model Katmanı
- [ ] Flight.java
- [ ] Hotel.java
- [ ] VisitPlace.java
- [ ] User.java
- [ ] Booking.java
- [ ] UmrahPackage.java (opsiyonel)

## DAO Katmanı
- [ ] FlightDAO.java
- [ ] HotelDAO.java
- [ ] VisitPlaceDAO.java
- [ ] UserDAO.java
- [ ] BookingDAO.java

## Service Katmanı
- [ ] PriceCalculator.java
- [ ] BookingService.java
- [ ] UserService.java

## Util Katmanı
- [ ] Constants.java
- [ ] IdGenerator.java
- [ ] Validator.java

## Ana Uygulama
- [ ] Main.java

---

# 💡 HATIRLAT

1. **Her sınıfı yazdıktan sonra test et** - Küçük bir main metodu ile
2. **Sırayla ilerle** - Önce tüm modelleri bitir, sonra DAO'lara geç
3. **Takıldığında sor** - Her adımda yardım alabileceğini unutma
4. **Commit at** - Her sınıf bittiğinde GitHub'a commit

---

**Başarılar! 🚀**

*İlk hedef: Flight.java'yı yaz ve test et!*


















-----------------------------------------------------------------


getAll() → new ArrayList<>(flights) döndür (defensive copy)
getById() → for döngüsü ile listede gez, equals() ile karşılaştır
save() → null kontrolü yap, sonra flights.add(flight)
update() → önce getById() ile bul, sonra delete(), sonra save()
delete() → removeIf() kullanabilirsin veya for döngüsü
Filtreleme metodları → Yeni liste oluştur, for ile gez, uygun olanları ekle



[ ] package ve import
[ ] private List<Flight> flights
[ ] Constructor
[ ] getAll() - defensive copy
[ ] getById(String id)
[ ] save(Flight flight) - null kontrolü
[ ] update(Flight flight)
[ ] delete(String id)
[ ] getByCity(String city)
[ ] getByAirline(String airline)
[ ] getByPriceRange(double min, double max)