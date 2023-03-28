package edu.estu;

import java.util.List;

public class TspBase {

    String[] cities;
    int[][] distance;

    public TspBase(){
        this.cities =TurkishNetwork.cities;
        this.distance =TurkishNetwork.distances;
    }

    public int calculateDistance(int city1 ,int city2){
        return distance[city1][city2];
    }

    public int totalCost(List<Integer> visitedCities){
        int cost=0;
        for(int i=0; i<visitedCities.size()-1; i++){
            cost += calculateDistance(visitedCities.get(i),visitedCities.get(i+1));
        }
        return cost;
    }
}
