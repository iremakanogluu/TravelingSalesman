package edu.estu;

import java.util.LinkedList;

public class FarthestInsertion extends TspBase {



    public LinkedList<Integer> getCities(int startCity){
        LinkedList<Integer> visitedCities = new LinkedList<>();
        visitedCities.add(startCity);
        visitedCities.add(startCity);

        while(visitedCities.size()-1 != cities.length){
            int firstCity = -1;
            int maximumDistance =-1;
            for(Integer city: visitedCities ){
                for(int i=0; i<cities.length;i++){
                    if(visitedCities.contains(i))continue;
                    int distance = calculateDistance(i,city);

                    if(distance==0){
                        continue;
                    }
                    if(maximumDistance<distance){
                        firstCity =i;
                        maximumDistance = distance;
                    }
                }
            }
            int cost = 100000000;
            LinkedList<Integer> citiesList = new LinkedList<>();

            for(int i=0; i<visitedCities.size()-1 ;i++){
                LinkedList<Integer> citiesList1 = new LinkedList<>(visitedCities);
                citiesList1.add(i+1,firstCity);

                int newCost = totalCost(citiesList1);

                if(cost>newCost){
                    cost = newCost;
                    citiesList = new LinkedList<>(citiesList1);
                }
            }
            visitedCities = new LinkedList<>(citiesList);
        }
        return visitedCities;
    }




    public void run(int cityNumber){
        LinkedList<Integer> visitedCities= getCities(cityNumber);
        System.out.println("Farthest Insertion: " + totalCost(visitedCities) + " " + visitedCities);

    }
}
