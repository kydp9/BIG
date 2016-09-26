package ru.k66.myweb.sql;



import ru.k66.myweb.model.Human;
import ru.k66.myweb.properties.PropertyGet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class RandomList {

    public static void main (String[] args) throws Exception
    {RandomList www = new RandomList();
        ArrayList<Human> lolka  = www.getRandomhumans(50);
        for (Human sss : lolka)
        {
            System.out.println(sss.getCity());
            System.out.println("name = " + sss.getName());
            System.out.println("name 2= " + sss.getSecondName());
        }
    }


   private static List<String> names;


public ArrayList<Human> getRandomhumans(int x ){
    ArrayList<Human>  humans = new ArrayList<Human>();
    if (x < 1)
    {
        return humans;
    }
    PropertyGet propget = new PropertyGet();
    Properties properties = propget.getProperties("C:\\SQL\\properties.txt");
String fileNames = properties.getProperty("names");
    String fileCars = properties.getProperty("car");
    String fileCity = properties.getProperty("city");

   List<String> names = readFile(fileNames);
   List<String> citys = readFile(fileCity);
    List<String> cars = readFile(fileCars);

    int nameSize = names.size();
    int citySize = citys.size();
    int carSize = cars.size();


    for(int i = 0 ; i < x ; i++)
    {
        Random r = new Random();
        humans.add( new Human(i,
                names.get(r.nextInt(nameSize)),
                names.get(r.nextInt(nameSize)),
                names.get(r.nextInt(nameSize)),
                cars.get(r.nextInt(carSize)),
                citys.get(r.nextInt(citySize))
                )

        );


    }



return humans;
}

 private List<String> readFile (String file){


    List<String> lines = null;
    try {
        lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
    } catch (IOException e) {
        e.printStackTrace();
    }
    /*
    for(String line: lines){
        System.out.println(line);
    }
    */
    return lines;
}

}
