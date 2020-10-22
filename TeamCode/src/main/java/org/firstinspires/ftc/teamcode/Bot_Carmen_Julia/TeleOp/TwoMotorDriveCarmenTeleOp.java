package org.firstinspires.ftc.teamcode.Bot_Carmen_Julia.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Bot_Carmen_Julia.Robot.CarmenBot;


@TeleOp(name = "Carmen:Julia:FirstDrive")

public class TwoMotorDriveCarmenTeleOp extends OpMode {

    public double speedMultiply = 1;

    public CarmenBot Bot = new CarmenBot();

    public void init() {

        Bot.initRobot(hardwareMap);
    }

    public void loop () {

        driveControl();
        speedControl();

    }

    public void speedControl() {

        if (gamepad1.dpad_down) {
            speedMultiply = 0.5;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1;
        }
    }
    public void driveControl(){

        if (gamepad1.left_stick_y > .1) {

            Bot.driveForward( speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -.1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > .1) {

            Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
        }
        else if (gamepad1.left_stick_x < -.1) {

            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
        }
        else {

            Bot.stopMotors();
        }
    }


}
