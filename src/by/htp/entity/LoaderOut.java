package by.htp.entity;

public class LoaderOut implements Runnable {
	private Port port;
	private int cargo;

	public LoaderOut(Port port, int cargo) {
		this.port = port;
		this.cargo = cargo;
	}

	@Override
	public void run() {
		int j = cargo;
		while (j > 0) {
			if (port.getCargo() < port.getMaxCargo()) {
				cargo--;
				j--;
				port.cargoUp();
			} else {
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
