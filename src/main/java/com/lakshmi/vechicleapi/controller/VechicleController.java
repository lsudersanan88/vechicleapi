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

    // Field dependency injection*/
   /* @Autowired
    VechicleService vechicleService;


    // constructor dependency injection
   /* private VechicleService vechicleService;
    public VechicleController(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }*/


    // setter dependency injection
   /* private VechicleService vechicleService;
     @Autowired
    public void setVechicleService(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }*/


    //(any) method dependency injection
   private VechicleService vechicleService;
    @Autowired
   // @Qualifier
    public void vechiclemethods(VechicleService vechicleService) {
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


    @DeleteMapping("/vechicles/deleteVehicle/{id}")
    public String deleteVechicle(@PathVariable("id") Integer id ){

           vechicleService.deleteVechicle(id);

            return "Vehicle with id "+id+" is deleted";


    }
}
