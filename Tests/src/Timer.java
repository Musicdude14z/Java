
public class Timer {
	
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
	
	public String toString() {
		return "Time: " + getTime() + "ns\n" + (running ? "Is Running..." : "Is Not Running.");
	}
	
}
