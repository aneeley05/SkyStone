package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;

@TeleOp(name = "Default_OpMode", group = "OpModes")
public class TeleOpMode extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    ControlInterpreter control = new ControlInterpreter();

    String controlData = "NULL";
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        control.init(hardwareMap);
        gamepad1.setUser(GamepadUser.ONE); // Possible solution for the gamepad issue
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     * note: we probably won't need this
     */
    @Override
    public void init_loop() {

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
        telemetry.addData("Status", "Starting...");
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        // Outputs 0,0,false for no reason
        controlData = control.controllerData(gamepad1);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("ControllerData", controlData);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
