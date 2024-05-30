package Service;

import Entity.AuctionEnity;
import Entity.BidEntity;

import java.util.*;

public class AuctionServices {

    //AuctionEnity auctionEnity=new AuctionEnity();
    public static ArrayList<AuctionEnity> auctionEnityArrayList =new ArrayList<>();
    public void createAuction(AuctionEnity auctionEnity) {

      if(SellerService.sellerList.contains(auctionEnity.getSellerName())){
            auctionEnityArrayList.add(auctionEnity);
       }
       else{
           throw new RuntimeException("SellerName is not found");
       }
    }
    public void  closeAuction(AuctionEnity auctionEnity) {
         long count1= auctionEnityArrayList.stream().filter(a->a.getAuctionName().equalsIgnoreCase(auctionEnity.getAuctionName())).count();
        if(count1>=1) {
            Optional<AuctionEnity> closeAuctionEntity = Optional.of(new AuctionEnity());
            closeAuctionEntity = auctionEnityArrayList.stream().filter(a -> a.getAuctionName().equalsIgnoreCase(auctionEnity.getAuctionName())).findAny();
            closeAuctionEntity.ifPresent(entity -> entity.setActive(false));
            int previousMaxBid = 0;
            String  buyerName=null;
            List<BidEntity> sortedlist = BidServices.bidEntities.stream().filter(a -> a.getAuctionName().equalsIgnoreCase(auctionEnity.getAuctionName())).sorted(Comparator.comparingInt(BidEntity::getBid).reversed()).toList();
            for (BidEntity bidEntity : sortedlist) {
                if (previousMaxBid == bidEntity.getBid()) {
                    continue;
                } else {
                    long count = sortedlist.stream().filter(b -> b.getBid() == bidEntity.getBid()).count();
                    if (count == 1) {
                         buyerName =bidEntity.getBuyerName();
                        break;
                    }
                    previousMaxBid = bidEntity.getBid();
                }
            }
            if (buyerName != null) {
                System.out.println(buyerName+" as winner");
            }
            else {
                System.out.println("No winner");
            }
        }
        else{
            throw new RuntimeException("Action "+ auctionEnity.getAuctionName()+"  is not found");
        }
    }
}
