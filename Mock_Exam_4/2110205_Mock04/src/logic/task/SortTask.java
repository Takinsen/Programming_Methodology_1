package logic.task;

import interfaces.Computable;
import interfaces.Modifiable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;

public class SortTask extends Task implements Computable, Modifiable, Parallelizable {

	public SortTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double parallelCompute(ProcessUnit processUnit) {
		// TODO Auto-generated method stub
		return processUnit.parallelCompute(this);
	}

	@Override
	public void modify(int modifyValue) {
		// TODO Auto-generated method stub
		this.mergeTask(modifyValue);
	}

	@Override
	public double compute(ProcessUnit process) {
		// TODO Auto-generated method stub
		return process.compute(this);
	}

	@Override
	public String fullTaskName() {
		// TODO Auto-generated method stub
		return "Sorting Task";
	}
	
	public void mergeTask(int index) {
		Task selectTask = TaskList.getTask(index);
		if(selectTask instanceof SortTask) {
			this.setWorkload(selectTask.getWorkload() + this.getWorkload());
			TaskList.removeTask(index);
		}
	}

}
