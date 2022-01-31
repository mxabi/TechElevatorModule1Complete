package com.techelevator;

//Buyout Auction is a special kind of auction
//  1. has a buyout price
//  2. once a bid that's greater than or equal to the buyout prices comes in
//  3. all other bids are ignored
public class BuyoutAuction extends Auction {

    private int buyoutPrice;//default for all nums is 0
    public int getBuyoutPrice(){return buyoutPrice;}

    private boolean buyoutMet; //default is actually false

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
        this.buyoutMet = false;
    }

    @Override
    public boolean placeBid(Bid offeredBid){
        if (buyoutMet){
            //once the buyout has been met, ignore all other bids
            return false; //this is not the winning bid and we're goign to ignore
        } else {
            //we should place teh bid
            boolean isHighBid = super.placeBid(offeredBid);
            //check to see if the offered bid has met the buyout
            if (offeredBid.getBidAmount() >= buyoutPrice){
                buyoutMet = true; //buyout has been met - ignore the rest
            }
            return isHighBid;
        }
    }
}
