package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ControllerInterpreter {
    public double drive;
    public double turn;
    public double lpower;
    public double rpower;
    public double max;
    public boolean flywheel;

    DriveController dcontrol;

    public void init(HardwareMap hwMap) {
        dcontrol = new DriveController(hwMap);
    }

    public void update(Gamepad controller) {
        drive = -controller.left_stick_y;
        turn = controller.left_stick_x;
        flywheel = controller.left_bumper;

        lpower = drive + turn;
        rpower = drive - turn;
        max = Math.max(Math.abs(lpower), Math.abs(rpower));
        if (max > 1.0)
        {
            lpower /= max;
            rpower /= max;
        }

        dcontrol.drive(lpower,rpower);
    }
}
