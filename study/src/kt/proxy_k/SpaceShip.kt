package kt.proxy_k

import Patterns.Display
import Patterns.proxy.ShipHasNoDestinationException
import Patterns.proxy.ShipOverloadedException
import java.awt.Color
import kotlin.math.abs
import kotlin.math.sqrt

class SpaceShip(
    x: Double,
    y: Double,
    var radius: Int,
    var r: Int,
    var g: Int,
    var b: Int,
    private var isFlying: Boolean = false,
    private var color: Color = Color(r, g, b),
    private var speed: Int = 15,
    private var destination: Planet,
    private val capacity: Int = 20,
    private var load: Int = 0,
    private var destinations: ArrayList<Planet> = ArrayList()
): Drawable(x, y), Runnable {

    override fun draw() {
        val graphics = Display.getInstance().graphics
        graphics.color = color
        graphics.fillArc((x - radius/2).toInt(), (y - radius).toInt(), radius, radius * 2, 0, 360)
    }

    fun addPointToRoute(planet: Planet) {
        destinations.add(planet)
    }

    fun flyToNextPoint() {
        if (destinations.isEmpty()) {
            throw ShipHasNoDestinationException()
        }
        setCourse(destinations.removeAt(0))
    }

    fun undock() {
        flyToNextPoint()
    }

    fun setCourse(incomeDestination: Planet) {
        destination = incomeDestination
        isFlying = true
    }

    fun getFreeCapacity() = capacity - load

    fun batchLoad(batch: Int) {
        if (load + batch <= capacity) {
            load +=batch
        } else throw ShipOverloadedException()
    }

    fun batchUnload(batch: Int): Int {
        if (load < batch) {
            val temp = load
            load = 0
            return temp
        } else {
            load -= batch
            return batch
        }
    }

    fun getLoad() = load


    override fun run() {
        while (!Thread.currentThread().isInterrupted) {
                if (isFlying) {
                    if (abs(x - destination.x) <= speed && abs(y - destination.y) <= speed) {
                        x = destination.x
                        y = destination.y
                        isFlying = !destination.dock(this)
                    }
                    else {
                        val dX = destination.x - x
                        val dY = destination.y - y

                        val k = sqrt((dX*dX + dY*dY).toDouble())/speed
                        val vX = dX/k
                        val vY = dY/k

                        x += vX
                        y += vY

                        try {
                            Thread.sleep(100)
                        } catch (e: InterruptedException) {
                            break
                        }

                    }
                }
            }
    }

}
