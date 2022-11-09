# RomiProject

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
