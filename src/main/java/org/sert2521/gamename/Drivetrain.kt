package org.sert2521.gamename

import com.ctre.CANTalon
import com.ctre.CANTalon.TalonControlMode
import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.command.Subsystem


object Drivetrain : Subsystem() {
    private val frontLeft = CANTalon(FRONT_LEFT_MOTOR)
    private val frontRight = CANTalon(FRONT_RIGHT_MOTOR)
    private val rearLeft = CANTalon(REAR_LEFT_MOTOR)
    private val rearRight = CANTalon(REAR_RIGHT_MOTOR)

    private val frontDrive: RobotDrive
    private val rearDrive: RobotDrive

    init {
        frontLeft.enableBrakeMode(true)
        frontRight.enableBrakeMode(true)
        rearLeft.enableBrakeMode(true)
        rearRight.enableBrakeMode(true)

        frontDrive = RobotDrive(frontLeft, frontRight)
        rearDrive = RobotDrive(rearLeft, rearRight)
    }

    fun teleoperatedDrive() {
        frontLeft.changeControlMode(TalonControlMode.PercentVbus)
        frontRight.changeControlMode(TalonControlMode.PercentVbus)
        rearLeft.changeControlMode(TalonControlMode.PercentVbus)
        rearRight.changeControlMode(TalonControlMode.PercentVbus)

        val move = -OI.left.y
        val rotate = -OI.left.x
        frontDrive.arcadeDrive(move, rotate)
        rearDrive.arcadeDrive(move, rotate)
    }

    override fun initDefaultCommand() {
        defaultCommand = TeleopDrivetrain()
    }
}
