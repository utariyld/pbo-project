package com.literanusa.javafx.model;

import javafx.beans.property.*;

/**
 * Book model class for LiteraNusa application
 * Represents a book in the library system
 */
public class Book {
    
    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty isbn;
    private final StringProperty category;
    private final StringProperty publisher;
    private final IntegerProperty year;
    private final IntegerProperty totalCopies;
    private final IntegerProperty availableCopies;
    private final StringProperty description;
    private final StringProperty status;
    
    // Default constructor
    public Book() {
        this("", "", "", "", "", "", 0, 0, 0, "", "Available");
    }
    
    // Constructor with parameters
    public Book(String id, String title, String author, String isbn, String category, 
                String publisher, int year, int totalCopies, int availableCopies, 
                String description, String status) {
        this.id = new SimpleStringProperty(id);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.isbn = new SimpleStringProperty(isbn);
        this.category = new SimpleStringProperty(category);
        this.publisher = new SimpleStringProperty(publisher);
        this.year = new SimpleIntegerProperty(year);
        this.totalCopies = new SimpleIntegerProperty(totalCopies);
        this.availableCopies = new SimpleIntegerProperty(availableCopies);
        this.description = new SimpleStringProperty(description);
        this.status = new SimpleStringProperty(status);
    }
    
    // Property getters
    public StringProperty idProperty() { return id; }
    public StringProperty titleProperty() { return title; }
    public StringProperty authorProperty() { return author; }
    public StringProperty isbnProperty() { return isbn; }
    public StringProperty categoryProperty() { return category; }
    public StringProperty publisherProperty() { return publisher; }
    public IntegerProperty yearProperty() { return year; }
    public IntegerProperty totalCopiesProperty() { return totalCopies; }
    public IntegerProperty availableCopiesProperty() { return availableCopies; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty statusProperty() { return status; }
    
    // Getters
    public String getId() { return id.get(); }
    public String getTitle() { return title.get(); }
    public String getAuthor() { return author.get(); }
    public String getIsbn() { return isbn.get(); }
    public String getCategory() { return category.get(); }
    public String getPublisher() { return publisher.get(); }
    public int getYear() { return year.get(); }
    public int getTotalCopies() { return totalCopies.get(); }
    public int getAvailableCopies() { return availableCopies.get(); }
    public String getDescription() { return description.get(); }
    public String getStatus() { return status.get(); }
    
    // Setters
    public void setId(String id) { this.id.set(id); }
    public void setTitle(String title) { this.title.set(title); }
    public void setAuthor(String author) { this.author.set(author); }
    public void setIsbn(String isbn) { this.isbn.set(isbn); }
    public void setCategory(String category) { this.category.set(category); }
    public void setPublisher(String publisher) { this.publisher.set(publisher); }
    public void setYear(int year) { this.year.set(year); }
    public void setTotalCopies(int totalCopies) { this.totalCopies.set(totalCopies); }
    public void setAvailableCopies(int availableCopies) { this.availableCopies.set(availableCopies); }
    public void setDescription(String description) { this.description.set(description); }
    public void setStatus(String status) { this.status.set(status); }
    
    /**
     * Checks if the book is available for borrowing
     */
    public boolean isAvailable() {
        return getAvailableCopies() > 0 && "Available".equalsIgnoreCase(getStatus());
    }
    
    /**
     * Gets the borrowing rate as percentage
     */
    public double getBorrowingRate() {
        if (getTotalCopies() == 0) return 0.0;
        return ((double) (getTotalCopies() - getAvailableCopies()) / getTotalCopies()) * 100;
    }
    
    @Override
    public String toString() {
        return String.format("%s by %s (%d)", getTitle(), getAuthor(), getYear());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return getId().equals(book.getId());
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}