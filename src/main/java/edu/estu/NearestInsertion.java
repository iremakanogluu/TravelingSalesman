package edu.estu;


import java.util.LinkedList;


public class NearestInsertion extends TspBase {
    public LinkedList<Integer> getCities(int startCity){
        LinkedList<Integer> visitedCities = new LinkedList<>();
        visitedCities.add(startCity);
        visitedCities.add(startCity);

        while (visitedCities.size()-1 != cities.length){
            int minimumDistance = 1000000;
            int firstCity = -1;

            for(Integer city: visitedCities){
                for(int i=0; i<cities.length; i++){
                    if(visitedCities.contains(i))continue;
                    int distance = calculateDistance(i,city);
                    if(distance==0)continue;
                    if(minimumDistance>distance){
                        firstCity=i;
                        minimumDistance = distance;
                    }

                }
            }
            LinkedList<Integer> cityList= new LinkedList<>();
            int cost = 10000000;
            for(int i=0; i<visitedCities.size()-1;i++){
                LinkedList<Integer> cityList1 = new LinkedList<>(visitedCities);
                cityList1.add(i+1, firstCity);

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




    public void run(int cityNumber){
        LinkedList<Integer> visitedCities= getCities(cityNumber);
        System.out.println("Nearest Insertion: " + totalCost(visitedCities) + " " + visitedCities);

    }
}
