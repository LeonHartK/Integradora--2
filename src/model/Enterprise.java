package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Enterprise {
    public Proyect[] proyects;
    public static int nProyects = 0;

    public Enterprise() {
        this.proyects = new Proyect[10];
    }

    public String addProyect(String nameProyect, String nameClient, String phoneClient, Date startDate, Date finishDate,
            double budget, String nameManager, String phoneManager) {
        boolean status = false;
        String message = "El proyecto no se pudo crear porque no hay mas espacio";
        Proyect com = searchProyectObj(nameProyect);
        if (com == null) {
            for (int i = 0; i < proyects.length && !status; i++) {
                if (proyects[i] == null) {
                    proyects[i] = new Proyect(nameProyect, nameClient, phoneClient, startDate, finishDate, budget,
                            nameManager, phoneManager);
                    status = true;
                    message = "El proyecto se creo exitosamente";
                }
            }
        } else {
            message = "El proyecto ya se encuentra creado";
        }
        return message;
    }

    public Proyect searchProyectObj(String nameProyect) {
        boolean existProyect = false;
        Proyect proyect = null;
        for (int i = 0; i < proyects.length && !existProyect; i++) {
            if (proyects[i] != null) {
                if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                    existProyect = true;
                    proyect = proyects[i];
                }
            }
        }
        return proyect;
    }

    public String endStage(String nameProyect) {
        String message = "";
        boolean status = false;
        for (int i = 0; i < proyects.length && !status; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                        Proyect proyect = searchProyectObj(nameProyect);
                        message = proyect.endStage();
                        status = true;
                    }
                } else {
                    message = "No hay un proyecto con ese nombre";
                }
            } else {
                message = "No hay proyectos registrados";
            }
        }
        return message;
    }

    public String addCapsule(String nameProyect, String id, String description, String capsuleName,
            String positionColaborator, String learn, int typeCapsule) {
        String message = "";
        boolean status = false;
        for (int i = 0; i < proyects.length && !status; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                        Proyect proyect = searchProyectObj(nameProyect);
                        message = proyect.searchStageObj().addCapsule(id, description, capsuleName, positionColaborator,
                                learn, getNameCapsule(typeCapsule));
                        status = true;
                    } else {
                        message = "No hay proyectos con ese nombre";
                    }
                }
            } else {
                message = "No hay proyectos creados";
            }
        }
        return message;
    }

    public typeCapsule getNameCapsule(int capsule) {
        switch (capsule) {
            case 1:
                return typeCapsule.TECNICO;
            case 2:
                return typeCapsule.GESTION;
            case 3:
                return typeCapsule.DOMINIO;
            case 4:
                return typeCapsule.EXPERIENCIAS;
        }
        return null;
    }

    public String approvedCapsule(String nameProyect, String id) {
        String message = "";
        boolean status = false;
        for (int i = 0; i < proyects.length && !status; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                        Proyect proyect = searchProyectObj(nameProyect);
                        message = proyect.searchStageObj().approvedCapsule(id);
                        status = true;
                    } else {
                        message = "No hay un proyecto con ese nombre";
                    }
                }
            } else {
                message = "No hay proyectos creados";
            }
        }
        return message;
    }

    public String publicCapules(String nameProyect, String ruta) {
        String message = "";
        boolean status = false;
        for (int i = 0; i < proyects.length && !status; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                        Proyect proyect = searchProyectObj(nameProyect);
                        message = proyect.searchStageObj().generarArchivoHTML(ruta);
                        status = true;
                    } else {
                        message = "No hay un proyecto con dicho nombre";
                    }
                } 
            } else {
                message = "No hay proyectos registrados";
            }
        }
        return message;
    }

    public String cantCapType(String nameProyect) {
        String message = "";
        boolean status = false;
        for (int i = 0; i < proyects.length && !status; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].getNameProyect().equalsIgnoreCase(nameProyect)) {
                        Proyect proyect = searchProyectObj(nameProyect);
                        message = proyect.searchStageObj().returncantCap();
                        status = true;
                    } else {
                        message = "No hay un proyecto con dicho nombre";
                    }
                }
            } else {
                message = "No hay proyectos registrados";
            }
        }
        return message;
    }

    public String finMax() {
        String message = "";
        int max = 0;
        for (int i = 0; i < proyects.length; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].cantCapStage() > max) {
                        max = proyects[i].cantCapStage();
                        message = "El proyecto con más capsulas es: " + proyects[i].getNameProyect();
                    }
                }
            } else {
                message = "No hay proyectos registrados";
            }
        }
        return message;
    }

    public String Colaborator(String nameColaborator) {
        String message = "";
        for (int i = 0; i < proyects.length; i++) {
            if (proyects[0] != null) {
                if (proyects[i] != null) {
                    if (proyects[i].registeredCap(nameColaborator) == true) {
                        message = "El colaborador si ha creado cápsulas anteriormente";
                    } else {
                        message = "El colaborador no ha creado capsulas anteriormente";
                    }
                }
            } else {
                message = "No hay proyectos creados";
            }
        }
        return message;
    }
    public void leerCap() throws FileNotFoundException {

        File directorio = new File(System.getProperty("user.dir")+"/src/inData/Capsulas.txt");
        Scanner infile = new Scanner(directorio);

        String nameProyect; 
        String id;
        String description; 
        String capsuleName;
        String positionColaborator;
        String learn; 
        String typeCapsule;

        while(infile.hasNext()) {
            nameProyect = infile.nextLine();
            id = infile.nextLine();
            description = infile.nextLine();
            capsuleName = infile.nextLine();
            positionColaborator = infile.nextLine();
            learn = infile.nextLine();
            typeCapsule = infile.nextLine();
            addCapsule(nameProyect, id, description, capsuleName, positionColaborator, learn, Integer.parseInt(typeCapsule));
        }
        infile.close(); 
    }

    public void leerProyectos() throws FileNotFoundException {

        File directorio = new File(System.getProperty("user.dir")+"/src/inData/Proyectos.txt");
        Scanner infile = new Scanner(directorio);

        String nameProyect;
        String nameClient;
        String phoneClient;
        String startDate;
        String finishDate;
        String budget;
        String nameManager;
        String phoneManager;

        while(infile.hasNext()) {
            nameProyect = infile.next();
            nameClient = infile.next();
            phoneClient = infile.next();
            startDate = infile.next();
            finishDate = infile.next();
            budget = infile.next();
            nameManager = infile.next();
            phoneManager = infile.next();
            proyects [nProyects++] = new Proyect(nameProyect, nameClient, phoneClient, parseo(startDate), parseo(finishDate), Double.parseDouble(budget), nameManager, phoneManager);
        }
        infile.close(); 
    }

    public Date parseo(String fecha) throws InputMismatchException{
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;

        String date = fecha;

        try {
            testDate = df.parse(date);
        } catch (Exception e) {
            throw new InputMismatchException("Format invalid");
        }

        if (!df.format(testDate).equals(date)) {
            throw new InputMismatchException("Format invalid");
        } 
        return testDate;
    }
}
