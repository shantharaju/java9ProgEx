package pubsubpattern;

public class Subscriber2 implements Subscriber {
	@Override
	public boolean update(String message) {
		System.out.println("Subscriber2 processing message: " + message);
		return true;
	}
}
