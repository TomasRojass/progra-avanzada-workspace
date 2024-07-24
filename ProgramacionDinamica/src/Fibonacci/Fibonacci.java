package Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public int metodoTopDown(int n) {
		return fibonacci(n, new HashMap<Integer, Integer>());
	}

	public int metodoBottomUp(int n) {
		int[] tabla = new int[n + 1];
		tabla[1] = 1;
		for (int i = 2; i < tabla.length; i++) {
			tabla[i] = tabla[i - 1] + tabla[i - 2];
		}
		return tabla[n];
	}

	// Privados

	private int fibonacci(int n, Map<Integer, Integer> mem) {
		int key = n;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		if (n < 2) {
			mem.put(key, n);
		} else {
			mem.put(key, fibonacci(n - 1, mem) + fibonacci(n - 2, mem));
		}
		return mem.get(key);
	}

}
