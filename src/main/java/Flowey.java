import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Flowey - a robot by Aleksandra
 */
public class Flowey extends Robot {
	int turnDirection = 1;

	/**
	 * run: Flowey's default behavior
	 */
	public void run() {
		setColors(Color.white, Color.black, Color.pink); // body, gun, radar

		// Robot main loop
		while (true) {
			turnRight(turnDirection * 180);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		turnDirection = e.getBearing() >= 0 ? 1 : -1;
		turnRight(e.getBearing());
		fire(Rules.MAX_BULLET_POWER);
		ahead(e.getDistance() + 5);
	}

	/**
	 * onHitRobot: What to do when you hit a robot
	 */
	public void onHitRobot(HitRobotEvent e) {
		turnDirection = e.getBearing() >= 0 ? 1 : -1;
		fire(Rules.MAX_BULLET_POWER);
		ahead(50);
	}
}
