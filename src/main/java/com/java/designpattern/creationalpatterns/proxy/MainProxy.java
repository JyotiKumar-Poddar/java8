package com.java.designpattern.creationalpatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * 
 * Create a "wrapper" for a remote, or expensive, or sensitive target
 * Encapsulate the complexity/overhead of the target in the wrapper
 * The client deals with the wrapper
 * The wrapper delegates to the target
 * To support plug-compatibility of wrapper and target, create an interface
 * 
 * Ref:http://www.oodesign.com/proxy-pattern.html
 * @author jyotipoddar
 *
 */

public class MainProxy {

	public static void main(String[] args) {
		PrintMessageImpl printMessage = new PrintMessageImpl();

		PrintMessage proxy = (PrintMessage) Proxy.newProxyInstance(
				PrintMessageImpl.class.getClassLoader(), printMessage.getClass()
						.getInterfaces(), new ProxyInvocationHandler(
						printMessage));
		proxy.printAllMessage();

	}

}
