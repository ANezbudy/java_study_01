package Patterns;

public class buildingChimney extends buildingPart {

    @Override
    public Construction createBuildingPart(Building building, int r, int g, int b) {
        return new Chimney(building, r, g, b);
    }
}
