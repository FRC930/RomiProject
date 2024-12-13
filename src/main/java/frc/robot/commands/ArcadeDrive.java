package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

import java.security.DomainCombiner;
import java.util.function.Supplier;

public class ArcadeDrive extends Command {
    private final Drivetrain m_drivetrain;
    private final Supplier<Double> m_xaxisSpeedSupplier;
    private final Supplier<Double> m_zaxisRotateSupplier;

    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xaxisSpeedSupplier, Supplier<Double> zaxisRotateSupplier){
      this.m_drivetrain = drivetrain;
      this.m_xaxisSpeedSupplier = xaxisSpeedSupplier;
      this.m_zaxisRotateSupplier = zaxisRotateSupplier;
      addRequirements(drivetrain);
    }
    
    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
        m_drivetrain.arcadeDrive(this.m_xaxisSpeedSupplier.get(), this.m_zaxisRotateSupplier.get());
    }
    @Override
    public void end(boolean interupted){
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
