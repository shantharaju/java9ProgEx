package pubsubpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Broker {
	private static final Broker brokerInstance = new Broker();
	private Map<String, Set<Subscriber>> topicToSubscriber = new HashMap<>();
	private Broker() {};
	
	public boolean register(String topic, Subscriber sub) {
		if(topicToSubscriber.containsKey(topic)) {
			Set<Subscriber> subs = topicToSubscriber.get(topic);
			return subs.add(sub);
		}
		else {
			Set<Subscriber> subs = new HashSet<Subscriber>();
			boolean success = subs.add(sub);
			if(success) {
				topicToSubscriber.put(topic, subs);
			}
			return success;
		}
	}
	
	public void publish(String topic, String message) {
		Set<Subscriber> subs = topicToSubscriber.get(topic);
		if(subs != null) {
			subs.forEach(x -> x.update(message));
		}
	}
	
	public static Broker getInstance() {
		return brokerInstance;
	}
}
