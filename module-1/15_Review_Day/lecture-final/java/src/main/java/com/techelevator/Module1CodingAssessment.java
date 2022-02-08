package com.techelevator;

import com.techelevator.interfaceexample.Bicycle;
import com.techelevator.interfaceexample.Book;
import com.techelevator.interfaceexample.Car;
import com.techelevator.interfaceexample.Sellable;

import java.util.ArrayList;
import java.util.List;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		//i need a list of things in my shopping cart on amazon
		List<Sellable> myCart = new ArrayList<>();
		myCart.add(new Bicycle());
		myCart.add(new Book());
		//myCart.add(new Car());


		//quiz scores
		List<Double> quizScore;

		// TODO Auto-generated method stub
		FlowerShopOrder valentinesDay = new FlowerShopOrder("Valentines Day",12);

		System.out.println("the subtotal price is "+valentinesDay.getSubtotal());

	}
	public static boolean testReturnsTrue(){
		return true;
	}
	public boolean testNonStaticReturnsTrue(){
		return true;
	}

}
