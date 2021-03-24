package stack;

import java.util.*;

public class SunsetView {
    public static class Building {
        Integer id;
        Integer height;

        public Building(Integer id, Integer height) {
            this.id = id;
            this.height = height;
        }
    }

    /*
    Problem: Given list of buildings from east to west calculate which all buildings will get sunset view
    Solution: Basic idea is if there is a taller building on west it will block sunset of building on east
    to implement this create a stack. Now start iterating from east to west, if the current building is
    shorter than the building on stack add it to stack, but if its taller then take out all the buildings
    on stack which are shorter than it
     */
    public List<Building> examineBuildingWithSunset(List<Integer> buildings) {
        List<Building> buildingWithHeights = new ArrayList<>();
        Stack<Building> stack = new Stack<>();

        for (int i = 0; i < buildings.size(); i++) {
            Integer currentBuildingHeight = buildings.get(i);
            while (!stack.isEmpty() && (currentBuildingHeight >= stack.peek().height))
                stack.pop();
            stack.push(new Building(i, currentBuildingHeight));
        }

        Iterator<Building> it = stack.iterator();
        while (it.hasNext()) {
            buildingWithHeights.add(it.next());
        }
        return buildingWithHeights;
    }

    public static void main(String[] args) {
        SunsetView buildingWithSunset = new SunsetView();
        List<Integer> buildingHeights = Arrays.asList(4, 2, 3, 1);
        List<Building> sunsetViewList = buildingWithSunset.examineBuildingWithSunset(buildingHeights);
        for (Building building : sunsetViewList) {
            System.out.println(building.height);
        }
    }
}
