package exam_hibernate.utils;

import org.hibernate.Session;

import exam_hibernate.services.CarService;

public class TestDatabase {

	public static void main(String[] args) {
		CarService cs = new CarService();
		for (Object item : cs.getInfoMarques()) {
			System.out.println(item);
		}
	}

}
