package com.techelevator;

/* Reserve Auction is just like a regular auction
   EXCEPT there's a minimum reserve
   and bids less than the reserve are ignored
 */
public class ReserveAuction extends Auction {
    private int minimumReserve;
    public int getMinimumReserve(){return minimumReserve;}

    public ReserveAuction(String itemForSale,int minimumReserve) {
        super(itemForSale);//call the Auction constructor
        this.minimumReserve = minimumReserve; //set the ReserveAuction instance variable
    }

    @Override //override methods to change the behavior in the child
    public boolean placeBid(Bid offeredBid){
        //if the offered bid is >= the reserve then it counts as a bid
        if (offeredBid.getBidAmount() >= minimumReserve){
            //to call a method in the parent that's overridden, use the super keyword
            return super.placeBid(offeredBid);
        }
        //otherwise do nothing - return false it's not the winning bid
        return false;
    }
}
