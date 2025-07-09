package com.literanusa.javafx.model;

import javafx.beans.property.*;
import java.time.LocalDate;

/**
 * Member model class for LiteraNusa application
 * Represents a library member
 */
public class Member {
    
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty address;
    private final StringProperty membershipType;
    private final ObjectProperty<LocalDate> joinDate;
    private final ObjectProperty<LocalDate> expiryDate;
    private final IntegerProperty borrowedBooks;
    private final DoubleProperty fines;
    private final StringProperty status;
    
    // Default constructor
    public Member() {
        this("", "", "", "", "", "Regular", LocalDate.now(), 
             LocalDate.now().plusYears(1), 0, 0.0, "Active");
    }
    
    // Constructor with parameters
    public Member(String id, String name, String email, String phone, String address,
                  String membershipType, LocalDate joinDate, LocalDate expiryDate,
                  int borrowedBooks, double fines, String status) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.membershipType = new SimpleStringProperty(membershipType);
        this.joinDate = new SimpleObjectProperty<>(joinDate);
        this.expiryDate = new SimpleObjectProperty<>(expiryDate);
        this.borrowedBooks = new SimpleIntegerProperty(borrowedBooks);
        this.fines = new SimpleDoubleProperty(fines);
        this.status = new SimpleStringProperty(status);
    }
    
    // Property getters
    public StringProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty emailProperty() { return email; }
    public StringProperty phoneProperty() { return phone; }
    public StringProperty addressProperty() { return address; }
    public StringProperty membershipTypeProperty() { return membershipType; }
    public ObjectProperty<LocalDate> joinDateProperty() { return joinDate; }
    public ObjectProperty<LocalDate> expiryDateProperty() { return expiryDate; }
    public IntegerProperty borrowedBooksProperty() { return borrowedBooks; }
    public DoubleProperty finesProperty() { return fines; }
    public StringProperty statusProperty() { return status; }
    
    // Getters
    public String getId() { return id.get(); }
    public String getName() { return name.get(); }
    public String getEmail() { return email.get(); }
    public String getPhone() { return phone.get(); }
    public String getAddress() { return address.get(); }
    public String getMembershipType() { return membershipType.get(); }
    public LocalDate getJoinDate() { return joinDate.get(); }
    public LocalDate getExpiryDate() { return expiryDate.get(); }
    public int getBorrowedBooks() { return borrowedBooks.get(); }
    public double getFines() { return fines.get(); }
    public String getStatus() { return status.get(); }
    
    // Setters
    public void setId(String id) { this.id.set(id); }
    public void setName(String name) { this.name.set(name); }
    public void setEmail(String email) { this.email.set(email); }
    public void setPhone(String phone) { this.phone.set(phone); }
    public void setAddress(String address) { this.address.set(address); }
    public void setMembershipType(String membershipType) { this.membershipType.set(membershipType); }
    public void setJoinDate(LocalDate joinDate) { this.joinDate.set(joinDate); }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate.set(expiryDate); }
    public void setBorrowedBooks(int borrowedBooks) { this.borrowedBooks.set(borrowedBooks); }
    public void setFines(double fines) { this.fines.set(fines); }
    public void setStatus(String status) { this.status.set(status); }
    
    /**
     * Checks if the member is active
     */
    public boolean isActive() {
        return "Active".equalsIgnoreCase(getStatus()) && 
               getExpiryDate().isAfter(LocalDate.now());
    }
    
    /**
     * Checks if the member can borrow books
     */
    public boolean canBorrow() {
        return isActive() && getBorrowedBooks() < getMaxBorrowLimit() && getFines() == 0.0;
    }
    
    /**
     * Gets the maximum borrow limit based on membership type
     */
    public int getMaxBorrowLimit() {
        return switch (getMembershipType().toLowerCase()) {
            case "premium" -> 10;
            case "student" -> 5;
            case "regular" -> 3;
            default -> 3;
        };
    }
    
    /**
     * Gets the membership duration in days
     */
    public long getMembershipDuration() {
        return java.time.temporal.ChronoUnit.DAYS.between(getJoinDate(), LocalDate.now());
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), getId());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Member member = (Member) obj;
        return getId().equals(member.getId());
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}