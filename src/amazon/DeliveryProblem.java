package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DeliveryProblem {
    public static void main(String[] args) {
        DeliveryProblem obj = new DeliveryProblem();
        List<List<Integer>> cord = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(-3);
        cord.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        cord.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        cord.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(-1);
        cord.add(list4);

        System.out.println(obj.findClosest(4, cord, 3));
    }

    private List<List<Integer>> findClosest(int numOfDestinations,
                                            List<List<Integer>> cord,
                                            int numOfDeliveries) {
        List<List<Integer>> result = new ArrayList<>();
        if (numOfDeliveries > numOfDestinations) return result;
        if (cord == null) return result;

        Map<Double, List<List<Integer>>> map = new TreeMap<>();

        for (List<Integer> location : cord) {
            double distance = calculateDistance(location.get(0), location.get(1));
            if (map.containsKey(distance)) {
                map.get(distance).add(location);
            } else {
                List<List<Integer>> init = new ArrayList<>();
                init.add(location);
                map.put(distance, init);
            }
        }

        int count = 0;
        for (Double distance : map.keySet()) {
            if (count < numOfDeliveries) {
                if (map.get(distance).size() == 1) {
                    result.add(map.get(distance).get(0));
                    count++;
                }
                else {
                    result.add(map.get(distance).get(0));
                    result.add(map.get(distance).get(1));
                    count = count + 2;
                }
            }
        }

        return result;
    }

    private double calculateDistance(int x, int y) {
        double sumOfSquare = Math.pow(x, 2) + Math.pow(y, 2);
        return Math.sqrt(sumOfSquare);
    }
}
