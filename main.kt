

enum class Direction{
    UP,LEFT,DOWN,RIGHT
}

open class Robot(var x:Int,var y:Int,var direction:Direction){
    var getx: Int = 0
        get() {
            return x
        }

    var gety: Int = 0
        get() {
            return y
        }

    var getDirection: Direction = Direction.UP
        get() {
            return direction
        }

    fun TurnLeft():Direction {
        direction = when(direction){
            Direction.UP -> Direction.LEFT
            Direction.LEFT -> Direction.DOWN
            Direction.DOWN -> Direction.RIGHT
            Direction.RIGHT -> Direction.UP
        }
        return direction
    }
    fun TurnRight():Direction{
        direction = when(direction){
            Direction.UP -> Direction.RIGHT
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
        }
        return direction
    }
    fun StepForvard():Int{
        when(direction){
            Direction.UP -> y++
            Direction.LEFT -> x--
            Direction.DOWN -> y--
            Direction.RIGHT -> x++
        }
        when(direction){
            Direction.UP -> return y
            Direction.DOWN -> return y
            Direction.RIGHT -> return x
            Direction.LEFT-> return x

        }
    }
}
class SmartRobot(var robot:Robot,var toX:Int,var toY: Int){
    fun GoToPoint(){
        if(robot.getx < toX){
            while(robot.getDirection != Direction.RIGHT){
                robot.TurnLeft()

            }
            while(robot.getx != toX){
                robot.StepForvard()
                println("Step to x ${robot.getx}")
            }
        }else{
            while(robot.getDirection != Direction.LEFT){
                robot.TurnRight()
            }
            while(robot.getx != toX){
                robot.StepForvard()
                println("Step to x ${robot.getx}")

            }
        }
        if(robot.gety < toY){
            while(robot.getDirection != Direction.UP){
                robot.TurnLeft()
            }
            while(robot.gety!= toY){
                robot.StepForvard()
                println("Step to y ${robot.gety}")
            }
        }else{
            while(robot.getDirection != Direction.DOWN){
                robot.TurnRight()
            }
            while(robot.gety!= toY){
                robot.StepForvard()
                println("Step to y ${robot.gety}")
            }
        }
    }
}
fun main(){
    val robot = Robot(0, 0, Direction.UP)
    println("${robot.getx},${robot.gety}")
    val smartRobot = SmartRobot(robot,15,3)
    smartRobot.GoToPoint()
    println("${robot.getx},${robot.gety}")
}

