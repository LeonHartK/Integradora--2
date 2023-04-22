package model;

import java.util.ArrayList;
import java.util.Date;


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

    public Proyect searchProyectObj(String nameProyect){
        boolean status = false;
        Proyect proyect = null;
        for (int i=0;i<proyects.size() && !status;i++){
            if (proyects.get(i).getNameProyect().equalsIgnoreCase(nameProyect)){
                status = true;
                proyect = proyects.get(i); 
            } else {
                System.out.println("No hay un proyecto con ese nombre");
            }
        } return proyect;
    }

    public String endStage(String nameProyect){
        Proyect proyect = searchProyectObj(nameProyect);
        proyects.remove(proyect);
        String message = proyect.endStage();
        proyects.add(proyect);
        return message;
    }

}
