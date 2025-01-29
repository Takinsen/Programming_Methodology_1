package container;

import function.Function;
import util.Activation;
import util.GenRandom;

public class Layer {
	private static final Exception IllegalArgumentException = null;
	private Neuron[] neurons;
	private Function function;

	public Layer(int inNeurons, int nNeurons, Function function) {
		neurons = new Neuron[nNeurons];

		for (int i = 0; i < nNeurons; i++) {
			double[] weightsArray = new double[inNeurons];

			for (int j = 0; j < inNeurons; j++) {
				weightsArray[j] = GenRandom.randomDouble(Neuron.getMinWeightValue(), Neuron.getMaxWeightValue());
			}

			neurons[i] = new Neuron(weightsArray, GenRandom.randomDouble(0, 1));
		}

		this.function = function;

	}

	public Layer(double[] input) {

		neurons = new Neuron[input.length];

		for (int i = 0; i < input.length; i++) {
			neurons[i] = new Neuron(input[i]);
		}

		this.function = null;

	}

	// Getters & Setters

	public Neuron[] getNeurons() {
		return neurons;
	}

	public void setNeurons(Neuron[] neurons) {
		this.neurons = neurons;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	// Method

	public double applyActivation(double x) {

		if (this.function == Function.RELU) {
			return Activation.relu(x);
		} else if (this.function == Function.SIGMOID) {
			return Activation.sigmoid(x);
		} else if (this.function == Function.TANH) {
			return Activation.tanh(x);
		} else {
			throw new IllegalArgumentException("Unknown activation function: " + this.function);
		}

	}

	public double applyActivationDerivative(double x) {
		if (this.function == Function.RELU) {
			return Activation.reluDerivative(x);
		} else if (this.function == Function.SIGMOID) {
			return Activation.sigmoidDerivative(x);
		} else if (this.function == Function.TANH) {
			return Activation.tanhDerivative(x);
		} else {
			throw new IllegalArgumentException("Unknown activation function: " + this.function);
		}

	}
}
