package kt.proxy_k

import Patterns.Animated
import Patterns.Display
import java.lang.reflect.Array
import kotlin.random.Random

fun main() {
    val galaxyKt: GalaxyKt = GalaxyKt()
    galaxyKt.drawSandBoxKt()
}

class GalaxyKt {

    fun drawSandBoxKt() {
        val titel = "Dream Galaxy"
        val width = Display.getWidth()
        val height = Display.getHeight()

        var currentTime = System.currentTimeMillis()

        var running = true

        val kali = Mine(1100.0, 600.0, 200.0, 100, 100, 100)
        val gekata = Plant(200.0,150.0, 100.0, 89, 67, 70, plantMine = kali)

        val kaliThread = Thread(kali)
        kaliThread.start()

        val gekataThread = Thread(gekata)
        gekataThread.start()

        val ship = SpaceShip(gekata.x, gekata.y, 30, 0, 255, 127, destination = kali)
        gekata.dock(ship)

        val shipThread = Thread(ship)
        shipThread.start()

        val arrayListDrawable = ArrayList<Drawable>()
        val arrayListAnimated = ArrayList<Animated>()

        arrayListDrawable.add(gekata)
        arrayListDrawable.add(kali)
        arrayListDrawable.add(ship)

        while (running) {
            if(Math.random() < 0.01) {
                gekata.placeOrder(2.0)
            }

            val graphics = Display.getInstance().graphics

            graphics.clearRect(0, 0, width, height)

            val newTime = System.currentTimeMillis()
            val timePast = newTime - currentTime
            currentTime = newTime

            for (element in arrayListDrawable) {
                element.draw()
            }

            for (element in arrayListAnimated) {
                element.update(timePast)
            }

            Display.getInstance().show()
        }

    }
}