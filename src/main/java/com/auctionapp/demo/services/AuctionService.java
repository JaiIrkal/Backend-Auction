package com.auctionapp.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.auctionapp.demo.models.AuctionItem;
import com.auctionapp.demo.repository.AuctionItemRepository;

@Service
public class AuctionService {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemRepository.findAll();
    }

    public AuctionItem createAuctionItem(@RequestBody AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }

    public AuctionItem getAuctionItemById(@PathVariable String id) {
        return auctionItemRepository.findById(id).get();
        // return auctionItemRepository.findById(id).orElse(null);
    }

    public AuctionItem updateAuction(String id, AuctionItem existingItem, double newBid) {
        // AuctionItem existingAuction =
        // auctionItemRepository.findById(auctionRequest.getId()).orElse(null);

        AuctionItem capturedItem = auctionItemRepository.findById(existingItem.getId()).get();
        capturedItem.setCurrentBid(newBid);
        return auctionItemRepository.save(capturedItem);
    }
}
