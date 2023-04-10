package model;

import java.util.ArrayList;
import java.util.Date;
//import java.time.*;


public class Enterprise {
    ArrayList<Proyect> proyects;

    public Enterprise(){
        this.proyects = new ArrayList<>(10);
    }

    public String addProyect(String nameProyect, String nameClient, String phoneClient, Date startDate, Date finishDate, double budget, String nameManager, String phoneManager){
        String message="";
        if (!searchProyect(nameProyect)){
            proyects.add(new Proyect(nameProyect, nameClient, phoneClient, startDate, finishDate, budget, nameManager, phoneManager));
            message="El proyecto fue creado exitosamente";
        } else {
            message="El proyecto ya esta creado";
        } return message;
    }

    public boolean searchProyect(String nameProyect){
        boolean status=false;
        for (int i=0;i<proyects.size() && !status;i++){
            if (proyects.get(i).getNameProyect().equalsIgnoreCase(nameProyect))
                status=true;
        } return status;
    }

}
