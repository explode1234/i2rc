// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TurnAngle extends CommandBase {
  /** Creates a new TurnAngle. */
  private DriveTrain Drt;
  private double angle;
  private double speed;

  public TurnAngle(DriveTrain dt, double angle, double speed, double distance) {
    Drt = dt;
    this.angle = angle;
    this.speed = speed;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Drt.navxReset();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (angle < 0){
      Drt.tankDrive(-speed , speed);

    }
    else if(angle>0){
      Drt.tankDrive(speed,-speed);

    }else{
      Drt.tankDrive(0,0);
    }
  

    }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Drt.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return Math.abs(Drt.getAngle()) >= Math.abs(angle);
  }
}
