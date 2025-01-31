package logic.task;

import java.util.ArrayList;

import interfaces.Duplicatable;

public class TaskManager {
	public static ArrayList<Task> getTaskByType(ArrayList<Class> types) {
		// TODO implement this method

		ArrayList<Task> returnTasks = new ArrayList<Task>();

		for (Task task : TaskList.getTasks()) {
			for (Class type : types) {
				if (type.isInstance(task) && !returnTasks.contains(task)) {
					returnTasks.add(task);
				}
			}
		}
		
		// Class type : types
		// Task task : TaskList.getTasks()

		return returnTasks;
	}

	public static void deleteDuplicateTasks() {
		// TODO implement this method

		ArrayList<Task> tasks = TaskList.getTasks();
		
		ArrayList<Task> resultTasks = new ArrayList<Task>();

		for (int i = tasks.size() - 1; i >= 0; i--) {
			if (tasks.get(i) instanceof Duplicatable && tasks.get(i).toString().contains("-")) {
				tasks.remove(i);
			}
		}
		tasks = resultTasks;

	}

	public static boolean instanceOf(Class checkClass, Class interfaceClass) {
		return interfaceClass.isAssignableFrom(checkClass);
	}
}
