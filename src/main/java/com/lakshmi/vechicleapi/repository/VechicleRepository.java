package com.lakshmi.vechicleapi.repository;

import com.lakshmi.vechicleapi.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

@Repository
public class VechicleRepository
{

    public VechicleRepository() {
        loadData();
    }

    Map<Integer, Vehicle> vehiclesMap ;

          public  Map<Integer, Vehicle> loadData()
          {
              vehiclesMap = new HashMap<Integer, Vehicle>();
              for (int i = 0; i < 10; i++) {
                  Vehicle vehicle = new Vehicle();
                  int id = i + 1;
                  vehicle.setId(id);
                  vehicle.setYear(new Random().nextInt(100) + 1950);

                  final String[] carTypes = {"Audi", "Benz"};
                  Random random = new Random();
                  int index = random.nextInt(carTypes.length);
                  vehicle.setMake(carTypes[index]);

                  if(index == 0)
                  {
                      final String[] audiModels = {"Audi1", "Audi2", "Audi3", "Audi4"};
                       random = new Random();
                       index = random.nextInt(audiModels.length);
                      vehicle.setModel(audiModels[index]);
                  }
                  else if(index == 1)
                  {
                      final String[] audiModels = {"Benz1", "Benz2", "Benz3", "Benz4"};
                      random = new Random();
                      index = random.nextInt(audiModels.length);
                      vehicle.setModel(audiModels[index]);
                  }

                  //  addVechicle(vehicle);
                  vehiclesMap.put(id, vehicle);

              }
              return vehiclesMap;
          }

    public  Map<Integer, Vehicle> getAll()
    {

        return vehiclesMap;
    }

    public  Vehicle getVechicleById(Integer id)
    {
        Map<Integer, Vehicle> vechicles = vehiclesMap;
        Iterator iterator = vechicles.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry item = (Map.Entry)iterator.next();
            if(id == item.getKey())
            {
                return (Vehicle) item.getValue();
            }
        }

        return null;
    }


    public  Vehicle addVechicle( Vehicle vehicle)
    {
       // Map<Integer, Vehicle> vechicles = addSamples();
        Integer id = vehicle.getId();
        vehicle.setId(vehicle.getId());
        vehicle.setModel(vehicle.getModel());
        vehicle.setMake(vehicle.getMake());
        vehicle.setYear(vehicle.getYear());
        vehiclesMap.put(id, vehicle);
        return vehicle;
    }

    public  void deleteVechicleById(Integer id)
    {
        Map<Integer, Vehicle> vechicles = vehiclesMap;
        Iterator it = vechicles.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry item = (Map.Entry)it.next();
            if(id == item.getKey()) {
                it.remove();
            }
        }

    }


   /* public  Map<Integer, Vehicle> addSamples() {
       Map map = new HashMap<Integer, Vehicle>();
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(11);
        vehicle1.setModel("A");
        vehicle1.setMake("B");
        vehicle1.setYear(1111);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(12);
        vehicle2.setModel("AA");
        vehicle2.setMake("BB");
        vehicle2.setYear(2222);
        map.put(1,vehicle1);
        map.put(2,vehicle2);
        return map;
    }
*/


/*


    public static void main(String[] args) {
              Vehicle vehicle = new Vehicle();
        vehicle.setId(11);
        vehicle.setModel("A");
        vehicle.setMake("B");
        vehicle.setYear(2222);
        addVechicle(vehicle);
    }

*/





    /*public static void main(String[] args) {
        System.out.println(getVechicleById(1)); //getVechicleById(1);
    }
*/

    /*public static void main(String[] args) {
        final String[] proper_noun = {"Audi", "Benz", "Toyota", "Corolla"};
        Random random = new Random();
        // String carTypes = random.n
        int index = random.nextInt(proper_noun.length);
        System.out.println(proper_noun[index]);
    }
*/




   /*
   private static Map<Integer, Vehicle> vehiclesMap = new HashMap<Integer, Vehicle>();

   static {
        for (int i = 0; i < 10; i++) {
            Vehicle vehicle = new Vehicle();
            int id = i + 1;
            vehicle.setId(id);
            vehicle.setYear(new Random().nextInt(100) + 1950);
            vehicle.setMake("Audi");
            vehicle.setModel("Z4");

            vehiclesMap.put(id, vehicle);

        }
        System.out.println(vehiclesMap);
        System.out.println();
    }*/

  /*  public static void main(String[] args) {

    }*/
}
