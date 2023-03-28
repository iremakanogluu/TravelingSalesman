package edu.estu;

import java.util.LinkedList;

public class CheapestInsertion extends TspBase {

    public LinkedList<Integer> getCities(int startCity){
        LinkedList<Integer> visitedCities = new LinkedList<>();
        visitedCities.add(startCity);
        visitedCities.add(startCity);

        while (visitedCities.size()-1 != cities.length){
            int minimumDistance = 1000000;
            int firstCity = -1;
            int secondCity = -1;
            for(Integer city: visitedCities){
                for(int i=0; i<cities.length; i++){
                    if(visitedCities.contains(i))continue;
                    int distance = calculateDistance(i,city);
                    if(distance==0)continue;
                    if(minimumDistance>distance){
                        firstCity=i;
                        minimumDistance = distance;
                        secondCity = findCity(firstCity);
                    }

                }
            }
            LinkedList<Integer> cityList= new LinkedList<>();
            int cost = 10000000;
            for(int i=0; i<visitedCities.size()-1;i++){
                LinkedList<Integer> cityList1 = new LinkedList<>(visitedCities);
                cityList1.add(i+1, firstCity);
                if(!cityList1.contains(secondCity)){
                    cityList1.add(i+1, secondCity);
                }
                int newCost = totalCost(cityList1);
                if(cost>newCost){
                    cost = newCost;
                    cityList = new LinkedList<>(cityList1);
                }

            }
            visitedCities = new LinkedList<>(cityList);
        }
        return visitedCities;
    }
    LinkedList<Integer> tempCityList = new LinkedList<>();
    public int findCity(int cityNumber){

        tempCityList.add(cityNumber);
        int city = -1;
        int minDistance = 100000000;
        for(int i=0; i<distance[cityNumber].length;i++){
            if(!tempCityList.contains(i)){
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
        LinkedList<Integer> visitedCities= getCities(cityNumber);
        System.out.println("Cheapest Insertion: " + totalCost(visitedCities) + " " + visitedCities);

    }
}
