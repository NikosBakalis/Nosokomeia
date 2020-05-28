package model;

import java.sql.Date;

public class AdmissionTicketConfirmationScreenListItem {
    private String amka, firstName, lastName, sourceClinic, destinationClinic, stage;
    private Date id;

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSourceClinic() {
        return sourceClinic;
    }

    public void setSourceClinic(String sourceClinic) {
        this.sourceClinic = sourceClinic;
    }

    public String getDestinationClinic() {
        return destinationClinic;
    }

    public void setDestinationClinic(String destinationClinic) {
        this.destinationClinic = destinationClinic;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Date getId() {
        return id;
    }

    public void setId(Date id) {
        this.id = id;
    }
}
