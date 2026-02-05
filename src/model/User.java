package src.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;

public class User {
    
    private String userId;
    private String firstName;
    private String lastName;
    private String tcNumber;
    private String phoneNumber;
    private String passportNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private int previousUmrahCount;
    private String specialNeeds;
    private LocalDateTime createdAt;

    public User(String firstName, String lastName, String tcNumber, String phoneNumber) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (tcNumber == null || tcNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("TC Number cannot be empty");
        }
        if (tcNumber.length() != 11 || !tcNumber.matches("\\d{11}")) {
            throw new IllegalArgumentException("TC Number must be 11 digits long");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        this.userId = "USR-" + System.currentTimeMillis() % 100000;
        this.createdAt = LocalDateTime.now();

        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNumber = tcNumber;
        this.phoneNumber = phoneNumber;

        this.passportNumber = "";
        this.email = "";
        this.dateOfBirth = null;
        this.gender = "";
        this.nationality = "TC";
        this.previousUmrahCount = 0;
        this.specialNeeds = "";
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTcNumber() {
        return tcNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPreviousUmrahCount() {
        return previousUmrahCount;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        if (dateOfBirth == null) {
            return -1; 
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getDiscountRate() {
        if (previousUmrahCount >= 3) {
            return "10%";
        } else if (previousUmrahCount >= 1) {
            return "5%";
        } else {
            return "0%";
        }
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public void setTcNumber(String tcNumber) {
        if (tcNumber == null || tcNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("TC Number cannot be empty");
        } else if (tcNumber.length() != 11 || !tcNumber.matches("\\d{11}")) {
            throw new IllegalArgumentException("TC Number must be 11 digits long");
        }
        this.tcNumber = tcNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setPassportNumber(String passportNumber) {
        if (passportNumber == null || passportNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Passport number cannot be empty");
        }
        this.passportNumber = passportNumber;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
            if (dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth cannot be null");
            } else if (dateOfBirth.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPreviousUmrahCount(int previousUmrahCount) {
        if (previousUmrahCount < 0) {
            throw new IllegalArgumentException("Previous Umrah count cannot be negative");
        }
        this.previousUmrahCount = previousUmrahCount;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    

}
