package Patterns.proxy;

public class Mine extends Planet implements Runnable {
    private double warehouseCapacity = 1;
    private double warehouseLoad;
    private long timeForOnePiece = 1000;
    private double maxBatchSize = 2;

    public Mine(int x, int y, int radius, int r, int g, int b) {
        super(x, y, radius, r, g, b);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (warehouseLoad < warehouseCapacity) {
                warehouseLoad = warehouseLoad + 1;
                System.out.println("Warehouse load: " + warehouseLoad);
            }

            if (dockedShip != null) {
                double batchSize = maxBatchSize;
                if(dockedShip.getFreeCapacity() < maxBatchSize) {
                    batchSize = dockedShip.getFreeCapacity();
                }
                try {
                    System.out.println("Docked ship free capacity: " + dockedShip.getFreeCapacity());
                    System.out.println("Batch size: " + batchSize);
                    System.out.println("Ship load: " + dockedShip.getLoad());
                    dockedShip.batchLoad(batchSize);

                } catch (ShipOverloadedException e) {
                    System.out.println("Attempt to overload ship! WARNING!!!");
                    break;
                }

                if (dockedShip.getFreeCapacity() == 0) {
                    super.undock();
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
