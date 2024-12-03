# Terminoledgy

## Inheritance

It is the mechanism in Java by which one class is allowed to inherit the features(fields and methods) of another class.

### Why Do Ee Use This?

It makes our code more flexible and reusable. By defining a base class, we can define common properties and methods that can be used in any class that inherits from it.

How does this work:

Lets say we have class A:

class A {
    int a;
    float b;

    public A() {}

    public void MethodA() {}
    public void MethodB() {}
}

Then we create a clss B that inherits from class A:

class B : A {
    double c;

    public B() {}

    public void MethodC() {}
}

When you create an instance of class B, the instance will have access to all methods and properties from both classes.
For example:

B instanceOfB = new B();

// b will have the following methods
InstanceOfB.MethodA();
InstanceOfB.MethodB();
InstanceOfB.MethodC();

## Singleton

A singleton is a pattern that ensures that only one instance of a given class exists at a time. For the command base programming, all subsystems are treated as singletons.
If there are interests in understanding singleton please see our old lessons here: https://docs.google.com/presentation/d/1PSpcwglfaODJcTwd1MU18RACXyjMkejqbN1AfeUvZGc/edit?usp=sharing

# RomiProject

This project is a gutted example project for the Romi. A Romi is a small robot designed by first that allows the use of the WPILIB to control. We will use this project to teach the concepts of the command base design.

## Understand the code layout

Look under src/java, you will find the following:

- commands
-- folder where your commands file will live
-subsystems
-- This folder is used to store any subsystems you may need
- Main.java
-- Just like in the java applications used in previous lessons, this is where teh main loop is. (You should never touch this file!!!)
- Robot.java
-- Defines the varous methods used by the command base desine to run varous states of a match. (This file should rarely be touch, but may need to for certain functionality.) Some methods defined here:
-- teleop
-- autonomous
-- periodic functions
- RobotContainer
-- This is where most of our work will go for both this project and our main robot code.

## Create drive subsystem

- Create a new java file in subsystems call Drivetrain.java
- Change public class Drivetrain to public Class Drivetrain extends SubsystemBase
-- May need to do a quick fix to import the right definition for SubsystemBase
- add at the top of your file under package line:
-- import edu.wpi.first.wpilibj.Spark;
-- import edu.Encoder;
-- import frc.robot.sensors.RomiGyro;
- Add two properties to class for each motor like:
-- private final Spark m_leftMotor = new Spark(0);
-- private final Spark m_rightMotor = new Spark(1);
- Add two properties to class for each encoder like:
-- private final Encoder  m_leftEncoder = new SparkeNCODER(4, 5);
-- private final Encoder  m_leftEncoder = new SparkeNCODER(6, 7);
- Create private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
-- You may need to do a quick fix to import correct class definition
- Create private final RomiGyro m_gyro = new RomiGyro();
- create private final BuiltInAcceleraometer m_acceleraometer = new BuiltInAccelerometer();
- create constructor for Drivetrain.java and do the following:
-- Make right motor inverted
-- Set Encoder Distance Per Pulse
-- Counts Per Revolutions = 1440.0
-- Wheel Diameter In Inch = 2.75591
-- Distance per rotation = (PI * WheelDiameter)/CountsPerRev
-- Reset encoders
- create a method
-- arcadeDrive
--- Args: X-AxisSpeed, Y-AxisSpeed
--- Call arcadeDrive from DifferentialDrive attributes.

Project ToDo:

Drive Subsystem:
    Attributes
        Two motors
            For each motor
                Spark - Motor controller
                    Ids 0, 1
            Encoder - Encoder controller
                    Left Ids A: 4, B: 5
                    Right Ids A: 6, B: 7
        DifferentialDrive 
            Requires spark motor controllers
        RomiGyro (utilize Gyro class in project) - returns given position
        BuiltInAccelerometer - returns acceleration in a given direction
    Initialization
        Make right motor inverted
        Set Encoder Distance Per Pulse
            Counts Per Revolutions = 1440.0
            Wheel Diameter In Inch = 2.75591
            Distance per rotation = (PI * WheelDiameter)/CountsPerRev
        Reset encoders
    Methods needed
        arcadeDrive
            Args: X-AxisSpeed, Y-AxisSpeed
            Call arcadeDrive from DifferentialDrive attributes.
Commands
    Utilize IO Class in project
    Command to drive robot with input
    Command to drive robot automatically
    Command of your choice
