package ch3_231024.package1;

public class CarVO {
	private int speed;
	private boolean stop;

	public int getSpeed() {
		System.out.println("speed: " + speed);
		return speed + 10;
	}

	public void setSpeed(int speed) {
		this.speed = speed - 5;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
