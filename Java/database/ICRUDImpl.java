package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.lang.*;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


public class ICRUDImpl implements ICRUD {

    private static Connection connection;

    public Hospital getHospital(String afm) {
        try {
            String query = "SELECT * FROM hospital WHERE hospital.hospital_afm = ?";

            ResultSet resultSet;
            Hospital hospital;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, afm);
                resultSet = preparedStatement.executeQuery();
                hospital = null;
                if (resultSet.next()) {
                    hospital = new Hospital();
                    hospital.setAfm(resultSet.getString("afm"));
                    hospital.setName(resultSet.getString("name"));
                    hospital.setFirst_street_name(resultSet.getString("first_street_name"));
                    hospital.setFirst_street_number(resultSet.getInt("first_street_number"));
                    hospital.setPrimary_phone_number(resultSet.getInt("primary_phone_number"));
                    hospital.setEmergency_phone_number(resultSet.getInt("emergency_phone_number"));
                    hospital.setEmail_address(resultSet.getString("email_address"));
                    hospital.setSecond_street_name(resultSet.getString("second_street_name"));
                    hospital.setSecond_street_number(resultSet.getInt("second_street_number"));
                }
            }
            resultSet.close();
            return hospital;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Clinic getClinic(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM clinic WHERE clinic.name = ? AND clinic.hospital_afm = ?";

            ResultSet resultSet;
            Clinic clinic;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                clinic = null;
                if (resultSet.next()) {
                    clinic = new Clinic();
                    clinic.setName(resultSet.getString("name"));
                    clinic.setHospitalAfm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return clinic;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Patient getPatient(String amka) {
        try {
            String query = "SELECT * FROM patient WHERE patient.amka = ?";

            ResultSet resultSet;
            Patient patient;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                resultSet = preparedStatement.executeQuery();
                patient = null;
                if (resultSet.next()) {
                    patient = new Patient();
                    patient.setAmka(resultSet.getString("amka"));
                    patient.setAfm(resultSet.getString("afm"));
                    patient.setFirstName(resultSet.getString("first_name"));
                    patient.setLastName(resultSet.getString("last_name"));
                    patient.setBirthDate(resultSet.getDate("birth_date"));
                    patient.setNationality(resultSet.getString("nationality"));
                    patient.setReligion(resultSet.getString("religion"));
                    patient.setGender(resultSet.getString("gender"));
                    patient.setInsurance(resultSet.getString("insurance"));
                    patient.setFatherFirstName(resultSet.getString("father_first_name"));
                    patient.setFatherLastName(resultSet.getString("father_last_name"));
                    patient.setMotherFirstName(resultSet.getString("mother_first_name"));
                    patient.setMotherLastName(resultSet.getString("mother_last_name"));
                    patient.setFirstStreetName(resultSet.getString("first_street_name"));
                    patient.setFirstStreetNumber(resultSet.getString("first_street_number"));
                    patient.setPrimaryPhoneNumber(resultSet.getString("primary_phone_number"));
                    patient.setEmergencePhoneNumber(resultSet.getString("emergency_phone_number"));
                    patient.setEmainAddress(resultSet.getString("email_address"));
                    patient.setSecondStreetName(resultSet.getString("second_street_name"));
                    patient.setSecondStreetNumber(resultSet.getString("second_street_number"));
                }
            }
            resultSet.close();
            return patient;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PatientFolder getPatientFolder(String patient_amka) {
        try {
            String query = "SELECT * FROM patient_folder WHERE patient_folder.patient_amka = ?";

            ResultSet resultSet;
            PatientFolder patientFolder;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, patient_amka);
                resultSet = preparedStatement.executeQuery();
                patientFolder = null;
                if (resultSet.next()) {
                    patientFolder = new PatientFolder();
                    patientFolder.setPatientAmka(resultSet.getString("patient_amka"));
                    patientFolder.setChronicDisease(resultSet.getString("chronic_disease"));
                    patientFolder.setPatientAllergies(resultSet.getString("patient_allergies"));
                    patientFolder.setPatientSurgeries(resultSet.getString("patient_surgeries"));
                    patientFolder.setBloodType(resultSet.getString("blood_type"));
                    patientFolder.setHBV(resultSet.getString("HBV"));
                    patientFolder.setHBC(resultSet.getString("HBC"));
                }
            }
            resultSet.close();
            return patientFolder;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PatientFile getPatientFile(String file_id) {
        try {
            String query = "SELECT * FROM patient_file WHERE patient_file.file_id = ?";

            ResultSet resultSet;
            PatientFile patientFile;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, file_id);
                resultSet = preparedStatement.executeQuery();
                patientFile = null;
                if (resultSet.next()) {
                    patientFile = new PatientFile();
                    patientFile.setPatientAmka(resultSet.getString("patient_amka"));
                    patientFile.setFileId(resultSet.getString("file_id"));
                    patientFile.setHospital(resultSet.getString("hospital"));
                    patientFile.setDiagnosis(resultSet.getString("diagnosis"));
                    patientFile.setTreatment(resultSet.getString("treatment"));
                    patientFile.setLabTests(resultSet.getString("lab_tests"));
                }
            }
            resultSet.close();
            return patientFile;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Chamber getChamber(String id) {
        try {
            String query = "SELECT * FROM chamber WHERE chamber.id = ?";

            ResultSet resultSet;
            Chamber chamber;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                chamber = null;
                if (resultSet.next()) {
                    chamber = new Chamber();
                    chamber.setId(resultSet.getString("id"));
                    chamber.setClinicName(resultSet.getString("clinic_name"));
                }
            }
            resultSet.close();
            return chamber;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Bed getBed(String number) {
        try {
            String query = "SELECT * FROM bed WHERE bed.number = ?";

            ResultSet resultSet;
            Bed bed;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, number);
                resultSet = preparedStatement.executeQuery();
                bed = null;
                if (resultSet.next()) {
                    bed = new Bed();
                    bed.setNumber(resultSet.getString("number"));
                    bed.setChamberId(resultSet.getString("chamber_id"));
                    bed.setIsFree(resultSet.getBoolean("is_free"));
                }
            }
            resultSet.close();
            return bed;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public AdmissionTicket getAdmissionTicket(String ticket_id) {
        try {
            String query = "SELECT * FROM admission_ticket WHERE admission_ticket.ticket_id = ?";

            ResultSet resultSet;
            AdmissionTicket admissionTicket;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, ticket_id);
                resultSet = preparedStatement.executeQuery();
                admissionTicket = null;
                if (resultSet.next()) {
                    admissionTicket = new AdmissionTicket();
                    admissionTicket.setTicketId(resultSet.getString("ticket_id"));
                    admissionTicket.setCreatedAt(resultSet.getDate("created_at"));
                    admissionTicket.setAdmissionClinic(resultSet.getString("admission_clinic"));
                    admissionTicket.setHostClinic(resultSet.getString("host_clinic"));
                    admissionTicket.setPatientChamber(resultSet.getString("patient_chamber"));
                    admissionTicket.setPatientBed(resultSet.getString("patient_bed"));
                    admissionTicket.setAdmissionText(resultSet.getString("admission_text"));
                    admissionTicket.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return admissionTicket;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public DischargeNote getDischargeNote(String note_id) {
        try {
            String query = "SELECT * FROM discharge_note WHERE discharge_note.note_id = ?";

            ResultSet resultSet;
            DischargeNote dischargeNote;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, note_id);
                resultSet = preparedStatement.executeQuery();
                dischargeNote = null;
                if (resultSet.next()) {
                    dischargeNote = new DischargeNote();
                    dischargeNote.setNoteId(resultSet.getString("note_id"));
                    dischargeNote.setCreatedAt(resultSet.getDate("created_at"));
                    dischargeNote.setDischargeText(resultSet.getString("discharge_text"));
                    dischargeNote.setAdmissionClinic(resultSet.getString("admission_clinic"));
                    dischargeNote.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return dischargeNote;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Billing getBilling(String billing_id) {
        try {
            String query = "SELECT * FROM billing WHERE billing.billing_id = ?";

            ResultSet resultSet;
            Billing billing;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, billing_id);
                resultSet = preparedStatement.executeQuery();
                billing = null;
                if (resultSet.next()) {
                    billing = new Billing();
                    billing.setBillingId(resultSet.getString("billing_id"));
                    billing.setCreatedAt(resultSet.getDate("created_at"));
                    billing.setPrice(resultSet.getFloat("price"));
                }
            }
            resultSet.close();
            return billing;
        } catch (SQLException e) {
            return null;
        }
    }

    public User getUser(String username) {
        try {
            String query = "SELECT * FROM user WHERE user.user_name = ?";

            ResultSet resultSet;
            User user;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setUsername(resultSet.getString("user_name"));
                    user.setHospital_afm(resultSet.getString("hospital_afm"));
                    user.setFirst_name(resultSet.getString("first_name"));
                    user.setLast_name(resultSet.getString("last_name"));
                    user.setBirth_date(resultSet.getDate("birth_date"));
                    user.setPassword(resultSet.getString("password"));
                    user.setSpecification(resultSet.getString("specification"));
                }
            }
            resultSet.close();
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    public Doctor getDoctor(String username) {
        try {
            String query = "SELECT * FROM doctor WHERE doctor.user_name = ?";

            ResultSet resultSet;
            Doctor doctor;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                doctor = null;
                if (resultSet.next()) {
                    doctor = new Doctor();
                    doctor.setUsername(resultSet.getString("user_name"));
                    doctor.setSector(resultSet.getString("sector"));
                    doctor.setClinic(resultSet.getString("clinic"));
                }
            }
            resultSet.close();
            return doctor;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Transfer getTransfer(Timestamp id, String patient_amka) {
        try {
            String query = "SELECT * FROM transfer WHERE transfer.id = ? AND transfer.patient_amka = ?";

            ResultSet resultSet;
            Transfer transfer;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setTimestamp(1, id);
                preparedStatement.setString(2, patient_amka);
                resultSet = preparedStatement.executeQuery();
                transfer = null;
                if (resultSet.next()) {
                    transfer = new Transfer();
                    transfer.setId(resultSet.getTimestamp("id"));
                    transfer.setAuthorisedBy(resultSet.getString("authorised_by"));
                    transfer.setPatientAmka(resultSet.getString("patient_amka"));
                    transfer.setSourceClinic(resultSet.getString("source_clinic"));
                    transfer.setDestinationClinic(resultSet.getString("destination_clinic"));
                    transfer.setStage(resultSet.getString("stage"));
                }
            }
            resultSet.close();
            return transfer;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PatientTransferOffice getPatientTransferOffice(String number) {
        try {
            String query = "SELECT * FROM patient_transfer_office WHERE patient_transfer_office.number = ?";

            ResultSet resultSet;
            PatientTransferOffice patientTransferOffice;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, number);
                resultSet = preparedStatement.executeQuery();
                patientTransferOffice = null;
                if (resultSet.next()) {
                    patientTransferOffice = new PatientTransferOffice();
                    patientTransferOffice.setNumber(resultSet.getString("number"));
                    patientTransferOffice.setHospitalAfm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return patientTransferOffice;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public TransferOfficeAgent getTransferOfficeAgent(String username) {
        try {
            String query = "SELECT * FROM transfer_office_agent WHERE transfer_office_agent.user_name = ?";

            ResultSet resultSet;
            TransferOfficeAgent transferOfficeAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                transferOfficeAgent = null;
                if (resultSet.next()) {
                    transferOfficeAgent = new TransferOfficeAgent();
                    transferOfficeAgent.setUsername(resultSet.getString("user_name"));
                    transferOfficeAgent.setOfficeNumber(resultSet.getString("office_number"));
                }
            }
            resultSet.close();
            return transferOfficeAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Lab getLab(String name, String hospital_afm) {
        try {
            String query = "SELECT * FROM lab WHERE lab.name = ? AND lab.hospital_afm = ?";

            ResultSet resultSet;
            Lab lab;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, hospital_afm);
                resultSet = preparedStatement.executeQuery();
                lab = null;
                if (resultSet.next()) {
                    lab = new Lab();
                    lab.setName(resultSet.getString("name"));
                    lab.setHospital_afm(resultSet.getString("hospital_afm"));
                }
            }
            resultSet.close();
            return lab;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public LabAgent getLabAgent(String username) {
        try {
            String query = "SELECT * FROM lab_agent WHERE lab_agent.user_name = ?";

            ResultSet resultSet;
            LabAgent labAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                labAgent = null;
                if (resultSet.next()) {
                    labAgent = new LabAgent();
                    labAgent.setUsername(resultSet.getString("user_name"));
                    labAgent.setLabName(resultSet.getString("lab_name"));
                }
            }
            resultSet.close();
            return labAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public ClinicAgent getClinicAgent(String username) {
        try {
            String query = "SELECT * FROM clinic_agent WHERE clinic_agent.user_name = ?";

            ResultSet resultSet;
            ClinicAgent clinicAgent;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                clinicAgent = null;
                if (resultSet.next()) {
                    clinicAgent = new ClinicAgent();
                    clinicAgent.setUsername(resultSet.getString("user_name"));
                    clinicAgent.setClinic(resultSet.getString("clinic_name"));
                }
            }
            resultSet.close();
            return clinicAgent;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public ClinicAgentPost getClinicAgentPost(String postId) {
        try {
            String query = "SELECT * FROM clinic_agent_post WHERE clinic_agent_post.post_id = ?";

            ResultSet resultSet;
            ClinicAgentPost clinicAgentPost;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, postId);
                resultSet = preparedStatement.executeQuery();
                clinicAgentPost = null;
                if (resultSet.next()) {
                    clinicAgentPost = new ClinicAgentPost();
                    clinicAgentPost.setId(resultSet.getString("post_id"));
                    clinicAgentPost.setClinicName(resultSet.getString("clinic_name"));
                    clinicAgentPost.setAuthor(resultSet.getString("user_name"));
                    clinicAgentPost.setTitle(resultSet.getString("title"));
                    clinicAgentPost.setText(resultSet.getString("post_text"));
                    clinicAgentPost.setCreatedAt(resultSet.getTimestamp("created_at"));
                }
            }
            resultSet.close();
            return clinicAgentPost;
        } catch (SQLException e) {
            return null;
        }
    }

    public int setStageToFinal(String noteId) {
        int queryStatus = 0;
        String query = "UPDATE discharge_note SET discharge_note.stage = 2 WHERE discharge_note.note_id = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, noteId);
            queryStatus = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: MySQL UPDATE failure");
        }
        return queryStatus;
    }

    public String getPendingAdmissionTickets(String hospitalAfm) {
        int pendingAdmissionTickets = 0;
        String query = "SELECT COUNT(*) AS count FROM admission_ticket " +
                "INNER JOIN clinic ON admission_ticket.admission_clinic = clinic.name " +
                "OR admission_ticket.host_clinic = clinic.name " +
                "WHERE clinic.hospital_afm = ? " +
                "AND admission_ticket.stage = 1;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pendingAdmissionTickets = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Error: MySQL admission tickets fetching failed");
        }
        return String.valueOf(pendingAdmissionTickets);
    }

    public String getClinicPosts(String clinicId, String hospitalAfm) {
        int clinicPosts = 0;
        String query = "SELECT COUNT(*) as count " +
                "FROM clinic_agent_post " +
                "INNER JOIN clinic ON clinic_agent_post.clinic_name = clinic.name " +
                "WHERE clinic_agent_post.clinic_name = ? " +
                "AND clinic.hospital_afm = ?;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, clinicId);
            preparedStatement.setString(2, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clinicPosts = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Error: MySQL clinic posts fetching failed");
        }
        return String.valueOf(clinicPosts);
    }

    public String getTransferPendingAdmissionTickets(String hospitalAfm) {
        int transferPendingAdmissionTickets = 0;
        String query = "SELECT count(*) AS count FROM admission_ticket INNER JOIN patient_file " +
                       "ON admission_ticket.ticket_id = patient_file.file_id " +
                       "WHERE patient_file.hospital = ? " +
                       "AND admission_ticket.stage = 2;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                transferPendingAdmissionTickets = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Error: MySQL transfer admission tickets fetching failed");
        }
        return String.valueOf(transferPendingAdmissionTickets);
    }

    public String getTransferPendingDischargeNotes(String hospitalAfm) {
        int transferPendingDischargeNotes = 0;
        String query = "SELECT COUNT(*) as count FROM discharge_note " +
                       "INNER JOIN patient_file on discharge_note.note_id = patient_file.file_id " +
                       "WHERE patient_file.hospital = ? " +
                       "AND discharge_note.stage = 1;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, hospitalAfm);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                transferPendingDischargeNotes = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("Error: MySQL transfer discharge notes fetching failed");
        }
        return String.valueOf(transferPendingDischargeNotes);
    }

    public ObservableList<DischargeNoteConfirmationScreenTableItem> getDischargeNoteConfirmationScreenTableItems(String hospital) {
        try {
            String query = "SELECT " +
                           "patient.amka AS amka, " +
                           "discharge_note.note_id AS fileId, " +
                           "patient.first_name AS firstName, " +
                           "patient.last_name AS lastName, " +
                           "patient_file.hospital AS hospital, " +
                           "discharge_note.admission_clinic AS clinic, " +
                           "admission_ticket.created_at AS admissionDate, " +
                           "discharge_note.created_at AS dischargeDate, " +
                           "discharge_note.stage AS stage " +
                           "FROM discharge_note " +
                           "INNER JOIN patient_file ON discharge_note.note_id = patient_file.file_id " +
                           "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                           "INNER JOIN admission_ticket ON discharge_note.note_id = admission_ticket.ticket_id " +
                           "WHERE patient_file.hospital = ? and discharge_note.stage = 1;";

            ResultSet resultSet;
            DischargeNoteConfirmationScreenTableItem dischargeNoteConfirmationScreenTableItem;
            ObservableList<DischargeNoteConfirmationScreenTableItem> dischargeNoteConfirmationScreenTableItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, hospital);
                resultSet = preparedStatement.executeQuery();
                dischargeNoteConfirmationScreenTableItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    dischargeNoteConfirmationScreenTableItem = new DischargeNoteConfirmationScreenTableItem();
                    dischargeNoteConfirmationScreenTableItem.setAmka(resultSet.getString("amka"));
                    dischargeNoteConfirmationScreenTableItem.setFileId(resultSet.getString("fileId"));
                    dischargeNoteConfirmationScreenTableItem.setFirstName(resultSet.getString("firstName"));
                    dischargeNoteConfirmationScreenTableItem.setLastName(resultSet.getString("lastName"));
                    dischargeNoteConfirmationScreenTableItem.setHospital(resultSet.getString("hospital"));
                    dischargeNoteConfirmationScreenTableItem.setClinic(resultSet.getString("clinic"));
                    dischargeNoteConfirmationScreenTableItem.setAdmissionDate(resultSet.getTimestamp("admissionDate"));
                    dischargeNoteConfirmationScreenTableItem.setDischargeDate(resultSet.getTimestamp("dischargeDate"));
                    dischargeNoteConfirmationScreenTableItem.setStage(resultSet.getString("stage"));
                    dischargeNoteConfirmationScreenTableItems.add(dischargeNoteConfirmationScreenTableItem);
                }
            }
            resultSet.close();
            return dischargeNoteConfirmationScreenTableItems;
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<PostListScreenTableItem> getPostListScreenTableItems(String postClinic) {
        try {
            String query = "SELECT " +
                           "clinic_agent_post.post_id AS postId, " +
                           "clinic_agent_post.created_at AS creation, " +
                           "clinic_agent_post.user_name AS author, " +
                           "clinic_agent_post.title AS title " +
                           "FROM clinic_agent_post " +
                           "WHERE clinic_agent_post.clinic_name = ?;";

            ResultSet resultSet;
            PostListScreenTableItem postListScreenTableItem;
            ObservableList<PostListScreenTableItem> postListScreenTableItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, postClinic);
                resultSet = preparedStatement.executeQuery();
                postListScreenTableItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    postListScreenTableItem = new PostListScreenTableItem();
                    postListScreenTableItem.setPostDatetime(resultSet.getTimestamp("creation"));
                    postListScreenTableItem.setPostAuthor(resultSet.getString("author"));
                    postListScreenTableItem.setPostTitle(resultSet.getString("title"));
                    postListScreenTableItem.setPostId(resultSet.getString("postId"));
                    postListScreenTableItems.add(postListScreenTableItem);
                }
            }
            resultSet.close();
            return postListScreenTableItems;
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<InitialDoctorScreenListItem> getInitialDoctorScreenListItems(String hospital, String admissionClinic) {
        try {
            String query = "select patient.amka as amka, patient.first_name as first_name, patient.last_name as last_name, " +
                           "admission_ticket.host_clinic as host_clinic, admission_ticket.patient_chamber as patient_chamber " +
                           "from patient_file inner join admission_ticket on patient_file.file_id = admission_ticket.ticket_id " +
                           "inner join patient on patient_file.patient_amka = patient.amka " +
                           "where patient_file.hospital = ? and admission_ticket.admission_clinic = ?;";
            ResultSet resultSet;
            InitialDoctorScreenListItem initialDoctorScreenListItem;
            ObservableList<InitialDoctorScreenListItem> initialDoctorScreenListItems;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1,hospital);
                preparedStatement.setString(2,admissionClinic);
                resultSet = preparedStatement.executeQuery();
                initialDoctorScreenListItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    initialDoctorScreenListItem = new InitialDoctorScreenListItem();
                    initialDoctorScreenListItem.setAmka(resultSet.getString("amka"));
                    initialDoctorScreenListItem.setFirstName(resultSet.getString("first_name"));
                    initialDoctorScreenListItem.setLastName(resultSet.getString("last_name"));
                    initialDoctorScreenListItem.setHostClinic(resultSet.getString("host_clinic"));
                    initialDoctorScreenListItem.setPatientChamber(resultSet.getString("patient_chamber"));
                    initialDoctorScreenListItems.add(initialDoctorScreenListItem);
                }
            }
            resultSet.close();
            return initialDoctorScreenListItems;
        } catch (SQLException e) {
            return null;
        }
    }

    public AdmissionTicket getAdmissionTicketByAmka(String amka) {
        try {
            String query = "select admission_ticket.ticket_id from admission_ticket " +
                           "inner join patient_file on patient_file.file_id = admission_ticket.ticket_id " +
                           "where patient_file.patient_amka = ? order by admission_ticket.created_at DESC " +
                           "limit 1;";

            ResultSet resultSet;
            AdmissionTicket admissionTicket;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                resultSet = preparedStatement.executeQuery();
                admissionTicket = null;
                if (resultSet.next()) {
                    admissionTicket = new AdmissionTicket();
                    admissionTicket.setTicketId(resultSet.getString("ticket_id"));
                }
            }
            resultSet.close();
            return admissionTicket;
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<String> getAllClinicNamesOfDoctor(String username) {
        try {
            String query = "select clinic.name from user " +
                           "inner join clinic " +
                           "on clinic.hospital_afm = user.hospital_afm " +
                           "where user.user_name = ?;";
            ResultSet resultSet;
            Clinic clinic;
            ObservableList<String> clinics;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                clinics = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    clinic = new Clinic();
                    clinic.setName(resultSet.getString("name"));
                    clinics.add(clinic.getName());
                }
            }
            resultSet.close();
            return clinics;
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<AdmissionTicketConfirmationScreenListItem> getAdmissionTicketConfirmationScreenListItem(String hospitalAfm){
        try {
            String query = "SELECT " +
                    "patient.amka AS amka, " +
                    "patient.first_name AS first_name, " +
                    "patient.last_name AS last_name, " +
                    "admission_ticket.admission_clinic AS source_clinic, " +
                    "admission_ticket.host_clinic AS destination_clinic, " +
                    "admission_ticket.stage AS stage, " +
                    "admission_ticket.ticket_id AS id " +
                    "FROM admission_ticket INNER JOIN patient_file " +
                    "ON admission_ticket.ticket_id = patient_file.file_id " +
                    "INNER JOIN patient ON patient_file.patient_amka = patient.amka " +
                    "WHERE patient_file.hospital = ? " +
                    "AND admission_ticket.stage = 2;";
            ResultSet resultSet;
            AdmissionTicketConfirmationScreenListItem admissionTicketConfirmationScreenListItem;
            ObservableList<AdmissionTicketConfirmationScreenListItem> admissionTicketConfirmationScreenListItems;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
                preparedStatement.setString(1, hospitalAfm);
                resultSet = preparedStatement.executeQuery();
                admissionTicketConfirmationScreenListItems = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    admissionTicketConfirmationScreenListItem = new AdmissionTicketConfirmationScreenListItem();
                    admissionTicketConfirmationScreenListItem.setAmka(resultSet.getString("amka"));
                    admissionTicketConfirmationScreenListItem.setFirstName(resultSet.getString("first_name"));
                    admissionTicketConfirmationScreenListItem.setLastName(resultSet.getString("last_name"));
                    admissionTicketConfirmationScreenListItem.setSourceClinic(resultSet.getString("source_clinic"));
                    admissionTicketConfirmationScreenListItem.setDestinationClinic(resultSet.getString("destination_clinic"));
                    admissionTicketConfirmationScreenListItem.setStage(resultSet.getString("stage"));
                    admissionTicketConfirmationScreenListItem.setId(resultSet.getTimestamp("id"));
                    admissionTicketConfirmationScreenListItems.add(admissionTicketConfirmationScreenListItem);
                }
            }
            resultSet.close();

            return admissionTicketConfirmationScreenListItems;
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<AdmissionTicketDetailsScreenListItem> getAdmissionTicketDetailsScreenListItems(String amka, String ticketId) {
        String query = "select patient.first_name as first_name, patient.last_name as last_name, " +
                       "patient.birth_date as birth_date, patient.gender as gender, admission_ticket.admission_text as admission_text " +
                       "from patient_file " +
                       "inner join patient on patient.amka = patient_file.patient_amka " +
                       "inner join admission_ticket on patient_file.file_id = admission_ticket.ticket_id " +
                       "where patient.amka = ? " +
                       "and admission_ticket.ticket_id = ?;";
        ResultSet resultSet;
        AdmissionTicketDetailsScreenListItem admissionTicketDetailsScreenListItem;
        ObservableList<AdmissionTicketDetailsScreenListItem> admissionTicketDetailsScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, amka);
            preparedStatement.setString(2, ticketId);

            resultSet = preparedStatement.executeQuery();
            admissionTicketDetailsScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                admissionTicketDetailsScreenListItem = new AdmissionTicketDetailsScreenListItem();
                admissionTicketDetailsScreenListItem.setFirstName(resultSet.getString("first_name"));
                admissionTicketDetailsScreenListItem.setLastName(resultSet.getString("last_name"));
                admissionTicketDetailsScreenListItem.setBirthDate(resultSet.getDate("birth_date"));
                admissionTicketDetailsScreenListItem.setGender(resultSet.getString("gender"));
                admissionTicketDetailsScreenListItem.setAdmissionText(resultSet.getString("admission_text"));
                admissionTicketDetailsScreenListItems.add(admissionTicketDetailsScreenListItem);
            }
            resultSet.close();
            return admissionTicketDetailsScreenListItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<PendingAdmissionTicketsScreenListItem> getPendingAdmissionTicketsScreenListItems(String hospitalAfm, String clinicName) {
        String query = "select patient.amka as amka, patient.first_name as first_name, patient.last_name as last_name, admission_ticket.created_at as created_at, admission_ticket.ticket_id as ticket_id " +
                       "from patient_file " +
                       "inner join patient on patient_file.patient_amka = patient.amka " +
                       "inner join admission_ticket on patient_file.file_id = admission_ticket.ticket_id " +
                       "where patient_file.hospital = ? and " +
                       "(admission_ticket.host_clinic like ? or admission_ticket.admission_clinic like ?) " +
                       "and admission_ticket.stage = 'CREATED';";
        ResultSet resultSet;
        PendingAdmissionTicketsScreenListItem pendingAdmissionTicketsScreenListItem;
        ObservableList<PendingAdmissionTicketsScreenListItem> pendingAdmissionTicketsScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, hospitalAfm);
            preparedStatement.setString(2, clinicName);
            preparedStatement.setString(3, clinicName);

            resultSet = preparedStatement.executeQuery();
            pendingAdmissionTicketsScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                pendingAdmissionTicketsScreenListItem = new PendingAdmissionTicketsScreenListItem();
                pendingAdmissionTicketsScreenListItem.setAmka(resultSet.getString("amka"));
                pendingAdmissionTicketsScreenListItem.setFirstName(resultSet.getString("first_name"));
                pendingAdmissionTicketsScreenListItem.setLastName(resultSet.getString("last_name"));
                pendingAdmissionTicketsScreenListItem.setCreatedAt(resultSet.getTimestamp("created_at"));
                pendingAdmissionTicketsScreenListItem.setTicketId(resultSet.getString("ticket_id"));
                pendingAdmissionTicketsScreenListItems.add(pendingAdmissionTicketsScreenListItem);
            }
            resultSet.close();
            return pendingAdmissionTicketsScreenListItems;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<PossibleMatchesScreenListItem> getPossibleMatchesScreenListItems(
            String amka, String afm, String firstName, String lastName, String gender, String fatherFirstName, String fatherLastName,
            String motherFirstName, String motherLastName, String birthDate) {

        String query = "select amka, afm, first_name, last_name, gender, father_first_name, mother_first_name, birth_date from patient " +
                       "where (amka like ? or amka is null) " +
                       "and (afm like ? or afm is null) " +
                       "and (first_name like ? or first_name is null) " +
                       "and (last_name like ? or last_name is null) " +
                       "and (gender like ? or gender is null)" +
                       "and (father_first_name like ? or father_first_name is null) " +
                       "and (father_last_name like ? or father_last_name is null) " +
                       "and (mother_first_name like ? or mother_first_name is null) " +
                       "and (mother_last_name like ? or mother_last_name is null) " +
                       "and (birth_date like ? or birth_date is null);";
        ResultSet resultSet;
        PossibleMatchesScreenListItem possibleMatchesScreenListItem;
        ObservableList<PossibleMatchesScreenListItem> possibleMatchesScreenListItems;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            if (!amka.equals("")) {
                preparedStatement.setString(1, amka);
            } else {
                preparedStatement.setString(1, "%");
            }
            if (!afm.equals("")) {
                preparedStatement.setString(2, afm);
            } else {
                preparedStatement.setString(2, "%");
            }
            if (!firstName.equals("")) {
                preparedStatement.setString(3, firstName);
            } else {
                preparedStatement.setString(3, "%");
            }
            if (!lastName.equals("")) {
                preparedStatement.setString(4, lastName);
            } else {
                preparedStatement.setString(4, "%");
            }
            if (!gender.equals("")) {
                preparedStatement.setString(5, gender);
            } else {
                preparedStatement.setString(5, "%");
            }
            if (!fatherFirstName.equals("")) {
                preparedStatement.setString(6, fatherFirstName);
            } else {
                preparedStatement.setString(6, "%");
            }
            if (!fatherLastName.equals("")) {
                preparedStatement.setString(7, fatherLastName);
            } else {
                preparedStatement.setString(7, "%");
            }
            if (!motherFirstName.equals("")) {
                preparedStatement.setString(8, motherFirstName);
            } else {
                preparedStatement.setString(8, "%");
            }
            if (!motherLastName.equals("")) {
                preparedStatement.setString(9, motherLastName);
            } else {
                preparedStatement.setString(9, "%");
            }
            if (!birthDate.equals("")) {
                preparedStatement.setString(10, birthDate);
            } else {
                preparedStatement.setString(10, "%");
            }
            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();
            possibleMatchesScreenListItems = FXCollections.observableArrayList();

            while (resultSet.next()) {
                possibleMatchesScreenListItem = new PossibleMatchesScreenListItem();
                possibleMatchesScreenListItem.setFirstName(resultSet.getString("first_name"));
                possibleMatchesScreenListItem.setLastName(resultSet.getString("last_name"));
                possibleMatchesScreenListItem.setAmka(resultSet.getString("amka"));
                possibleMatchesScreenListItem.setAfm(resultSet.getString("afm"));
                possibleMatchesScreenListItem.setBirthDate(resultSet.getString("birth_date"));
                possibleMatchesScreenListItem.setGender(resultSet.getString("gender"));
                possibleMatchesScreenListItem.setFatherFirstName(resultSet.getString("father_first_name"));
                possibleMatchesScreenListItem.setMotherFirstName(resultSet.getString("mother_first_name"));
                possibleMatchesScreenListItems.add(possibleMatchesScreenListItem);
            }
            resultSet.close();
            return possibleMatchesScreenListItems;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<String> getChambersWithFreeBeds(String clinic, String hospital) {
        String query = "select chamber.id as id " +
                       "from bed " +
                       "inner join chamber " +
                       "on bed.chamber_id = chamber.id " +
                       "where chamber.clinic_name = ? " +
                       "and chamber.clinic_hospital = ? " +
                       "and bed.is_free = '0' " +
                       "group by chamber.id;";
        ResultSet resultSet;
        ObservableList<String> chambersWithFreeBeds;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, clinic);
            preparedStatement.setString(2, hospital);

            resultSet = preparedStatement.executeQuery();
            chambersWithFreeBeds = FXCollections.observableArrayList();

            while (resultSet.next()) {
                chambersWithFreeBeds.add(resultSet.getString("id"));
            }
            resultSet.close();
            return chambersWithFreeBeds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<String> getFreeBedsOfChamber(String clinic, String hospital, String chamber) {
        try {
            String query = "select bed.number as number " +
                           "from bed " +
                           "inner join chamber " +
                           "on bed.chamber_id = chamber.id " +
                           "where chamber.id = ? " +
                           "and chamber.clinic_name = ? " +
                           "and chamber.clinic_hospital = ? " +
                           "and bed.is_free = '0';";
            ResultSet resultSet;
            ObservableList<String> freeBeds;

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){

                preparedStatement.setString(1, chamber);
                preparedStatement.setString(2, clinic);
                preparedStatement.setString(3, hospital);

                resultSet = preparedStatement.executeQuery();
                freeBeds = FXCollections.observableArrayList();

                while (resultSet.next()) {
                    freeBeds.add(resultSet.getString("number"));
                }
            }
            resultSet.close();
            return freeBeds;
        } catch (SQLException e) {
            return null;
        }
    }

    public int allocateBed(String number) {
        int queryStatus = 0;
        String query = "update bed set is_free = 1 where bed.number = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, number);
            queryStatus = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryStatus;
    }

    public int updateTicket(String ticketId, String chamber, String bed) {
        int queryStatus = 0;
        String query = "update admission_ticket set patient_chamber = ?, patient_bed = ?, stage = 2 where ticket_id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, chamber);
            preparedStatement.setString(2, bed);
            preparedStatement.setString(3, ticketId);
            queryStatus = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryStatus;
    }

    //be advised that this function updates only the latest patient file.
    // not all of them.
    public void updateTreatment(String Text, String amka, String file_id) {
        try {
            System.out.println(amka + " " + file_id);
            String query = "update patient_file set patient_file.treatment = ? where patient_file.patient_amka = ? and patient_file.file_id = ?;";

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1,Text);
                preparedStatement.setString(2,amka);
                preparedStatement.setString(3,file_id);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void finalConfirmationOfTemporaryAdmissionTicket(Timestamp id, String amka){
        try {
            String query = "UPDATE transfer SET transfer.stage = \"APPROVED\" WHERE transfer.id = ? AND transfer.patient_amka = ?;";

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setTimestamp(1, id);
                preparedStatement.setString(2, amka);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public int savePost(String clinicName, String userName, String date, String title, String post) {
        int resultSet = 1;
        String constSep = "', '";
        String closureParenthesis = "');";
        StringBuilder query = new StringBuilder("INSERT INTO clinic_agent_post (post_id, clinic_name, user_name, created_at, title, post_text) VALUES ('");
        String postId = random(19);
        query.append(postId).append(constSep).append(clinicName).append(constSep).append(
                userName).append(constSep).append(date).append(constSep).append(title).append(
                constSep).append(post.replace("\n", " ").replace("\r", " ")).append(closureParenthesis);
        String uploadPost = query.toString();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(uploadPost)) {
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static char[] alphanumericAlphabet() {
        char[] my_list = IntStream.concat(
                IntStream.concat(
                        IntStream.rangeClosed('0', '9'),
                        IntStream.rangeClosed('A', 'Z')
                ),
                IntStream.rangeClosed('a', 'z')
        ).mapToObj(c -> (char) c+"").collect(Collectors.joining()).toCharArray();
        return my_list;
    }

    public static String random(final int numChars) {
        Random r = new Random();
        String alpha = new String(alphanumericAlphabet());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numChars; i++) {
            sb.append((char) (alpha.charAt(r.nextInt(alpha.length()))));
        }
        return sb.toString();
    }

    public void insertDischargeNote(String note_id, String date , String discharge_text,String clinic) {
        try {
            String query = "insert into discharge_note (note_id,created_at,discharge_text,admission_clinic,stage)" +
                    " values (?,?,?,?,\"SENT\")";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1,note_id);
                preparedStatement.setString(2,date);
                preparedStatement.setString(3,discharge_text);
                preparedStatement.setString(4,clinic);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public  PatientFile getFileIdFromAmka(String amka) {
        try {
            String query = "select file_id from patient_file " +
                    "where patient_amka =? ";

            ResultSet resultSet;
            PatientFile patientFile;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, amka);
                resultSet = preparedStatement.executeQuery();
                patientFile = null;
                if (resultSet.next()) {
                    patientFile = new PatientFile();
                    patientFile.setFileId(resultSet.getString("file_id"));
                }
            }
            resultSet.close();
            return patientFile;
        } catch (SQLException e) {
            return null;
        }
    }

    public void openConnection() {
        try {
            System.out.println("Setting up connection.");
            Properties connection_properties = new Properties();
            connection_properties.load(new FileInputStream("MySQL/connection.properties"));
            String url_property = connection_properties.getProperty("url");
            String user_property = connection_properties.getProperty("user");
            String password_property = connection_properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConnection(DriverManager.getConnection(url_property, user_property, password_property));
            System.out.println("Connection established successfully with the database server.");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        ICRUDImpl.connection = connection;
    }
}
