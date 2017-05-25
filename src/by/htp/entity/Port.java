package by.htp.entity;

import java.util.ArrayList;
import java.util.List;

import static by.htp.util.ConstantValue.*;

public class Port {
	private int maxCargo = TOTAL_CARGO_BY_POTR;
	private volatile int cargo;
	private List<Integer> terminal;

	public int getMaxCargo() {
		return maxCargo;
	}

	public void setMaxCargo(int maxCargo) {
		this.maxCargo = maxCargo;
	}

	public Port() {
		terminal = new ArrayList();
		for (int i = 0; i < NUMBER_OF_TERMINAL; i++) {
			terminal.add(0);
		}
		cargo = /*TOTAL_CARGO_BY_POTR / 2 + */(int) (Math.random() * TOTAL_CARGO_BY_POTR / 2);
		System.out.println("Cargo by port=" + cargo);
	}

	public int size() {
		return terminal.size();

	}

	public int getById(int i) {

		return terminal.get(i);
	}

	public void setInt(int index, int i) {
		terminal.set(index, i);
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public List<Integer> getTerminal() {
		return terminal;
	}

	public void setTerminal(List<Integer> terminal) {
		this.terminal = terminal;
	}
	public void cargoUp(){
		cargo++;
	}
	public void cargoDown(){
		cargo--;
	}
	@Override
	public String toString() {
		return "Port [cargo=" + cargo + ", terminal=" + terminal + "]";
	}

}
