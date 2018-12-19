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
        Integer id = vehicle.getId();
        vehicle.setId(vehicle.getId());
        vehicle.setModel(vehicle.getModel());
        vehicle.setMake(vehicle.getMake());
        vehicle.setYear(vehicle.getYear());
        vehiclesMap.put(id, vehicle);
        return vehicle;
    }

    public  Vehicle updateVechicle( Vehicle vehicle)
    {
        Integer id = vehicle.getId();
        vehicle.setId(vehicle.getId());
        vehicle.setYear(vehicle.getYear());
        vehicle.setModel(vehicle.getModel());
        vehicle.setMake(vehicle.getMake());
        vehiclesMap.put(id, vehicle);
        return vehicle;
    }

    public  Vehicle updateVechicle(Integer id, Vehicle vehicle)
    {
        vehicle.setMake(vehicle.getMake());
        vehicle.setYear(vehicle.getYear());
        vehicle.setModel(vehicle.getModel());
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

}
