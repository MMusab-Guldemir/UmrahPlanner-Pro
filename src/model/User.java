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

}
