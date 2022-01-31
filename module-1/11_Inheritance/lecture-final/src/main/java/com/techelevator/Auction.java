package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid; //Auction has-a Bid
	private List<Bid> allBids; //Auction has-a list of bids

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid); //add the bid to the list of all the bids
		boolean isCurrentWinningBid = false;//assume the new bid is not the highest
		//if the new bid amount is higher than the current high bid amount
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid; //then set teh current high bid to the new bid
			isCurrentWinningBid = true; //and udpat teh bool
		}
		return isCurrentWinningBid;//return true if the new bid is the new highest
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
