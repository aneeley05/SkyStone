package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ControlInterpreter {
    public double drive;
    public double turn;
    public double lpower = 0;
    public double rpower = 0;
    public double max;
    public double flywheelSpeed = 0;

    DriveController dcontrol;

    public void init(HardwareMap hwMap) {
        // Create an instance of, and initialize the drive controller
        dcontrol = new DriveController(hwMap);
        dcontrol.init();
    }

    public void update(Gamepad controller) {
        // Controller mapping
        drive = -controller.left_stick_y;
        turn = controller.left_stick_x;
        boolean flywheelUp10 = controller.dpad_up;
        boolean flywheelDown10 = controller.dpad_down;
        boolean flywheelUp50 = controller.dpad_right;
        boolean flywheelDown50 = controller.dpad_left;

        // Drive interpretation
        lpower = drive + turn;
        rpower = drive - turn;
        max = Math.max(Math.abs(lpower), Math.abs(rpower));
        if (max > 1.0)
        {
            lpower /= max;
            rpower /= max;
        }
        dcontrol.drive(lpower,rpower);

        // Flywheel interpretation
        if (flywheelUp10) {
            flywheelSpeed=+10;
        } else if (flywheelDown10) {
            flywheelSpeed-=10;
        } else if (flywheelUp50) {
            flywheelSpeed+=50;
        } else if (flywheelDown50) {
            flywheelSpeed+=50;
        }

        dcontrol.flywheelPower(flywheelSpeed);
    }

    public String controllerData(Gamepad controller) {
        // Controller mapping
        drive = -controller.left_stick_y;
        turn = controller.left_stick_x;
        flywheel = controller.left_bumper;
        return "Drive: " + drive + " Turn: " + turn + " Flywheel: " + flywheel;
    }
}
