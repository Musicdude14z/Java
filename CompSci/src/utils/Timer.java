package utils;

public class Timer implements Comparable<Timer>{
	
	private long lastStart, totalTime;
	private boolean running = false;
	
	public void start() {
		if(running) return;
		running = true;
		lastStart = System.nanoTime();
	}
	
	public void stop() {
		if(!running) return;
		totalTime += System.nanoTime() - lastStart;
		running = false;
	}
	
	public long getTime() {
		return totalTime + (running ? System.nanoTime()-lastStart : 0);
	}
	
	public void reset() {
		running = false;
		totalTime = 0;
	}
	
	public boolean equals(Timer t) {
		return this.getTime() == t.getTime();
	}
	
	public String toString() {
		return "Time: " + getTime() + "ns\n" + (running ? "Is Running..." : "Is Not Running.");
	}

	public int compareTo(Timer t) {
		return (int)(this.getTime() - t.getTime());
	}
	
}
