import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class Neurologist extends Person {
  private ArrayList<Patient> patients;

  /**
   * @param name
   * @param age
   * @param sex
   */
  public Neurologist(String name, int age) {
    super(name, age);
    patients = new ArrayList<Patient>();
  }

  /**
   * @param name
   * @param age
   * @param sex
   * @param patients
   */
  public Neurologist(String name, int age, ArrayList<Patient> patients) {
    super(name, age);
    this.patients = patients;
  }

  public void addPatient(Patient patient) {
    patients.add(patient);
  }

  public String getRawData(Patient patient, Date start, Date end) {
    return "------------------------------Raw Data------------------------------" + NEWLINE + "Start Date: "
        + DF.format(start) + NEWLINE + "End Date: " + DF.format(end) + NEWLINE + patient.getRawData(start, end)
        + "--------------------------------------------------------------------" + NEWLINE;
  }

  public String getPatientReport(Patient patient, Date start, Date end) {
    ArrayList<Headache> patientHeadaches = patient.getHeadaches(start, end);
    int headacheCount = patientHeadaches.size();
    double totalSeverity = 0;
    double totalDuration = 0;

    for (Headache headache : patientHeadaches) {
      totalSeverity += headache.getSeverity();
      totalDuration += headache.getDuration();
    }

    return "---------------------------Summary Report---------------------------" + NEWLINE + "Start Date: "
        + start.toString() + NEWLINE + "End Date: " + end.toString() + NEWLINE + "Headache Count: " + headacheCount
        + NEWLINE + "Average Severity: " + totalSeverity / headacheCount + NEWLINE + "Average Duration: "
        + totalDuration / headacheCount + NEWLINE
        + "--------------------------------------------------------------------" + NEWLINE;
  }

  public String getMedicationReport(Patient patient, Date start, Date end) {
    ArrayList<Headache> patientHeadaches = patient.getHeadaches(start, end);
    ArrayList<MedicationReport> medicationReports = new ArrayList<MedicationReport>();
    String medicationReportInfo = "";

    for (Headache headache : patientHeadaches) {
      boolean medicationFound = false;

      for (MedicationReport report : medicationReports) {
        if (report.getMedication().getMedicationName() == headache.getMedication().getMedicationName()) {
          medicationFound = true;
          report.addEffectivityTime(headache.getMedication().getEffectivityTime());
        }
      }

      if (!medicationFound) {
        medicationReports.add(new MedicationReport(headache.getMedication()));
      }
    }

    for (MedicationReport report : medicationReports) {
      medicationReportInfo += "Medication Name: " + report.getMedication().getMedicationName() + NEWLINE
          + "Medication Class: " + report.getMedication().getMedicationClass() + NEWLINE + "Dosage: "
          + report.getMedication().getDosage() + NEWLINE + "Average Effectivity Time: "
          + report.getAverageEffectivityTime() + NEWLINE + "Dose Taken: " + report.getDoseTaken() + NEWLINE;
    }

    return "---------------------------Detailed Report-------------------------" + NEWLINE + "Start Date: "
        + start.toString() + NEWLINE + "End Date: " + end.toString() + NEWLINE + medicationReportInfo
        + "--------------------------------------------------------------------" + NEWLINE;
  }

  public String getSelfHelpReport(Patient patient, Date start, Date end) {
    ArrayList<Headache> patientHeadaches = patient.getHeadaches(start, end);
    ArrayList<SelfHelpReport> selfHelpReports = new ArrayList<SelfHelpReport>();
    String selfHelpReportInfo = "";

    for (Headache headache : patientHeadaches) {
      boolean treatmentFound = false;

      for (SelfHelpTreatment treatment : headache.getSelfHelpTreatments()) {
        for (SelfHelpReport report : selfHelpReports) {
          if (report.getSelfHelpTreatment().getSelfHelpTreatmentName() == treatment.getSelfHelpTreatmentName()) {
            treatmentFound = true;
            report.addEffectivity(treatment.getEffectivity());
          }
        }
        if (!treatmentFound) {
          selfHelpReports.add(new SelfHelpReport(treatment));
        }
      }
    }

    for (SelfHelpReport report : selfHelpReports) {
      selfHelpReportInfo += "Self Help Treatment Name: " + report.getSelfHelpTreatment().getSelfHelpTreatmentName() + NEWLINE
          + "Usage: " + report.getUsage() + NEWLINE + "Average Effectivity Time: "
          + report.getAverageEffectivity() + NEWLINE;
    }

    return "----------------------Detailed Self Help Report--------------------" + NEWLINE + "Start Date: "
        + start.toString() + NEWLINE + "End Date: " + end.toString() + NEWLINE + selfHelpReportInfo
        + "--------------------------------------------------------------------" + NEWLINE;
  }

}
