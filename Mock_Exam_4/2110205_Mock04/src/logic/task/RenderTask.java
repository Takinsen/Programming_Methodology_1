package logic.task;

import interfaces.Computable;
import interfaces.Duplicatable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;

public class RenderTask extends Task implements Computable, Parallelizable, Duplicatable {

	public RenderTask(String name, double workload) {
		super(name, workload);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void duplicateTask(int taskNumber) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <= taskNumber ; i++) {
			TaskList.addTasks(new RenderTask(this.getName() + "-" + i,this.getWorkload()));
		}
	}

	@Override
	public double parallelCompute(ProcessUnit processUnit) {
		// TODO Auto-generated method stub
		return processUnit.parallelCompute(this);
	}

	@Override
	public double compute(ProcessUnit process) {
		// TODO Auto-generated method stub
		return process.compute(this);
	}

	@Override
	public String fullTaskName() {
		// TODO Auto-generated method stub
		return "Rendering Task";
	}

}
