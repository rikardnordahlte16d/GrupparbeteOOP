package model;
public class Ferry extends Vehicle {

	CarLoader carLoader;
	public Ferry() {
		carLoader = new CarLoader(carAmount);
		carLoader.firstOut = true;
	}

	

}
