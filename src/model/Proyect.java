package model;

import java.util.Calendar;
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
    private Stage[] stages = new Stage[6];

    public Proyect() {

    }

    public Proyect(String nameProyect, String nameClient, String phoneClient, Date startDate, Date finishDate,
            double budget, String nameManager, String phoneManager) {
        this.nameProyect = nameProyect;
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.budget = budget;
        this.nameManager = nameManager;
        this.phoneManager = phoneManager;
        this.stages = new Stage[6];
        this.stages[0] = new Stage(typeStage.START, true);
        for (int i = 1; i < 6; i++) {
            this.stages[i] = new Stage(getNameStage(i), false);
        }
    }

    public int numeroEtapa() {
        boolean status = false;
        int num = 0;
        for (int i = 0; i < 6 && !status; i++) {
            if (stages[i].isActive()) {
                num = i;
                status = true;
            }
        }
        return num;
    }

    public Stage searchStageObj() {
        boolean status = false;
        Stage stage = null;
        for (int i = 0; i < stages.length && !status; i++) {
            if (stages[i].isActive()) {
                status = true;
                stage = stages[i];
            }
        }
        return stage;
    }

    private Date calculateDatePlan(int numEtapa, int[] monthsForStage) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        for (int i = 0; i < numEtapa; i++) {
            cal.add(Calendar.MONTH, monthsForStage[i]);
        }
        return cal.getTime();
    }

    public void assignPlannedDates(int[] monthsForStage) {
        for (int i = 0; i < 6; i++) {
            this.stages[i].setStartDate(calculateDatePlan(i, monthsForStage));
            this.stages[i].setFinishDate(calculateDatePlan(i + 1, monthsForStage));
        }
    }

    public String endStage() {
        int num = numeroEtapa();
        this.stages[num].setActive(false);
        this.stages[num].setRealFinishDate(new Date());
        this.stages[num].setApproved(true);
        this.stages[num + 1].setActive(true);
        this.stages[num + 1].setRealStartDate(new Date());

        String message = "Se ha finalizado la etapa";
        return message;
    }

    private typeStage getNameStage(int numEtapa) {
        switch (numEtapa) {
            case 1:
                return typeStage.ANALYSIS;
            case 2:
                return typeStage.DESIGN;
            case 3:
                return typeStage.EXECUTION;
            case 4:
                return typeStage.CLOSE;
            case 5:
                return typeStage.CONTROL;
            default:
                return typeStage.START;
        }
    }

    public int cantCapStage() {
        int count = 0;
        for (int i = 0; i < stages.length; i++) {
            if (stages[0] != null) {
                if (stages[i] != null) {
                    count += stages[i].count();
                }
            }
        }
        return count;
    }

    public boolean registeredCap(String nameColaborator) {
        boolean exist = false;
        for (int i = 0; i < stages.length; i++) {
            if (stages[0] != null) {
                if (stages[i] != null) {
                    if (stages[i].ifColaborator(nameColaborator) == true) {
                        exist = true;
                    }
                }
            }
        }
        return exist;
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
