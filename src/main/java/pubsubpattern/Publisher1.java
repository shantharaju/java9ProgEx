package pubsubpattern;

public class Publisher1 implements Publisher {
	private final Broker broker;

	public Publisher1(Broker br) {
		broker = br;
	}

	@Override
	public void publish(String topic, String message) {
		broker.publish(topic, message);
	}

}
