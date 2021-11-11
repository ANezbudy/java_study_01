package kt.proxy_k

import Patterns.Display
import Patterns.proxy.EverythingGoesBadException
import Patterns.proxy.ShipHasNoDestinationException
import Patterns.proxy.SpaceShip
import java.awt.*

open class Planet (
    x: Double,
    y: Double,
    private val radius: Double,
    val r: Int,
    val g: Int,
    val b: Int
    ): Drawable(x, y) {
    private val color = Color(r, g, b)
    var dockedShip: kt.proxy_k.SpaceShip? = null

    override fun draw() {
        // Display is java class - not overwritten
        val graphics = Display.getInstance().graphics
        graphics.color = color
        graphics.fillArc((x - radius).toInt(), (y - radius).toInt(), (radius * 2).toInt(), (radius * 2).toInt(), 0, 360)
    }

    @Synchronized
    fun dock(ship: kt.proxy_k.SpaceShip): Boolean {
        if (dockedShip == null) {
            dockedShip = ship
            return true
        }
        return false
    }

    @Synchronized
    fun undock() {
//        if (dockedShip != null) {
//            try {
//                    dockedShip!!.undock()
//                } catch (e: ShipHasNoDestinationException) {
//                    throw EverythingGoesBadException()
//                }
//        }

        dockedShip?.let{
                try {
                    it.undock()
                    dockedShip = null
                } catch (e: ShipHasNoDestinationException) {
                    throw EverythingGoesBadException()
                }
        }
    }


}