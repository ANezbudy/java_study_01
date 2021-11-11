package kt.proxy_k

import Patterns.proxy.ShipOverloadedException
import Patterns.proxy.SpaceShip

class Mine (x: Double,
            y: Double,
            radius: Double,
            r: Int,
            g: Int,
            b: Int,
            private var warehouseCapacity: Int = 1,
            private var warehouseLoad: Int = 0,
            private var timeForOnePiece: Long = 1000,
            private var maxBatchSize: Int = 2
            ): Planet(x, y, radius, r, g, b), Runnable {

    override fun run() {
        while (!Thread.currentThread().isInterrupted) {
            if (warehouseLoad < warehouseCapacity) {
                warehouseLoad += 1
                println("Warehouse load: $warehouseLoad")
            }

            var flag = true

            dockedShip?.let {
                    var batchSize = maxBatchSize
                    if (it.getFreeCapacity() < maxBatchSize) {
                        batchSize = it.getFreeCapacity()
                    }
                    try {
                        println("Docked ship free capacity: ${it.getFreeCapacity()}")
                        println("Batch size: $batchSize")
                        println("Ship load: ${it.getLoad()}")
                        it.batchLoad(batchSize)
                    } catch (e: ShipOverloadedException) {
                        println("Attempt to overload ship! WARNING!!!")
                        flag = false
                    }

                    if (it.getFreeCapacity() == 0) undock()
            }

            if (!flag) break

            try {
                Thread.sleep(timeForOnePiece)
            } catch (e: InterruptedException) {
                break
            }
        }
    }
}