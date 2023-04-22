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

    public Stage() {

    }

    public Stage(typeStage name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Stage(Date startDate, Date finishDate, Date realStartDate, Date realFinishDate) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.realStartDate = realStartDate;
        this.realFinishDate = realFinishDate;
        this.approved = true;
    }

    public String addCapsule(String id, String description, String capsuleName, String positionColaborator,
            String learn, typeCapsule typeCapsule) {
        boolean status = false;
        String message = "La capsula no se pudo crear porque no hay mas espacio";
        Capsule com = searchCapsule(id);
        if (com == null) {
            for (int i = 0; i < capsules.length && !status; i++) {
                if (capsules[i] == null) {
                    capsules[i] = new Capsule(id, description, capsuleName, positionColaborator, learn, typeCapsule);
                    status = true;
                    message = "La capsula se creo exitosamente";
                }
            }
        } else {
            message = "La capsula ya se encuentra creada";
        }
        return message;
    }

    public Capsule searchCapsule(String id) {
        boolean existCapsule = false;
        Capsule c = null;
        for (int i = 0; i < capsules.length && !existCapsule; i++) {
            if (capsules[i] != null) {
                if (capsules[i].getId().equalsIgnoreCase(id)) {
                    existCapsule = true;
                    c = capsules[i];
                }
            }
        }
        return c;
    }

    public String approvedCapsule(String id) {
        String message = "";
        boolean existCapsule = false;
        for (int i = 0; i < capsules.length && !existCapsule; i++) {
            if (capsules[0] != null) {
                if (capsules[i] != null) {
                    if (capsules[i].getId().equalsIgnoreCase(id)) {
                        if (capsules[i].isApproved() == false) {
                            capsules[i].setApproved(true);
                            capsules[i].setApprovedTime(LocalDateTime.now());
                            message = "La capsula ha sido aprobada y su fecha de aprobacion fue el: "
                                    + capsules[i].getApprovedTime();
                            existCapsule = true;
                        } else {
                            message = "La capsula ya se encuentra aprobada";
                        }
                    } else {
                        message = "La capsula no se encuentra registrada";
                        break;
                    }
                }
            } else {
                message = "No hay capsulas registradas";
            }
        }
        return message;
    }

    public String generarArchivoHTML(String rutaArchivo) {
        String message = "";
        for (int i = 0; i < capsules.length; i++) {
            if (capsules[0] != null) {
                if (capsules[i] != null) {
                    if (capsules[i].isApproved() == true) {
                        try {
                            File file = new File(rutaArchivo);
                            FileWriter writer = new FileWriter(file);
                            writer.write("<html><head><title>Capsulas de interes organizacional</title></head>");
                            writer.write("<body><h1>Capsulas</h1><ul>");
                            for (Capsule capsulas : capsules) {
                                writer.write("<li>" + capsulas + "</li>");
                            }
                            writer.write("</ul></body></html>");
                            writer.close();
                            message = "Archivo HTML generado exitosamente.";
                        } catch (IOException e) {
                            message = "Ocurrio un error al generar el archivo HTML." + e.getMessage();
                        }
                    }
                }
            } else {
                message = "No hay capsulas registradas";
            }
        }
        return message;
    }

    public String returncantCap() {
        int cantTecnico = 0;
        int cantGestion = 0;
        int cantDominio = 0;
        int cantExperiencia = 0;
        String message = "";

        for (int i = 0; i < capsules.length; i++) {
            if (capsules[0] != null) {
                if (capsules[i] != null) {
                    switch (capsules[i].getTypeCapsule()) {
                        case TECNICO:
                            cantTecnico++;
                            break;
                        case GESTION:
                            cantGestion++;
                            break;
                        case DOMINIO:
                            cantDominio++;
                            break;
                        case EXPERIENCIAS:
                            cantExperiencia++;
                            break;
                    }
                }
                message = "Hay " + cantTecnico + " capsulas registradas de tipo tecnico\nHay " + cantGestion
                        + " capsulas registradas de tipo gestion\nHay " + cantDominio
                        + " capsulas registradas de tipo dominio\nHay " + cantExperiencia
                        + " capsulas registradas de tipo experiencias";
            } else {
                message = "No hay capsulas registradas";
            }
        }
        return message;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < capsules.length; i++) {
            if (capsules[0] != null) {
                if (capsules[i] != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public Capsule ifColab(String nameColaborator) {
        boolean existCapsule = false;
        Capsule c = null;
        for (int i = 0; i < capsules.length && !existCapsule; i++) {
            if (capsules[i] != null) {
                if (capsules[i].getCapsuleName().equalsIgnoreCase(nameColaborator)) {
                    existCapsule = true;
                    c = capsules[i];
                }
            }
        }
        return c;
    }

    public boolean ifColaborator(String nameColaborator) {
        boolean existCapsule = false;
        for (int i = 0; i < capsules.length && !existCapsule; i++) {
            if (capsules[0] != null) {
                if (capsules[i] != null) {
                    if (capsules[i].getCapsuleName().equalsIgnoreCase(nameColaborator)) {
                        existCapsule = true;
                    }
                }
            }
        }
        return existCapsule;
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
