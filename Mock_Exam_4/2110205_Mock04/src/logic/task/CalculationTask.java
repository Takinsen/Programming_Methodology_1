package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import logic.compute.ProcessUnit;

public class CalculationTask extends Task implements Computable, Modifiable {

	public CalculationTask(String name, double workload) {
		super(name, workload);
	}

	public void changeWorkload(int workload) {
		this.setWorkload(this.getWorkload() + workload);
	}

	@Override
	public String fullTaskName() {
		// TODO Auto-generated method stub
		return "Calculation Task";
	}

	@Override
	public void modify(int modifyValue) {
		// TODO Auto-generated method stub
		this.changeWorkload(modifyValue);

	}

	@Override
	public double compute(ProcessUnit process) {
		// TODO Auto-generated method stub
		return process.compute(this);
	}

}
