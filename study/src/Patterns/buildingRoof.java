package Patterns;

public class buildingRoof extends buildingPart {

    @Override
    public Construction createBuildingPart(Building building, int r, int g, int b) {
        return new Roof(building, r, g, b);
    }
}
