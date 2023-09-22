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
		for (Ball b : balls) {
			// detect collision with the border
            		// Check if the ball's x position is less than its radius (i.e., it's touching or has gone past the left boundary).
           		if (b.x < b.radius) {
                		b.x = b.radius;
                		b.vx *= -1;
                		// Check if the ball's x position has gone past the right boundary.
            		} else if (b.x > areaWidth - b.radius) {
               			b.x = areaWidth - b.radius;
                		b.vx *= -1;
            		}
            		if (b.y < b.radius) {
                		b.y = b.radius;
                		b.vy *= -1;
            		} else if (b.y > areaHeight - b.radius) {
               			b.y = areaHeight - b.radius;
                		b.vy *= -1;
            		}

			// Apply gravity
			b.vy -= gravity * deltaT;

			// Compute new position according to the speed of the ball
			b.x += deltaT * b.vx;
			b.y += deltaT * b.vy;

			// Handle Collisions between Balls
			for (int i = 0; i < balls.length; i++) {
				for (int j = i + 1; j < balls.length; j++) {
					Ball b1 = balls[i];
					Ball b2 = balls[j];
	
					// For Vector from the center of ball 1 to the center of ball 2
					double dx = b2.x - b1.x;
					double dy = b2.y - b1.y;
	
					// For distance between the centers of the two balls
					double distance = Math.sqrt(dx * dx + dy * dy);
	
					// Check if the balls are colliding (if distance is less than the sum of their radii)
					if (distance < b1.radius + b2.radius) {
						// Collision has occurred -response
						// Calculate the normal vector of the collision
						double normalX = dx / distance;
						double normalY = dy / distance;
	
						// Calculate the relative velocity of the two balls before the collision
						double relativeVx = b1.vx - b2.vx;
						double relativeVy = b1.vy - b2.vy;
	
						// Calculate the relative velocity along the normal vector
						double relativeVelocity = relativeVx * normalX + relativeVy * normalY;
	
						// Calculate the impulse (change in momentum)
						double impulse = (2.0 * relativeVelocity) / (1.0 / b1.radius + 1.0 / b2.radius);
	
						// Update the velocities of both balls
						b1.vx -= impulse / b1.radius * normalX;
						b1.vy -= impulse / b1.radius * normalY;
						b2.vx += impulse / b2.radius * normalX;
						b2.vy += impulse / b2.radius * normalY;
	
						// Ensure the balls don't overlap
						double overlap = b1.radius + b2.radius - distance;
						double moveX = normalX * overlap / 2.0;
						double moveY = normalY * overlap / 2.0;
						b1.x -= moveX;
						b1.y -= moveY;
						b2.x += moveX;
						b2.y += moveY;
					}
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
