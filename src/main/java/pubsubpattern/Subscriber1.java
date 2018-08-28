package pubsubpattern;

public class Subscriber1 implements Subscriber {
	@Override
	public boolean update(String message) {
		System.out.println("Subscriber1 processing message: " + message);
		return true;
	}
}
