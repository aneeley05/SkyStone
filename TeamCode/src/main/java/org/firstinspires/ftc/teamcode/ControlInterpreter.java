package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ControlInterpreter {
    public double drive;
    public double turn;
    public double lpower;
    public double rpower;
    public double max;
    public boolean flywheel;

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
        flywheel = controller.left_bumper;

        // This (supposedly) combines turn and drive for blended movement
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

    public String controllerData(Gamepad controller) {
        // Controller mapping
        double driveB = -controller.left_stick_y;
        double turnB = controller.left_stick_x;
        boolean flywheelB = controller.left_bumper;

        return "Drive: " + driveB + " Turn: " + turnB + " Flywheel: " + flywheelB;
    }
}
