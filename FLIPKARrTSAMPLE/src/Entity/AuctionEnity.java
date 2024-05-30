package Entity;

public class AuctionEnity {
    private String auctionName;
    private int minbid;
    private int maxbid;
    private String sellerName;
    private boolean  isActive;

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public int getMinbid() {
        return minbid;
    }

    public void setMinbid(int minbid) {
        this.minbid = minbid;
    }

    public int getMaxbid() {
        return maxbid;
    }

    public void setMaxbid(int maxbid) {
        this.maxbid = maxbid;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public AuctionEnity(String auctionName, int minbid, int maxbid, String sellerName ,boolean isActive) {
        this.auctionName = auctionName;
        this.minbid = minbid;
        this.maxbid = maxbid;
        this.sellerName = sellerName;
        this.isActive = isActive;

    }

    public AuctionEnity() {
    }
}
