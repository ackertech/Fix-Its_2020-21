package org.firstinspires.ftc.teamcode.Zarchive.Bot_Carmen_Julia.Control;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Zarchive.Bot_Carmen_Julia.Robot.CarmenBot;

//@TeleOp(name = "Carmen:Julia:FirstDrive")
public class TwoMotorDriveCarmenTeleOp extends OpMode {
    double speedMultiply = 1;
    public CarmenBot Bot = new CarmenBot();
    public void init()  {

        Bot.initRobot(hardwareMap);
    }

    public void loop()  {

        drive();
        slowDrive();
        armControl();
        ledControl();
        laucnherrcontrol();
    }

    public void stop()  {


    }
    public void slowDrive() {

        if (gamepad1.dpad_down) {
            speedMultiply = 0.5;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1;
        }
    }
    public void drive(){

        if (gamepad1.left_stick_y > -.1) {

            Bot.driveForward( speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < .1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.right_stick_x > .1) {

            Bot.turnRight(speedMultiply * gamepad1.right_stick_x);
        }
        else if (gamepad1.right_stick_x < -.1) {

            Bot.turnLeft(speedMultiply * gamepad1.right_stick_x);
        }
        else {

            Bot.stopMotors();
        }
    }

    public void armControl (){
        if (gamepad1.a) {
            Bot.raiseArm();
        }
        else if (gamepad1.b){
            Bot.lowerArm();
        }
    }

    public void ledControl (){
        if (gamepad1.left_trigger > 0.1) {
            Bot.setLedPattern((RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE));
        }
        else if (gamepad1.right_trigger > 0.1) {
            Bot.setLedPattern((RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_RAINBOW_PALETTE));
        }
    }


    public void laucnherrcontrol () {
        if (gamepad1.y) {
            Bot.launchCandy();
        }
      else if (gamepad1.x);
      Bot.stopLauncher();
    }

    }

