package com.auctionapp.demo.repository;

import java.util.Optional;

// AuctionItemRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

import com.auctionapp.demo.models.AuctionItem;

public interface AuctionItemRepository extends MongoRepository<AuctionItem, String> {

    Optional<AuctionItem> findById(String id);
}
