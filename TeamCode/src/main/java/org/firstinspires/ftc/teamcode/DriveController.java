package org.firstinspires.ftc.teamcode;
/*
* This code is written assuming the following motor configuration (by index):
*
*     FRONT
*     1---4
*     2---5
*     3---6
*     BACK
*
* */


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveController {
    HardwareMap hwMap;
    public DcMotor motor1;
    public DcMotor motor2;
    public DcMotor motor3;
    public DcMotor motor4;
    public DcMotor motor5;
    public DcMotor motor6;

    public DriveController(HardwareMap hardwareMap) {
        hwMap = hardwareMap;
    }

    public void init() {
        // Left motors
        motor1 = hwMap.get(DcMotor.class, "motor1");
        motor2 = hwMap.get(DcMotor.class, "motor2");
        motor3 = hwMap.get(DcMotor.class, "motor3");
        // Right Motors
        motor4 = hwMap.get(DcMotor.class, "motor4");
        motor5 = hwMap.get(DcMotor.class, "motor5");
        motor6 = hwMap.get(DcMotor.class, "motor6");

        // Forward left motors (might need to be swapped)
        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        motor3.setDirection(DcMotorSimple.Direction.FORWARD);
        // Reverse right motors (might need to be swapped)
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);
        motor5.setDirection(DcMotorSimple.Direction.REVERSE);
        motor6.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set all power to 0 by default
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        motor4.setPower(0);
        motor5.setPower(0);
        motor6.setPower(0);

        // Set encoder mode
        motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor5.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor6.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    // A simple drive function to set the power of both motor arrays at the same time
    public void drive(int leftpower, int rightpower) {
        motor1.setPower(leftpower);
        motor2.setPower(leftpower);
        motor3.setPower(leftpower);

        motor4.setPower(rightpower);
        motor5.setPower(rightpower);
        motor6.setPower(rightpower);
    }
}
