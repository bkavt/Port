package by.htp.entity;

public class LoaderIn implements Runnable{
	private Port port;
	private int cargo;
	private int maxCargo;
	private int loadingCargo;

	public LoaderIn(Port port, int cargo, int maxCargo, int loadingCargo) {
		this.port = port;
		this.cargo = cargo;
		this.maxCargo = maxCargo;
		this.loadingCargo=loadingCargo;
	}

	@Override
	public void run() {
		while (loadingCargo>0){
			if(maxCargo>cargo&&port.getCargo()>0){
			loadingCargo--;
			cargo++;
			port.cargoDown();}
			else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
