package container;

public class Neuron {
	private static double minWeightValue;
	private static double maxWeightValue;
	private double[] weights;
	private double gradient;
	private double bias;
	private double value;

	// Constructor

	public Neuron(double[] weights, double bias) {
		setWeights(weights);
		setBias(bias);
		this.gradient = 0;
		this.value = 0;
	}

	public Neuron(double value) {
		setValue(value);
		this.bias = -1;
		this.gradient = -1;
		this.weights = null;
	}

	// Getters & Setters

	public static double getMinWeightValue() {
		return minWeightValue;
	}

	public static double getMaxWeightValue() {
		return maxWeightValue;
	}

	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

	public double getGradient() {
		return gradient;
	}

	public void setGradient(double gradient) {
		this.gradient = gradient;
	}

	public double getBias() {
		return bias;
	}

	public void setBias(double bias) {
		this.bias = bias;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	// Method

	public static void setRangeWeight(double min, double max) {
		minWeightValue = min;
		maxWeightValue = max;
	}

}
