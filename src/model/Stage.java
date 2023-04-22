package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class Stage {
    private typeStage name;
    private boolean active;
    private Date startDate;
    private Date finishDate;
    private Date realStartDate;
    private Date realFinishDate;
    private boolean approved;

    Capsule[] capsules = new Capsule[50];

    public Stage(){
        
    }

    public Stage(typeStage name, boolean active){
        this.name=name;
        this.active=active;
    }

    public Stage(Date startDate, Date finishDate, Date realStartDate, Date realFinishDate){
        this.startDate=startDate;
        this.finishDate=finishDate;
        this.realStartDate=realStartDate;
        this.realFinishDate=realFinishDate;
        this.approved=true;
    }

    public String addCapsule(String id, String description, String capsuleName, String positionColaborator, String learn, String typeCapsule){
        boolean status=false;
        String message="La capsula no se pudo crear porque no hay mas espacio";
        Capsule com = searchCapsule(id);
        if (com==null){
            for(int i=0; i<capsules.length && !status;i++){
                if (capsules[i]==null){
                    capsules[i] = new Capsule(id, description, capsuleName, positionColaborator, learn, typeCapsule);
                    status=true;
                    message="La capsula se creo exitosamente";
                }
            }
        } else {
            message="La capsula ya se encuentra creada";
        } return message;
    }

    public Capsule searchCapsule(String id){
        boolean existCapsule = false;
        Capsule c=null;
        for (int i=0; i<capsules.length && !existCapsule; i++){
            if(capsules[i]!=null){
                if(capsules[i].getId().equalsIgnoreCase(id)){
                    existCapsule=true;
                    c=capsules[i];
                }
            }
        } return c;
    }

    public String approvedCapsule(String id){
        String message="";
        boolean existCapsule = false;
        if(capsules.length!=0){
            for (int i=0; i<capsules.length && !existCapsule; i++){
                if (capsules[i].getId().equalsIgnoreCase(id)){
                    if(capsules[i].isApproved()){
                        capsules[i].setApproved(true);
                        capsules[i].setApprovedTime(LocalDateTime.now());
                        message="La capsula ha sido aprobada y su fecha de aprobacion fue el: "+capsules[i].getApprovedTime();
                        existCapsule=true;
                    }
                } else {
                    message="La capsula no se encuentra registrada";
                }
            }
        } else {
            message = "No hay capsulas registradas";
        }return message;
    }

    public void generarArchivoHTML(String rutaArchivo){
        for (int i=0; i<capsules.length; i++){
            if (capsules[i]!=null){
                if(capsules[i].isApproved()==true){
                    try{
                        File file = new File(rutaArchivo);
                        FileWriter writer = new FileWriter(file);
                        writer.write("<html><head><title>Capsulas de interes organizacional</title></head>");
                        writer.write("<body><h1>Capsulas</h1><p>"+capsules[i].getCapsuleName()+"<br></p></body></html>");
                        writer.close();
                        System.out.println("Archivo HTML generado exitosamente.");
                    } catch(IOException e){
                        System.out.println("Ocurrio un error al generar el archivo HTML." + e.getMessage());
                    }
                    }
                }
            }
        }

    public typeStage getName() {
        return name;
    }
    
    public void setName(typeStage name) {
        this.name = name;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealFinishDate() {
        return realFinishDate;
    }

    public void setRealFinishDate(Date realFinishDate) {
        this.realFinishDate = realFinishDate;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
