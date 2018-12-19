# Different types of dependency injection
    
    
    // Different kinds of DI examples


 1. Field dependency injection
      
    @Autowired
    VechicleService vechicleService;

 2. constructor dependency injection
    
    private VechicleService vechicleService;
    public VechicleController(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }

3. setter dependency injection

   private VechicleService vechicleService;
     @Autowired
    public void setVechicleService(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }

4. (any) method dependency injection

   private VechicleService vechicleService;
    @Autowired
   // @Qualifier
    public void vechiclemethods(VechicleService vechicleService) {
        this.vechicleService = vechicleService;
    }


## End points

http://localhost:8080/vechicles/getAllVechicles
http://localhost:8080/vechicles/deleteVehicle/2
http://localhost:8080/vechicles/editVehicle/1
 {
        "id": 1,
        "make": "Benzz",
        "model": "Benz5",
        "year": 2018
    }