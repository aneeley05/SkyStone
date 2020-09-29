package org.firstinspires.ftc.teamcode;
/*
* Authors:
* Andrew
* Tristen
* 
*
* This code is written assuming the following motor configuration (by index):
*
*     FRONT
*     1---3
*     2---4
*     ---
*     BACK
*
* */


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveController {
    HardwareMap hwMap;
    public DcMotor motortl;
    public DcMotor motorbl;
    public DcMotor motortr;
    public DcMotor motorbr;



    public DriveController(HardwareMap hardwareMap) {
        hwMap = hardwareMap;
    }

    public void init() {
        // Left motors
        motortl = hwMap.get(DcMotor.class, "motor1");
        motorbl = hwMap.get(DcMotor.class, "motor2");

        // Right Motors
        motortr = hwMap.get(DcMotor.class, "motor3");
        motorbr = hwMap.get(DcMotor.class, "motor4");

        // Forward left motors (might need to be swapped)
        motortl.setDirection(DcMotorSimple.Direction.FORWARD);
        motorbl.setDirection(DcMotorSimple.Direction.FORWARD);

        // Reverse right motors (might need to be swapped)
        motortr.setDirection(DcMotorSimple.Direction.REVERSE);
        motorbr.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set all power to 0 by default
        motortl.setPower(0);
        motorbl.setPower(0);
        motortr.setPower(0);
        motorbr.setPower(0);


        // Set encoder mode
        motortl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorbl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motortr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorbr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    // A simple drive function to set the power of both motor arrays at the same time
    // TODO: WARNING MAKE SURE THAT MOTOR PAIRS 1+2 and 3+4 ARE SUPPOSED TO TURN IN THE SAME DIRECTION BEFORE TESTING
    public void drive(double leftpower, double rightpower) {
        motortl.setPower(leftpower);
        motorbl.setPower(leftpower);

        motortr.setPower(rightpower);
        motorbr.setPower(rightpower);```
    }
}
