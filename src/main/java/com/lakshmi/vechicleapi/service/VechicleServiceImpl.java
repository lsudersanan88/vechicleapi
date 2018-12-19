package com.lakshmi.vechicleapi.service;

import com.lakshmi.vechicleapi.model.Vehicle;
import com.lakshmi.vechicleapi.repository.VechicleRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VechicleServiceImpl implements VechicleService{

   VechicleRepository vechicleRepository;

   public VechicleServiceImpl(VechicleRepository vechicleRepository) {
      this.vechicleRepository = vechicleRepository;
   }

   @Override
   public Map<Integer, Vehicle> getallVechicles() {
      return vechicleRepository.getAll();
   }

   @Override
   public Vehicle getVechicleById(Integer id) {
      return vechicleRepository.getVechicleById(id);
   }

   @Override
   public Vehicle addVechicle(Vehicle vechicle) {
      return vechicleRepository.addVechicle(vechicle);
   }

   @Override
   public void deleteVechicle(Integer id) {
      vechicleRepository.deleteVechicleById(id);
   }

   @Override
   public void updateVechicle(Integer id, Vehicle vehicle) {
   vechicleRepository.updateVechicle(id,vehicle);
   }

   @Override
   public Vehicle updateVechicle(Vehicle vechicle) {
      return vechicleRepository.updateVechicle(vechicle);
   }
}
