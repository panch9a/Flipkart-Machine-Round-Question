package Entity;

public class BidEntity {
    private String buyerName;
    private int bid;
    private String auctionName;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public BidEntity(String buyerName, int bid, String auctionName) {
        this.buyerName = buyerName;
        this.bid = bid;
        this.auctionName = auctionName;
    }

    public BidEntity() {}
}
