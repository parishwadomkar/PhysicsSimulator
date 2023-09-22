package bouncing_balls;

/**
 * The physics model.
 * 
 * This class is where you should implement your bouncing balls model.
 * 
 * The code has intentionally been kept as simple as possible, but if you wish, you can improve the design.
 * 
 * @author Simon Robillard
 *
 */
class Model {

	double areaWidth, areaHeight;
	static double gravity = 9.81;
	Ball [] balls;

	Model(double width, double height) {
		areaWidth = width;
		areaHeight = height;
		
		// Initialize the model with a few balls
		balls = new Ball[2];
		balls[0] = new Ball(width / 3, height * 0.9, 1.2, 1.6, 0.2);
		balls[1] = new Ball(2 * width / 3, height * 0.7, -0.6, 0.6, 0.1);
	}

	void step(double deltaT) {
		// TODO this method implements one step of simulation with a step deltaT
		for (int i = 0; i < balls.length; i++) {
            Ball a = balls[i];
			// detect collision with the border
			if (a.x < a.radius) {
                a.x = a.radius;
                a.vx *= -1;
                // Check if the ball's x position has gone past the right boundary.
            } else if (a.x > areaWidth - a.radius) {
                a.x = areaWidth - a.radius;
                a.vx *= -1;
            }
            if (a.y < a.radius) {
                a.y = a.radius;
                a.vy *= -1;
            } else if (a.y > areaHeight - a.radius) {
                a.y = areaHeight - a.radius;
                a.vy *= -1;
            }
			
			a.vy-=gravity*deltaT;
			a.x += deltaT * a.vx;
			a.y += deltaT * a.vy;

			for (int j = i + 1; j < balls.length; j++) {
                Ball b = balls[j];
                double dx = a.x - b.x;
                double dy = a.y - b.y;
                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < a.radius + b.radius) {
                    
                    double angle = Math.atan2(dy, dx);
                    double velaBefore = a.vx * Math.cos(angle) + a.vy * Math.sin(angle);
                    double velbBefore = b.vx * Math.cos(angle) + b.vy * Math.sin(angle);

                    // Assuming  equal mass
                    double velaAfter = velbBefore;
                    double velbAfter = velaBefore;

                    // Update velocities
                    a.vx += (velaAfter - velaBefore) * Math.cos(angle);
                    a.vy += (velaAfter - velaBefore) * Math.sin(angle);
                    b.vx += (velbAfter - velbBefore) * Math.cos(angle);
                    b.vy += (velbAfter - velbBefore) * Math.sin(angle);
                }
            }
		}
	}
	
	/**
	 * Simple inner class describing balls.
	 */
	class Ball {
		
		Ball(double x, double y, double vx, double vy, double r) {
			this.x = x;
			this.y = y;
			this.vx = vx;
			this.vy = vy;
			this.radius = r;
		}

		/**
		 * Position, speed, and radius of the ball. You may wish to add other attributes.
		 */
		double x, y, vx, vy, radius;
	}
}