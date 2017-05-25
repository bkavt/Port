package by.htp.entity;


import static by.htp.util.ConstantValue.*;
import java.util.ArrayList;

public class Ship implements Runnable {
	private Port port;
	private int maxCargo;
	private volatile int cargo;
	private int loadingCargo;
	private static int num;
	private int id;

	static {num=10;}
	public Ship(Port port) {
		this.port=port;
		maxCargo=TOTAL_CARGO_BY_SHIP;
		cargo = TOTAL_CARGO_BY_SHIP / 2 + (int) (Math.random() * TOTAL_CARGO_BY_SHIP / 2);	
		loadingCargo= (int) (Math.random() * TOTAL_CARGO_BY_SHIP);
		id=num;
		num++;
	}


	@Override
	public void run() {
		int status=0;
		while (status==0){
			for(int i=0; i<port.size();i++){
				if(port.getById(i)==0&&status==0){
					port.setInt(i, id);
					status++;
					System.out.println("1Shipid=" + id+" [port=" + port + ", maxCargo=" + maxCargo + ", cargo=" + cargo + ", loadingCargo=" + loadingCargo
							+ ",  + ");
					/*Thread loaderOut = new Thread(new LoaderOut(port, cargo));
					loaderOut.start();
					Thread loaderIn = new Thread(new LoaderIn(port, cargo, loadingCargo, maxCargo));
					loaderIn.start();*/
					int j = cargo;
					
					while (j >0) {
						int a=port.getCargo();
						int b=port.getMaxCargo();
						//if (a<b) {
					
							cargo--;
							j--;
							port.cargoUp();
							//System.out.println("id"+id+" cargo "+cargo + "port cargo "+port.getCargo());	
					/*}
						 else {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}*/
					}
					System.out.println("2Shipid=" + id+" [port=" + port + ", maxCargo=" + maxCargo + ", cargo=" + cargo + ", loadingCargo=" + loadingCargo
							+ ",  + ");
					while (loadingCargo>0){
						
					//	if(maxCargo>cargo&&port.getCargo()>0){
						cargo++;
						loadingCargo--;
						//System.out.println(" out id"+id+" cargo "+cargo + " port cargo "+port.getCargo()+" last^" +loadingCargo);
						port.cargoDown();
						//}
					/*	else{
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}*/
					}
					
					
					
					
					System.out.println("3Shipid=" + id+" [port=" + port + ", maxCargo=" + maxCargo + ", cargo=" + cargo + ", loadingCargo=" + loadingCargo
				);
					//if("TERMINATED".equals(loaderIn.getState())&&"TERMINATED".equals(loaderOut.getState())){
						status=1;
						port.setInt(i, 0);}
				//	}
						
			}
			
		
		}
		
	}


	@Override
	public String toString() {
		return "Shipid=" + id+" [port=" + port + ", maxCargo=" + maxCargo + ", cargo=" + cargo + ", loadingCargo=" + loadingCargo
				+ ",  + ";
	}


	


	
	

	
	
}
