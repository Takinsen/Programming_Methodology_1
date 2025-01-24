package container;

public class NeuronDemo {
	private Neuron n;

	public void demonstrate() {
		double[] weights = { 0.2, 0.3, 0.4 };
		n = new Neuron(weights, 0.2);
		Neuron.setRangeWeight(0.1, 0.7);
		n.setGradient(0.6);
		n.setValue(1);
	}

	public Neuron getN() {
		return n;
	}

	public void setN(Neuron n) {
		this.n = n;
	}

}
