package org.sert2521.gamename

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.livewindow.LiveWindow

var DEBUG = false

class Robot : IterativeRobot() {
    override fun robotInit() {
        Drivetrain
    }

    override fun autonomousPeriodic() = Scheduler.getInstance().run()

    override fun teleopPeriodic() = Scheduler.getInstance().run()

    override fun testPeriodic() = LiveWindow.run()
}