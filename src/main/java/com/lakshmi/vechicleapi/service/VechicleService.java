package com.lakshmi.vechicleapi.service;

import com.lakshmi.vechicleapi.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface VechicleService {

    public Map<Integer, Vehicle> getallVechicles();
    public Vehicle getVechicleById(Integer id);
    public Vehicle addVechicle(Vehicle vechicle);
    public void deleteVechicle(Integer id);
    public void updateVechicle(Integer id, Vehicle vehicle);
    public Vehicle updateVechicle(Vehicle vechicle);
}
