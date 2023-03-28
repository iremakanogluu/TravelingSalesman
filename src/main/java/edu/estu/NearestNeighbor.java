package edu.estu;

import java.util.LinkedList;
import java.util.List;

public class NearestNeighbor extends TspBase {


    public List<Integer> getVisitedCities(int startCity){
        int firstCity = startCity;
        LinkedList<Integer> visitedCities = new LinkedList<>();
        for(int i=0; i<cities.length;i++){
            visitedCities.add(i,firstCity);
            firstCity = getCity(firstCity);
        }
        visitedCities.add(cities.length,startCity);
        return visitedCities;
    }
    LinkedList<Integer> cityList = new LinkedList<>();
    public int getCity(int cityNumber){
        cityList.add(cityNumber);
        int city = -1;
        int minDistance = 100000000;
        for(int i=0; i<distance[cityNumber].length;i++){
            if(!cityList.contains(i)){
                int dist = calculateDistance(cityNumber,i);
                if(dist==0)continue;
                if(dist < minDistance){
                    minDistance = dist;
                    city = i;
                }

            }
        }
        return city;
    }
    public void run(int cityNumber){
        LinkedList<Integer> visitedCities= (LinkedList<Integer>) getVisitedCities(cityNumber);
        System.out.println("Nearest Neighbor: " + totalCost(visitedCities) + " " + visitedCities);

    }


}
