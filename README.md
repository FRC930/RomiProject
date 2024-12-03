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

## Override

If a method get the key word @override put above it, then it is allow to be changed when inherited by another class.

For example:

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

    @Override
    public void MethodA() {}
}

Then class B will change what MethodA does.

## lambdas

Lambdas are ways to make temporary methods without defining them. To define a lambda you do the following:

type () -> <add code that calls some function>

example
() -> true
- This defines a method that returns true.

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

## Commands

Commands extend CommandBase which provides the following functions to implement:

- initialize()
-- This method gets called only once when the command is added to schedular.
- execute()
-- This method happens every 20 ms the command is alive
- end()
-- This method happend after the isFinished returns true and only once.
- isFinished()
-- method used to tell when the command is finished

Each of these methods should be setup to be overrided.

When creating a command, all constructors of command should require a subsystem. To do this the addRequirements method must be added to constructor. The subsystem that the class will use should be added the addRequirements call.

## Command Base Reference

For reference to command structure please refer to this: https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html

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

## Create Command

- create command folder next to subsystem folder
- create in comand folder ArcadeDrive.java
- change public class ArcadeDrive to public class ArcadeDrive extends CommandBase
- add the following parameters:
-- private final Drivetrain m_drivetrain;
-- private final Supplier<Double> m_xaxisSpeedSupplier;
-- private final Supplier<Double> m_zaxisRotateSupplier;
- create a constructor and do the following inside it:
-- add the following args:
--- Drivetran drivetrain,
--- Supplier<Double> xaxisSpeedSupplier
--- Supplier<Double> zaxisRotateSuppplier
- Create each method needed by a command:
-- initialize (this returns nothing, has no ars)
-- execute (this returns nothing, has no args)
--- execute should call m_drivetrain.arcadeDrive(x_xaxisSpeedSupplier.get(), z_zaxisSpeedSupplier.get());
-- end (this returns nothing, has one arg: boolean interrupted)
-- isFinished (returns boolean, has one args, should return false)

## Add Subsystem and Command to RobotContainer

- create the following attributes to RobotContainer class
-- private final Drivetrain m_drivetrain = new Drivetrain();drivetrain, () -> -m_controller.getRawAxis(1)
- in configureButtonbindings add the following:
-- m_drivetrain.setDefaultCommand(new ArcadeDrive(m_controller.getRawAxis(1), () -> m_controller.getRawAxis(2)));
