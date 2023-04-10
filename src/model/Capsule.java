package model;

public class Capsule {
    private String id;
    private String description;
    private String capsuleName;
    private String positionColaborator;
    private String learn;
    private String typeCapsule;

    public Capsule(){

    }

    public Capsule(String id, String description, String capsuleName, String positionColaborator, String learn, String typeCapsule){
        this.id=id;
        this.description=description;
        this.capsuleName=capsuleName;
        this.positionColaborator=positionColaborator;
        this.learn=learn;
        this.typeCapsule=typeCapsule;
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

    public String getTypeCapsule() {
        return typeCapsule;
    }

    public void setTypeCapsule(String typeCapsule) {
        this.typeCapsule = typeCapsule;
    }
}
