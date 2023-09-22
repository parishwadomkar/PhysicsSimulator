# Bouncing Balls Simulation

## Overview
This project is a simple Java-based simulation of bouncing balls in a 2D rectangular space under the influence of gravity. The goal of this exercise is to model the physics of balls moving within an enclosed area, detecting collisions with the walls, and handling collisions between balls. The simulation utilizes Euler's method to approximate the movement of the balls over time.

## Features
Collision Detection with Walls: The code includes functionality to detect collisions between balls and the boundaries of the simulation area. When a ball reaches or crosses a boundary, it reverses its velocity to simulate bouncing.
*Animation*
Click here [![Watch the animation]([image](https://github.com/parishwadomkar/PhysicsSimulator/blob/main/Animation.png?raw=true))]([animation_video](https://github.com/parishwadomkar/PhysicsSimulator/raw/main/Animation.mp4)) to watch the animation in action.

*Collision Handling Between Balls*: The simulation also accounts for collisions between balls. When two balls collide, their velocities are adjusted to conserve momentum and kinetic energy, ensuring a realistic physics-based interaction.

*Gravity Simulation*: The simulation incorporates gravity by reducing the vertical velocity of each ball at each time step. This creates a gravity-like effect, causing the balls to move downward over time.

*Simple and Extendable*: The code is intentionally kept simple for educational purposes. However, it can serve as a foundation for more complex simulations or games involving bouncing objects.

## How to Use
To run the simulation, follow these steps:
- Clone the repository to your local machine.
- Compile the Java code using the command: javac bouncing_balls/*.java
- Run the simulation with the command: java bouncing_balls.Animator
You can adjust the simulation parameters, such as the number of balls, their initial positions, velocities, and sizes, in the Model.java file to explore different scenarios.

## Contributing
Contributions and improvements to the code are welcome. If you have ideas for enhancing the simulation or fixing any issues, please feel free to fork the repository, make your changes, and submit a pull request.

## Acknowledgments
The simulation was created as part of an exercise, in collaboration with [DSkretting](https://github.com/DSkretting) and [nnoor96](https://github.com/nnoor96) and is inspired by physics-based simulations commonly used in computer graphics and game development.
