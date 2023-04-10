package model;

//import java.time.LocalDateTime;
import java.util.Date;

public class Proyect {
    private String nameProyect;
    private String nameClient;
    private String phoneClient;
    private Date startDate;
    private Date finishDate;
    private double budget;
    private String nameManager;
    private String phoneManager;

    public Proyect(){

    }

    public Proyect(String nameProyect, String nameClient, String phoneClient, Date startDate, Date finishDate, double budget, String nameManager, String phoneManager){
        this.nameProyect=nameProyect;
        this.nameClient=nameClient;
        this.phoneClient=phoneClient;
        this.startDate=startDate;
        this.finishDate=finishDate;
        this.budget=budget;
        this.nameManager=nameManager;
        this.phoneManager=phoneManager;
    }

    /*public String finishStage(String approved, Date realFinishDate){
        String message="";
        if (approved.equalsIgnoreCase("Aprobado")){
            
        }
        return message;
    }*/

    public String getNameProyect() {
        return nameProyect;
    }

    public void setNameProyect(String nameProyect) {
        this.nameProyect = nameProyect;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }
}
