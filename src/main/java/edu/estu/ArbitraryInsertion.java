package edu.estu;

import java.util.LinkedList;


public class ArbitraryInsertion extends TspBase {

    public LinkedList<Integer> getCities(int startCity){
        LinkedList<Integer> visitedCities = new LinkedList<>();
        visitedCities.add(startCity);
        visitedCities.add((int)(Math.random()*80));
        visitedCities.add((int)(Math.random()*80));
        visitedCities.add(startCity);
        int randomNum = (int)Math.floor(Math.random()*(cities.length));
        while (visitedCities.size()-1 != cities.length){
            while(visitedCities.contains(randomNum)){
                randomNum = (int)Math.floor(Math.random()*(cities.length));
            }
            LinkedList<Integer> cityList= new LinkedList<>();
            int cost = 10000000;
            for(int i=0; i<visitedCities.size()-1;i++){
                LinkedList<Integer> cityList1 = new LinkedList<>(visitedCities);
                cityList1.add(i+1, randomNum);

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
        System.out.println("Arbitrary Insertion: " + totalCost(visitedCities) + " " + visitedCities);

    }
}
