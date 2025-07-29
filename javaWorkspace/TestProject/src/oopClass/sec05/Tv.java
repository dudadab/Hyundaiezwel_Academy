package oopClass.sec05;

public class Tv {
	String color;
	boolean power;
	int channel;
	
	// Tv 기능
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}
