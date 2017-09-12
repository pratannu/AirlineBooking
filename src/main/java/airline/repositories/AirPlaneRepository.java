package airline.repositories;

import airline.model.AirPlane;
import airline.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class AirPlaneRepository {
    ArrayList<AirPlane> planes = new ArrayList<AirPlane>();

    public AirPlaneRepository(){
        planes.add(new AirPlane("Boeing 787", 8000, 13000,15000));
        planes.add(new AirPlane("AirBus 310",5000, 9000,12000));
        planes.add(new AirPlane("Lockheed Constellation",3500, 10500, 0));
        planes.add(new AirPlane("Bristol Brabazon", 2000, 0, 8000));
    }

    public List<AirPlane> getPlaneNames() {
        return planes;
    }

    public AirPlane getPlaneName(String Name){
        AirPlane airPlane = new AirPlane();
        for (AirPlane plane : planes) {
            if (plane.getPlaneName().equals(Name)) {
                airPlane = plane;
                break;
            }
        }
        return airPlane;
    }




}
