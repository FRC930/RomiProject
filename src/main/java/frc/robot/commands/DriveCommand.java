package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends Command {

    private double m_speed;
    private Drivetrain m_drive;

    public DriveCommand(double speed, Drivetrain drive ){
        m_speed = speed;
        m_drive = drive;
        addRequirements(m_drive);
    }
    @Override
    public void execute(){
        m_drive.drive(m_speed, 0.0 );
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
