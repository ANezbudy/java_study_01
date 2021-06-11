package Patterns;

public class buildingDoor extends buildingPart {

    @Override
    public Construction createBuildingPart(Building building, int r, int g, int b) {
        return new Door(building, r, g, b);
    }
}
