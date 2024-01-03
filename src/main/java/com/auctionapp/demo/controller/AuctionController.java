package com.auctionapp.demo.controller;

// AuctionController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auctionapp.demo.models.AuctionItem;
import com.auctionapp.demo.repository.AuctionItemRepository;
import com.auctionapp.demo.services.AuctionService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auction")
@CrossOrigin(origins = "http://localhost:3000/")
public class AuctionController {

    // @Autowired
    // private AuctionItemRepository auctionItemRepository;

    // @GetMapping
    // public List<AuctionItem> getAllAuctionItems() {
    // return auctionItemRepository.findAll();
    // }

    // @PostMapping
    // public AuctionItem createAuctionItem(@RequestBody AuctionItem auctionItem) {
    // return auctionItemRepository.save(auctionItem);
    // }

    // @GetMapping("/{id}")
    // public AuctionItem getAuctionItemById(@PathVariable String id) {
    // return auctionItemRepository.findById(id).orElse(null);
    // }

    // @PutMapping("/{id}")
    // public AuctionItem updateAuction(@PathVariable String id, @RequestBody double
    // newBid) {
    // // AuctionItem existingAuction =
    // // auctionItemRepository.findById(auctionRequest.getId()).orElse(null);

    // // if (existingAuction != null) {
    // // existingAuction.setDescription(existingAuction.getDescription());
    // // existingAuction.setName(existingAuction.getName());
    // // existingAuction.setCurrentBid(auctionRequest.getCurrentBid());
    // // return auctionItemRepository.save(existingAuction);
    // // } else {
    // // return null; // Handle not found case
    // // }
    // AuctionItem capturedItem = auctionItemRepository.findById(id).get();
    // capturedItem.setCurrentBid(newBid);
    // return auctionItemRepository.save(capturedItem);
    // }

    @Autowired
    private AuctionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuctionItem createAuctionItem(@RequestBody AuctionItem auctionItem) {
        return service.createAuctionItem(auctionItem);
    }

    @GetMapping
    public List<AuctionItem> getAllAuctionItems() {
        return service.getAllAuctionItems();
    }

    @GetMapping("/{id}")
    public AuctionItem getAuctionItemById(@PathVariable String id) {
        return service.getAuctionItemById(id);
        // return auctionItemRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public AuctionItem updateAuction(@PathVariable String id, @RequestBody AuctionItem auctionItem) {
        double newBid = auctionItem.getCurrentBid();
        return service.updateAuction(id, auctionItem, newBid);
    }
}