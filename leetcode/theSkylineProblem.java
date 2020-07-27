// Link to the question:
// https://leetcode.com/problems/the-skyline-problem/submissions/
// Understood and implemented using Tushar Roy's logic

class Building{
    int x;
    int height;
    boolean isStart;
    Building(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}

class BuildComp implements Comparator<Building> {
    public int compare(Building a, Building b) {
        if (a.x != b.x) {
            return a.x - b.x;
        }
        else {
            if (a.isStart && !b.isStart) {
                return -1; 
            }
            else if (!a.isStart && b.isStart) {
                return 1;
            }
            else if (a.isStart && b.isStart) {
                return b.height - a.height;
            }
            // else if (!a.isStart && !b.isStart) {
            else {
                return a.height - b.height;
            }
        } 
    }
}


class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Building> buildingz = new ArrayList<Building>();
        
        for (int i=0; i<buildings.length; i++) {
            Building buildingStart = new Building(buildings[i][0], buildings[i][2], true);
            Building buildingEnd = new Building(buildings[i][1], buildings[i][2], false);
            buildingz.add(buildingStart);
            buildingz.add(buildingEnd);
        }
        
        Collections.sort(buildingz, new BuildComp());
        
        TreeMap<Integer, Integer> pq = new TreeMap<Integer, Integer>();
//         <height, counter>
        pq.put(0,1);
        int prevMaxHeight = 0;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i=0; i<buildingz.size(); i++) {
            Building building = buildingz.get(i);
            if (building.isStart) {
                if (!pq.containsKey(building.height)) {
                    pq.put(building.height, 1);
                }
                else {
                    pq.put(building.height, pq.get(building.height)+1);
                }
            }
            else {
                int count = pq.get(building.height);
                if (count == 1) {
                    pq.remove(building.height);
                }
                else {
                    pq.put(building.height, count-1);
                } 
            }
            
            int currentMaxHeight = pq.lastKey();
            if (currentMaxHeight != prevMaxHeight) {
                prevMaxHeight = currentMaxHeight;
                List<Integer> res = new ArrayList<Integer>();
                res.add(building.x);
                res.add(currentMaxHeight);
                result.add(res);
            }
        }
        
        
        return result;
    }
}