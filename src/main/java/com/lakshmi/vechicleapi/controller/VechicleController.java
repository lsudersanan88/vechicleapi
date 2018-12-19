package com.lakshmi.vechicleapi.controller;

import com.lakshmi.vechicleapi.model.Vehicle;
import com.lakshmi.vechicleapi.service.VechicleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class VechicleController {


    // constructor dependency injection
    private VechicleService vechicleService;
    public VechicleController(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }

    @GetMapping("/vechicles/getAllVechicles")
    public ResponseEntity getAllVechicles() {

        Map<Integer, Vehicle> vechicles = vechicleService.getallVechicles();
        if (!vechicles.isEmpty()) {
            return new ResponseEntity(vechicles, HttpStatus.OK);
        }
        return new ResponseEntity("No data", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/vechicles/getVechicleById/{id}")
    public ResponseEntity getVechicle(@PathVariable("id") Integer id ){

        Vehicle vechicle = vechicleService.getVechicleById(id);
        if (vechicle != null) {
            return new ResponseEntity(vechicle, HttpStatus.OK);
        }
        return new ResponseEntity("No data", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/vechicles/addVechicle")
    public ResponseEntity getVechicle(@RequestBody Vehicle vehicle){

        Vehicle vechicle = vechicleService.addVechicle(vehicle);
        if (vechicle != null) {
            return new ResponseEntity(vechicle, HttpStatus.CREATED);
        }
        return new ResponseEntity("No data", HttpStatus.NOT_FOUND);
    }



    @PatchMapping("/vechicles/editVehicle/{id}")
    public ResponseEntity updateVechicle(@RequestBody Vehicle vehicle,@PathVariable("id") Integer id ){

        vechicleService.updateVechicle(id, vehicle);
        if (vehicle != null) {
            return new ResponseEntity(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity("No data", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/vechicles/updateVehicle")
    public ResponseEntity updateVechicle(@RequestBody Vehicle vehicle){

        vechicleService.updateVechicle(vehicle);
        if (vehicle != null) {
            return new ResponseEntity(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity("No data", HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/vechicles/deleteVehicle/{id}")
    public String deleteVechicle(@PathVariable("id") Integer id ){

           vechicleService.deleteVechicle(id);

            return "Vehicle with id "+id+" is deleted";


    }
}
