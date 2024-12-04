package frc.robot.subsystems;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
private final Spark m_leftMotor = new Spark(0);
private final Spark m_rightMotor = new Spark(1);
private final Encoder  m_leftEncoder = new SparkeNCODER(4, 5);
private final Encoder  m_rightEncoder = new SparkeNCODER(6, 7);
private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
private final RomiGyro m_gyro = new RomiGyro();
private final BuiltInAccelerometer m_acceleraometer = new BuiltInAccelerometer();
    
}
