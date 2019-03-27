 package model;

public class Main {
	public static void main(String[] args) {
		ScaniaS730 s = new ScaniaS730(5);
		Volvo740 v = new Volvo740();
		Saab95 s95 = new Saab95();
		s.getCarLoader().addVehicleToLift(v);
		s.flatbed.setTruckBed(true);
		s.getCarLoader().removeVehicles();
		for (Vehicle vehicle : s.getCarLoader().getVehicles()) {
			System.out.println(vehicle.getModelName());
		}
	}
}
