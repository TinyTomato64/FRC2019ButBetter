package frc.robot.common.components;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveCommand;


public class Drive extends Subsystem{
    private static int LEFT_FRONT_MOTOR = 0;
    private static int LEFT_BACK_MOTOR = 1;
    private static int RIGHT_FRONT_MOTOR = 2;
    private static int RIGHT_BACK_MOTOR = 3;

    private VictorSP rightBackMotor, rightFrontMotor, leftBackMotor, leftFrontMotor;
    
    private SpeedControllerGroup rightDrive, leftDrive;

    private DifferentialDrive diffDrive;

    public Drive(){
        this.rightBackMotor = new VictorSP(RIGHT_BACK_MOTOR);
        this.rightFrontMotor = new VictorSP(RIGHT_FRONT_MOTOR);
        this.leftBackMotor = new VictorSP(LEFT_BACK_MOTOR);
        this.leftFrontMotor = new VictorSP(LEFT_FRONT_MOTOR);

        this.rightDrive = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
        this.leftDrive = new SpeedControllerGroup( leftFrontMotor, leftBackMotor);

        this.diffDrive = new DifferentialDrive(this.leftDrive, this.rightDrive);
    }
    
    public void setTankDrive(double leftInput, double rightInput){
        this.diffDrive.tankDrive(leftInput, rightInput);
    }
    public void setArcadeDrive(double turn, double speed){
        this.diffDrive.arcadeDrive(speed, turn);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand( new DriveCommand());
    }

    public void updateDashboard(){
    
    }
}

