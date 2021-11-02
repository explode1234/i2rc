// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class CoderDrive extends CommandBase {
  /** Creates a new TimeDrive. */

  private DriveTrain Drt;
  private boolean done = false;
  private double speed;
  private double distance;

  public CoderDrive(DriveTrain dt, double newSpeed, double newDistance) {
    Drt = dt;
    
    speed = newSpeed;
    distance = newDistance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Drt.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Drt.tankDrive(speed, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Drt.getPosition() >= distance){
        return true;
    }
    else{
      return false;
    }
  }
}
