package edu.estu;


import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class App
{
    public static void main(String[] args){

        MyOptions bean = new MyOptions();
        CmdLineParser parser = new CmdLineParser(bean);
        try{
            parser.parseArgument(args);
        }catch (CmdLineException cmdLineException){
            System.err.println(cmdLineException.getMessage());
            return;
        }


        ArbitraryInsertion arbitraryInsertion = new ArbitraryInsertion();
        arbitraryInsertion.run(bean.city);

        CheapestInsertion cheapestInsertion = new CheapestInsertion();
        cheapestInsertion.run(bean.city);

        FarthestInsertion farthestInsertion = new FarthestInsertion();
        farthestInsertion.run(bean.city);

        NearestInsertion nearestInsertion = new NearestInsertion();
        nearestInsertion.run(bean.city);

        NearestNeighbor nearestNeighbor = new NearestNeighbor();
        nearestNeighbor.run(bean.city);
    }
}
