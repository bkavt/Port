package by.htp.domain;

import by.htp.entity.LoaderOut;
import by.htp.entity.Port;
import by.htp.entity.Ship;

public class Main {

	public static void main(String[] args) {
		
		Port port=new Port();
		System.out.println(port);
		port.cargoDown();
		System.out.println(port);
		for (int i=0;i<10;i++){
			Thread ship = new Thread(new Ship(port));
			ship.start();
			System.out.println("New ship: "+ship.getState() );
			
		}

	}

}
