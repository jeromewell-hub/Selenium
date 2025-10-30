package org.git;

public class Simple {
	public Simple() {
		System.out.println("Changes1");
	}

	public Simple(int id) {
		this();
		System.out.println(id);
	}

	public static void main(String[] args) {
		Simple simple = new Simple(10);
	}
}
