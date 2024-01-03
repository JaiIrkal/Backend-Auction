package com.auctionapp.demo.models;

// AuctionItem.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AuctionItem")
public class AuctionItem {
    @Id
    private String id;

    private String name;
    private String description;
    private double currentBid;

    // Constructors, getters, and setters
    public AuctionItem(String name, String description, double currentBid) {
        this.name = name;
        this.description = description;
        this.currentBid = currentBid;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double d) {
        this.currentBid = d;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentBid=" + currentBid +
                '}';
    }
}
