package model;

import java.util.Date;

public class Stage {
    private int numero;
    private int duracion;
    private boolean approved;
    private Date startDate;
    private Date finishDate;
    private Date realStartDate;
    private Date realFinishDate;
    Capsule[] capsules;

    public Stage(){
        
    }

    public Stage(Date startDate, Date finishDate, Date realStartDate, Date realFinishDate){
        this.startDate=startDate;
        this.finishDate=finishDate;
        this.realStartDate=realStartDate;
        this.realFinishDate=realFinishDate;
        this.approved=true;
        this.capsules = new Capsule[50];
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
