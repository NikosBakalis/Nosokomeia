package ui.doctor;

import database.ICRUDImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class PatientFileScreen {
    public Button returnButton;
    public Button patientInfoButton;
    public Button briefHistoryButton;
    public Button detailedHistoryButton;
    public Button admissionTicketButton;
    public Button statusAndDiagnosisButton;
    public Button testsButton;
    public Button testResultsButton;
    public Button treatmentButton;
    public Button dischargeNoteButton;
    public ScrollPane initialPane;
    public Pane firstPane;
    public Pane statusAndDiagnosisPane;
    public ScrollPane infoDataPatient; // inside statusAndDiagnosisPane
    public TextArea doctorDiagnosisArea; // inside statusAndDiagnosisPane
    public Button saveStatusAndDiagnosisButton; // inside statusAndDiagnosisPane
    public TextArea DiagnosisDataPatient;  // inside statusAndDiagnosisPane
    public Pane treatmentPane;
    public TextArea doctorTreatmentArea;  //inside treatmentPane
    public Button saveTreatmentButton;   //inside treatmentPane
    public TextArea treatmentDataPatient;  //inside treatmentPane
    public Pane dischargeNotePane;
    public TextArea dischargeText; //inside dischargeNotePane
    public ComboBox hostClinic;   //inside dischargeNotePane
    public Button dischargeNoteSaveButton;  //inside dischargeNotePane
    public TextArea initialTextArea;



    // first pane is the pane that contains all the buttons etc.. This pain never goes.
    // we use initial pane as the pane that only takes data from db. in this pane doctor is not supposed to make any changes.
    // so in order not to have many panes in "PatientInfo" , "BriefHistory", we use initial pane.
    // status and diagnosis pane only refers to status and diagnosis
    //treatment pne is the pane that refers to treatment
    // dischargeNotePane is a pane that refers to discharge note

    ICRUDImpl iCRUDImpl = new ICRUDImpl();
    Patient patient = new Patient();
    PatientFile patientFile = new PatientFile();
    PatientFolder patientFolder = new PatientFolder();
    AdmissionTicket admissionTicket = new AdmissionTicket();
    DischargeNote dischargeNote = new DischargeNote();



    public void onReturnClick(ActionEvent actionEvent) throws IOException {
        System.out.println("Return to initial doctor screen");
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();
    }

    public void onPatientInfoClick(ActionEvent actionEvent) {
        System.out.println("Show patient info");
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);

//        patient = iCRUDImpl.getPatient("86727365");  //get the patient from double click
        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ:"+patient.getAmka());
        initialTextArea.appendText("\nΑΦΜ:"+patient.getAfm());
        initialTextArea.appendText("\nΌνομα:"+patient.getFirstName());
        initialTextArea.appendText("\nΕπώνημο:"+patient.getLastName());
        initialTextArea.appendText("\nΗμ.Γέννησης:"+patient.getBirthDate());
        initialTextArea.appendText("\nΕθνικότητα:"+patient.getNationality());
        initialTextArea.appendText("\nθρησκεία:"+patient.getReligion());
        initialTextArea.appendText("\nΦύλο:"+patient.getGender());
        initialTextArea.appendText("\nΑσφάλεια:"+patient.getInsurance());
        initialTextArea.appendText("\nΠατρώνημο:"+patient.getFatherFirstName());
        initialTextArea.appendText("\nΕπώνημο Πατέρα:"+patient.getFatherLastName());
        initialTextArea.appendText("\nΌνομα Μητέρας:"+patient.getMotherFirstName());
        initialTextArea.appendText("\nΕπώνημο Μητέρας:"+patient.getMotherLastName());
        initialTextArea.appendText("\nΔιεύθυνση 1ης Κατοικίας:"+patient.getFirstStreetName());
        initialTextArea.appendText("\nΑριθμός 1ης Κατοικίας:"+patient.getFirstStreetNumber());
        initialTextArea.appendText("\nΔιεύθυνση 2ης Κατοικίας:"+patient.getSecondStreetName());
        initialTextArea.appendText("\nΤηλέφωνο Επικοινωνίας:"+patient.getPrimaryPhoneNumber());
        initialTextArea.appendText("\nΤηλέφωνο Έκτατης Ανάγκης"+patient.getEmergencePhoneNumber());
        initialTextArea.appendText("\nEmail:"+patient.getEmainAddress());
    }

    public void onBriefHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show brief history");

//        patientFol =  iCRUDImpl.getPatientFolder("86727365");  //get the patient from double click
        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ:"+patient.getAmka());
        initialTextArea.appendText("\nΌνομα:"+patient.getFirstName());
        initialTextArea.appendText("\nΕπώνημο:"+patient.getLastName());
        initialTextArea.appendText("\nΧρόνιες Παθήσεις:"+patientFolder.getChronicDisease());
        initialTextArea.appendText("\nΑλλεργίες:"+patientFolder.getPatientAllergies());
        initialTextArea.appendText("\nΧειρουργία:"+patientFolder.getPatientSurgeries());
        initialTextArea.appendText("\nΟμάδα Αίματος:"+patientFolder.getBloodType());
        initialTextArea.appendText("\nHBV:"+patientFolder.getHBV());
        initialTextArea.appendText("\nHBC:"+patientFolder.getHBC());
    }
   // false because we are not supposed to do this.
    public void onDetailedHistoryClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        //initialPane.setVisible(true);
        System.out.println("Show detailed history");
        patientFile = iCRUDImpl.getPatientFile("86727365");  //get the patient from double click
        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ:"+patient.getAmka());
        initialTextArea.appendText("\nΌνομα:"+patient.getFirstName());
        initialTextArea.appendText("\nΕπώνημο:"+patient.getLastName());
        initialTextArea.appendText("\nΑριθμός Αρχείου:"+patientFile.getFileId());
        initialTextArea.appendText("\nΝοσοκομείο:"+patientFile.getHospital());
        initialTextArea.appendText("\nΔιάγνωση:"+patientFile.getDiagnosis());
        initialTextArea.appendText("\nΘεραπεία:"+patientFile.getTreatment());
        initialTextArea.appendText("\nΑποτελέσματα εξετάσεων:"+patientFile.getLabTests());
    }
// in this phase doctor can only see the admission ticket. Not change it
    public void onAdmissionTicketClick(ActionEvent actionEvent) {
        initialPane.setVisible(true);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show admission ticket");

        iCRUDImpl.getAdmissionTicketByAmka("86727365"); // This needs to be changed!
//        iCRUDImpl.getPatient("86727365");
        admissionTicket = iCRUDImpl.getAdmissionTicket(admissionTicket.getTicketId());  //get the patient from double click
        initialTextArea.setWrapText(true);  //texts never exceeds
        initialTextArea.setText("ΑΜΚΑ:"+patient.getAmka());
        initialTextArea.appendText("\nΌνομα:"+patient.getFirstName());
        initialTextArea.appendText("\nΕπώνημο:"+patient.getLastName());
        initialTextArea.appendText("\nΗμερομηνία Εισαγωγής:"+admissionTicket.getCreatedAt());
        initialTextArea.appendText("\nΚλινική Εισαγωγής:"+admissionTicket.getAdmissionClinic());
        initialTextArea.appendText("\nΚλινική Υποδοχής:"+admissionTicket.getHostClinic());
        initialTextArea.appendText("\nΘάλαμος Ασθενή:"+admissionTicket.getPatientChamber());
        initialTextArea.appendText("\nΚρεβάτι Ασθενή:"+admissionTicket.getPatientChamber());
        initialTextArea.appendText("\nΚείμενο Εισιτηρίου:"+admissionTicket.getAdmissionText());
        initialTextArea.appendText("\nΣτάδιο:"+admissionTicket.getStage());


    }

    public void onStatusAndDiagnosisClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(true);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show status and diagnosis");
        DiagnosisDataPatient.setEditable(false);  //none can change this area
       if (patientFile.getDiagnosis()==null){
           DiagnosisDataPatient.setText("Διάγνωση:"+" -"); }
       else {
           DiagnosisDataPatient.setText("Διάγνωση:" + patientFile.getDiagnosis());
       }
    }
    // false because we are not supposed to do this.
    public void onTestsClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        System.out.println("Show lab tests");
    }
    // false because we are not supposed to do this.
    public void onTestResultsClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        System.out.println("Show lab tests results");
    }

    public void onTreatmentClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(true);
        dischargeNotePane.setVisible(false);
        System.out.println("Show treatment");
        treatmentDataPatient.setEditable(false);  //none can change this area
        if( patientFile.getTreatment()==null) {
            treatmentDataPatient.appendText("Τωρινή Θεραπεία:"+" -"); }
        else {
        treatmentDataPatient.appendText("Τωρινή Θεραπεία:"+patientFile.getTreatment());}

    }

    //inside treatmentPane
    public void onSaveTreatmentClick(ActionEvent actionEvent) {
        //patientFile.setTreatment(doctorTreatmentArea.getText());
        admissionTicket = iCRUDImpl.getAdmissionTicketByAmka("86727365");
        System.out.println(admissionTicket.getTicketId());
        System.out.println(doctorTreatmentArea.getText().getClass().getName());
        iCRUDImpl.updateTreatment(doctorTreatmentArea.getText(), "86727365", admissionTicket.getTicketId());
    }

    public void onDischargeNoteClick(ActionEvent actionEvent) {
        initialPane.setVisible(false);
        statusAndDiagnosisPane.setVisible(false);
        treatmentPane.setVisible(false);
        dischargeNotePane.setVisible(true);
        System.out.println("Show discharge note");

        dischargeNote = iCRUDImpl.getDischargeNote("86727365");  //get the patient from double click
        initialTextArea.setWrapText(true);  //texts never exceeds
        iCRUDImpl.getAllClinicNamesOfDoctor("28488905");
        hostClinic.setItems(iCRUDImpl.getAllClinicNamesOfDoctor("28488905"));

    }

    private void openScene(String fxmlFile) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("I-aso");
        scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void closeButtonAction(){
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
    }

    // inside statusAndDiagnosisPane
    public void onSaveStatusAndDignosisClick(ActionEvent actionEvent) {
    }

    public void onHostClinicClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();

    }
    public void onDischargeNoteSaveClick(ActionEvent actionEvent) throws IOException {
        openScene("initial_doctor_screen.fxml");
        closeButtonAction();
    }
}
