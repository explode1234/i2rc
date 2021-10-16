// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TimeDrive extends CommandBase {
  /** Creates a new TimeDrive. */

  DriveTrain Drt;
  Timer Tmr;
  boolean done = false;

  public TimeDrive(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    Drt = dt;
    Tmr = new Timer();
    addRequirements(Drt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Tmr.start();
    Tmr.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Tmr.get() <= 5){
      System.out.println(Tmr.get());
      Drt.tankDrive(0.8, 0.8);
    }
    else{
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
