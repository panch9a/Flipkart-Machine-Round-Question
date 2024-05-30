import Entity.AuctionEnity;
import Entity.BidEntity;
import Service.AuctionServices;
import Service.BidServices;
import Service.BuyerService;
import Service.SellerService;

import java.util.Scanner;

public class FlipkartMachineRoundInterviewSampleApplication {

    public static void main(String[] args) {
        BuyerService buyerService = new BuyerService();
        SellerService sellerService = new SellerService();
        AuctionServices auctionService = new AuctionServices();
        BidServices bidService = new BidServices();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (or type EXIT to quit):");
            String inp = sc.nextLine();

            if (inp.equalsIgnoreCase("EXIT")) {
                break; // Exit the loop if the input is "EXIT"
            }

            String[] inpArr = inp.split(" ");
            switch (inpArr[0]) {
                case "ADD_BUYER": {
                    buyerService.addBuyer(inpArr[1]);
                    break;
                }
                case "ADD_SELLER": {
                    sellerService.addSeller(inpArr[1]);
                    break;
                }
                case "CREATE_AUCTION": {
                    AuctionEnity auctionEnity = new AuctionEnity();
                    auctionEnity.setAuctionName(inpArr[1]);
                    auctionEnity.setMinbid(Integer.parseInt(inpArr[2]));
                    auctionEnity.setMaxbid(Integer.parseInt(inpArr[3]));
                    auctionEnity.setSellerName(inpArr[4]);
                    auctionEnity.setActive(true);
                    auctionService.createAuction(auctionEnity);
                    break;
                }
                case "CREATE_BID": {
                    BidEntity bidEntity = new BidEntity();
                    bidEntity.setBuyerName(inpArr[1]);
                    bidEntity.setBid(Integer.parseInt(inpArr[2]));
                    bidEntity.setAuctionName(inpArr[3]);
                    bidService.createBid(bidEntity);
                    break;
                }
                case "UPDATE_BID": {
                    BidEntity bidEntity = new BidEntity();
                    bidEntity.setBuyerName(inpArr[1]);
                    bidEntity.setBid(Integer.parseInt(inpArr[2]));
                    bidEntity.setAuctionName(inpArr[3]);
                    bidService.updateBid(bidEntity);
                    break;
                }
                case "WITHDRAW_BID": {
                    BidEntity bidEntity = new BidEntity();
                    bidEntity.setBuyerName(inpArr[1]);
                    bidEntity.setAuctionName(inpArr[2]);
                    bidService.withdrawBid(bidEntity);
                    break;
                }
                case "CLOSE_AUCTION": {
                    AuctionEnity auctionEnity = new AuctionEnity();
                    auctionEnity.setAuctionName(inpArr[1]);
                    auctionService.closeAuction(auctionEnity);
                    break;
                }
                default:
                    System.out.println("Unknown command");
            }
        }
        sc.close(); // Close the Scanner to free resources
        System.out.println("Application terminated.");
    }
}