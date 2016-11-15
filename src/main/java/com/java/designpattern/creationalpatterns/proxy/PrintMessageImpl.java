package com.java.designpattern.creationalpatterns.proxy;

public class PrintMessageImpl implements PrintMessage {

	@Override
	public void printAllMessage() {

		for (int i = 0; i < 10000000; i++) {
			if (i == 99999999) {
				System.out.println("End of this message");
			}
		}

	}

}
