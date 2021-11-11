package kt.proxy_k

class Plant(x: Double,
            y: Double,
            radius: Double,
            r: Int,
            g: Int,
            b: Int,

            private var warehouseCapacity: Int = 20,
            private var warehouseLoad: Int = 0,
            private var timeForOnePiece: Long = 1000,
            private var maxBatchSize: Int = 3,
            private var plantMine: Mine,
            private var quantityToProduce: Double = 0.0,
            private var quantityProduced: Double = 0.0
            ) : Planet(x, y, radius, r, g, b), Runnable {

    fun placeOrder(quantity: Double): Boolean {
        if(quantityToProduce.equals(0.0)) {
            quantityToProduce = quantity
            return true
        }
        return false
    }

    override fun run() {
        while (!Thread.currentThread().isInterrupted) {

            dockedShip?.let {
                if (it.getLoad() == 0 && quantityToProduce > warehouseLoad) {
                    it.addPointToRoute(plantMine)
                    it.addPointToRoute(this)
                    undock()
                } else {
                    var batchSize = maxBatchSize
                    if (it.getFreeCapacity() < maxBatchSize) {
                        batchSize = it.getLoad()
                    }

                    if(batchSize > warehouseCapacity - warehouseLoad) {
                        batchSize = warehouseCapacity - warehouseLoad
                    }
                        println("Docked ship load: ${it.getLoad()}")
                        println("Batch size: $batchSize")
                        println("Plant warehouse load: $warehouseLoad")
                        warehouseLoad += it.batchUnload(batchSize)
                }
            }

            try {
                Thread.sleep(timeForOnePiece)
            } catch (e: InterruptedException) {
                break
            }
        }
    }
}