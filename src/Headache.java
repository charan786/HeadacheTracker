import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class Headache {
  public static final String           NEWLINE = System.lineSeparator();
  public static final SimpleDateFormat DF      = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");

  private HeadacheType                 headacheType;
  private Date                         startDate;
  private Date                         endDate;
  private double                       duration;
  private Severity                     severity;
  private PainType                     painType;
  private ArrayList<PainSpot>          painSpots;
  private ArrayList<Symptom>           symptoms;
  private ArrayList<Trigger>           triggers;
  private ArrayList<SelfHelpTreatment> selfHelpTreatments;
  private Medication                   medication;

  public static class Builder {
    private HeadacheType                 headacheType;
    private Date                         startDate;
    private Date                         endDate;
    private double                       duration;
    private Severity                     severity;
    private PainType                     painType;
    private ArrayList<PainSpot>          painSpots;
    private ArrayList<Symptom>           symptoms;
    private ArrayList<Trigger>           triggers;
    private ArrayList<SelfHelpTreatment> selfHelpTreatments;
    private Medication                   medication;

    public Builder() {
    }

    public Builder headacheType(HeadacheType val) {
      headacheType = val;
      return this;
    }

    public Builder startDate(Date val) {
      startDate = val;
      return this;
    }

    public Builder endDate(Date val) {
      endDate = val;
      return this;
    }

    public Builder duration() {
      duration = (endDate.getTime() - startDate.getTime()) / 3600000.00;
      return this;
    }

    public Builder severity(Severity val) {
      severity = val;
      return this;
    }

    public Builder painType(PainType val) {
      painType = val;
      return this;
    }

    public Builder painSpots(ArrayList<PainSpot> val) {
      painSpots = val;
      return this;
    }

    public Builder painSpots() {
      painSpots = new ArrayList<PainSpot>();
      return this;
    }

    public Builder addPainSpot(PainSpot painSpot) {
      painSpots.add(painSpot);
      return this;
    }

    public Builder symptoms(ArrayList<Symptom> val) {
      symptoms = val;
      return this;
    }

    public Builder symptoms() {
      symptoms = new ArrayList<Symptom>();
      return this;
    }

    public Builder addSymptom(Symptom symptom) {
      symptoms.add(symptom);
      return this;
    }

    public Builder triggers(ArrayList<Trigger> val) {
      triggers = val;
      return this;
    }

    public Builder triggers() {
      triggers = new ArrayList<Trigger>();
      return this;
    }

    public Builder addTrigger(Trigger trigger) {
      triggers.add(trigger);
      return this;
    }

    public Builder selfHelpTreatments(ArrayList<SelfHelpTreatment> val) {
      selfHelpTreatments = val;
      return this;
    }

    public Builder selfHelpTreatments() {
      selfHelpTreatments = new ArrayList<SelfHelpTreatment>();
      return this;
    }

    public Builder addSelfHelpTreatment(SelfHelpTreatment selfHelpTreatment) {
      selfHelpTreatments.add(selfHelpTreatment);
      return this;
    }

    public Builder medication(Medication val) {
      medication = val;
      return this;
    }

    public Headache build() {
      return new Headache(this);
    }
  }

  private Headache(Builder builder) {
    headacheType = builder.headacheType;
    startDate = builder.startDate;
    endDate = builder.endDate;
    duration = builder.duration;
    severity = builder.severity;
    painType = builder.painType;
    painSpots = builder.painSpots;
    symptoms = builder.symptoms;
    triggers = builder.triggers;
    selfHelpTreatments = builder.selfHelpTreatments;
    medication = builder.medication;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public double getDuration() {
    return duration;
  }

  public Medication getMedication() {
    return medication;
  }

  public ArrayList<SelfHelpTreatment> getSelfHelpTreatments() {
    return selfHelpTreatments;
  }

  public int getSeverity() {
    switch (severity) {
      case ONE:
        return 1;
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return 4;
      case FIVE:
        return 5;
      case SIX:
        return 6;
      case SEVEN:
        return 7;
      case EIGHT:
        return 8;
      case NINE:
        return 9;
      case TEN:
        return 10;
      default:
        return 0;
    }
  }

  public String getRawData() {
    String painSpotsInfo = "";
    String symptomsInfo = "";
    String triggersInfo = "";
    String selfHelpTreatmentsInfo = "";

    for (PainSpot painSpot : painSpots) {
      painSpotsInfo += painSpot.getRawData();
    }
    for (Symptom symptom : symptoms) {
      symptomsInfo += symptom.getRawData();
    }
    for (Trigger trigger : triggers) {
      triggersInfo += trigger.getRawData();
    }
    if (!selfHelpTreatments.isEmpty()) {
      for (SelfHelpTreatment selfHelpTreatement : selfHelpTreatments) {
        selfHelpTreatmentsInfo += selfHelpTreatement.getRawData();
      }
    }

    return "Headache Type: " + headacheType + NEWLINE + "Start Date: " + DF.format(startDate) + NEWLINE + "End Date: "
        + DF.format(endDate) + NEWLINE + "Duration: " + (double) duration + " Hours" + NEWLINE + "Severity: " + severity
        + NEWLINE + "Pain Type: " + painType.getRawData() + NEWLINE + painSpotsInfo + symptomsInfo + triggersInfo
        + selfHelpTreatmentsInfo + medication.getRawData();
  }
}
