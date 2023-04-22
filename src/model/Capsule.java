package model;

import java.time.LocalDateTime;

public class Capsule {
    private String id;
    private String description;
    private String capsuleName;
    private String positionColaborator;
    private String learn;
    private typeCapsule typeCapsule;
    private boolean approved;
    private LocalDateTime approvedTime;

    public Capsule() {

    }

    public Capsule(String id, String description, String capsuleName, String positionColaborator, String learn,
            typeCapsule typeCapsule) {
        this.id = id;
        this.description = description;
        this.capsuleName = capsuleName;
        this.positionColaborator = positionColaborator;
        this.learn = learn;
        this.typeCapsule = typeCapsule;
        this.approved = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapsuleName() {
        return capsuleName;
    }

    public void setCapsuleName(String capsuleName) {
        this.capsuleName = capsuleName;
    }

    public String getPositionColaborator() {
        return positionColaborator;
    }

    public void setPositionColaborator(String positionColaborator) {
        this.positionColaborator = positionColaborator;
    }

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }

    public typeCapsule getTypeCapsule() {
        return typeCapsule;
    }

    public void setTypeCapsule(typeCapsule typeCapsule) {
        this.typeCapsule = typeCapsule;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(LocalDateTime approvedTime) {
        this.approvedTime = approvedTime;
    }
}
