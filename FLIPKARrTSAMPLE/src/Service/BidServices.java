package Service;

import Entity.AuctionEnity;
import Entity.BidEntity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class BidServices {
    public static ArrayList<BidEntity> bidEntities =new ArrayList<>();

    public void createBid(BidEntity bidEntity) {
        Optional<BidEntity> existingEntity;
        existingEntity = bidEntities.stream().filter(a -> a.getBuyerName().equalsIgnoreCase(bidEntity.getBuyerName())).findAny();
        Optional<AuctionEnity> auction;
        auction = AuctionServices.auctionEnityArrayList.stream().filter(a -> a.getAuctionName().equalsIgnoreCase(bidEntity.getAuctionName())).findAny();
        if (!(existingEntity.isPresent() && (Objects.equals(existingEntity.get().getBuyerName(), bidEntity.getBuyerName())) && (Objects.equals(existingEntity.get().getBid(), bidEntity.getBid())))) {
            if (BuyerService.buyerList.contains(bidEntity.getBuyerName())) {
                if (auction.isPresent()) {
                    if (bidEntity.getBid() <= auction.get().getMaxbid()) {
                        bidEntities.add(bidEntity);
                    }
                    else {
                        System.out.println("failed as highest bid limit is "+auction.get().getMaxbid());
                    }
                }
            }
        }
    }

    public void updateBid(BidEntity bidEntity) {
        Optional<AuctionEnity> auction;
        auction=  AuctionServices.auctionEnityArrayList.stream().filter(a ->a.getAuctionName().equalsIgnoreCase(bidEntity.getAuctionName())).findAny();
        Optional<BidEntity> updatedEntity;
        updatedEntity=  bidEntities.stream().filter(a ->a.getAuctionName().equalsIgnoreCase(bidEntity.getAuctionName())).findAny();
        if(BuyerService.buyerList.contains(bidEntity.getBuyerName())) {
            if (updatedEntity.isPresent()) {
                if (bidEntity.getBid()<=auction.get().getMaxbid()) {
                    updatedEntity.get().setBid(bidEntity.getBid());
                }
                else {
                    System.out.println("failed as highest bid limit is "+auction.get().getMaxbid());
                }
            }
        }
    }

    public void withdrawBid(BidEntity bidEntity) {
        Optional<BidEntity> removeBidEntity;
        removeBidEntity =  bidEntities.stream().filter(a ->a.getBuyerName().equalsIgnoreCase(bidEntity.getBuyerName())&&  a.getAuctionName().equalsIgnoreCase(bidEntity.getAuctionName() )).findAny();
        removeBidEntity.ifPresent(entity -> bidEntities.remove(entity));
    }
}


