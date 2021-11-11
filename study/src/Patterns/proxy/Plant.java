package Patterns.proxy;

public class Plant extends Planet implements Runnable{
    private double warehouseCapacity = 20;
    private double warehouseLoad = 0;
    private double quantityToProduce = 0;
    private double quantityProduced = 0;
    private double maxBatchSize = 3;
    //TODO move timeForOnePiece into Galaxy as a general parameter
    private long timeForOnePiece = 1000;
    private Mine plantMine;

    public Plant(int x, int y, int radius, int r, int g, int b, Mine mine) {
        super(x, y, radius, r, g, b);
        this.plantMine = mine;
    }

    //TODO create collback for order. Create Customer class
    public boolean placeOrder(double quantity) {
        if (quantityToProduce == 0) {
            this.quantityToProduce = quantity;
            return true;
        }
        return false;
    }

    //TODO to implement production method
    public void produce(double quantityToProduce) {

    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if(dockedShip != null) {
                if(dockedShip.getLoad() == 0 && quantityToProduce > warehouseLoad) {
                    dockedShip.addPointToRoute(plantMine);
                    dockedShip.addPointToRoute(this);
                    super.undock();
                } else {
                    double batchSize = maxBatchSize;
                    if(dockedShip.getLoad() < maxBatchSize) {
                        batchSize = dockedShip.getLoad();
                    }

                    if(batchSize > warehouseCapacity - warehouseLoad) {
                        batchSize = warehouseCapacity - warehouseLoad;
                    }
                    System.out.println("Docked ship load: " + dockedShip.getLoad());
                    System.out.println("Batch size: " + batchSize);
                    System.out.println("Plant warehouse load: " + warehouseLoad);
                    warehouseLoad += dockedShip.batchUnload(batchSize);
                }
            }

            try {
                Thread.sleep(timeForOnePiece);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
