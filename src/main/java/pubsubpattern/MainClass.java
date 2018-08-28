package pubsubpattern;

public class MainClass {
	public static void main(String[] args) {
		Broker br = Broker.getInstance();
		Subscriber sub1 = new Subscriber1();
		Subscriber sub2 = new Subscriber2();
		Publisher pub1 = new Publisher1(br);
		br.register("topic1", sub1);
		br.register("topic2", sub2);
		pub1.publish("topic2", "Hello, hi there");
	}
}
