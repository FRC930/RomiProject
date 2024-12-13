package frc.robot.subsystems;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);
    private final Encoder  m_leftEncoder = new Encoder(4, 5);
    private final Encoder  m_rightEncoder = new Encoder(6, 7);
    private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    private final RomiGyro m_gyro = new RomiGyro();
    private final BuiltInAccelerometer m_acceleraometer = new BuiltInAccelerometer();

    public Drivetrain ( int XAxisSpeed, int YAxis){
        this.m_rightMotor.SetInverted(true);
        this.m_leftencoder.setDistancePerPulse((Math.PI * 2.75591)/1440.0);
        this.m_rightencoder.SetDistancePerPulse((Math.PI * 2.75591)/1440.0);

    }
    public void arcadeDrive (double XAxisSpeed, double YAxisSpeed){
        m.diffDrive.aracdeDrive(XAisSpeed, YAxisSpeed);
    }    
}
