package model;
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
    private Stage[] stages;

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
        this.stages = new Stage[6];
        this.stages[0] = new Stage("Inicio", true);
        for (int i=1;i<6;i++){
            this.stages[i]=new Stage(getNameStage(i), false);
        }
    }

    private Date calculateDatePlan(int numEtapa, int[] monthsForStage){
        int totMonths = 0;
        for (int i = 0; i < numEtapa; i++){
            totMonths += monthsForStage[i];
        }
        return new Date(totMonths / 12, totMonths % 12+1, 1);
    }

    public void assignPlannedDates(int[] monthsForStage){
        for(int i = 0; i<6; i++){
            this.stages[i].setStartDate(calculateDatePlan(i, monthsForStage));
            this.stages[i].setFinishDate(calculateDatePlan(i+1, monthsForStage));
        }
    }

    public void startStage(int numEtapa){
        this.stages[numEtapa].setActive(true);
        this.stages[numEtapa].setRealStartDate(new Date());
    }

    public void endStage(int numEtapa){
        this.stages[numEtapa].setActive(false);
        this.stages[numEtapa].setRealFinishDate(new Date());
        this.stages[numEtapa].setApproved(true);
    }

    private String getNameStage(int numEtapa){
        switch (numEtapa){
            case 1:
                return "Analisis";
            case 2:
                return "Diseno";
            case 3:
                return "Ejecucion";
            case 4:
                return "Cierre";
            case 5:
                return "Seguimiento y control";
            default:
                return "";
        }
    }

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