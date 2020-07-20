import java.text.SimpleDateFormat;
import java.util.Date;

public class Medication {
  public static final String           NEWLINE = System.lineSeparator();
  public static final SimpleDateFormat DF      = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");

  private String        medicationName;
  private String        medicationClass;
  private int           dosage;
  private Date          timeTaken;
  private Date          timeEffective;
  private double        effectivityTime;
  private PainReduction effectivity;

  public static class Builder {
    private String        medicationName;
    private String        medicationClass;
    private int           dosage;
    private Date          timeTaken;
    private Date          timeEffective;
    private double        effectivityTime;
    private PainReduction effectivity;

    public Builder() {
    }

    public Builder medicationName(String val) {
      medicationName = val;
      return this;
    }

    public Builder medicationClass(String val) {
      medicationClass = val;
      return this;
    }

    public Builder dosage(int val) {
      dosage = val;
      return this;
    }

    public Builder timeTaken(Date val) {
      timeTaken = val;
      return this;
    }

    public Builder timeEffective(Date val) {
      timeEffective = val;
      return this;
    }

    public Builder effectivity(PainReduction val) {
      effectivity = val;
      return this;
    }

    public Medication build() {
      return new Medication(this);
    }
  }

  private Medication(Builder builder) {
    medicationName = builder.medicationName;
    medicationClass = builder.medicationClass;
    dosage = builder.dosage;
    timeTaken = builder.timeTaken;
    timeEffective = builder.timeEffective;
    effectivityTime = (timeEffective.getTime() - timeTaken.getTime()) / 3600000.00;
    effectivity = builder.effectivity;
  }

  public String getRawData() {
    return "Medication Name: " + medicationName + NEWLINE + "Medication Class: " + medicationClass + NEWLINE
        + "Dosage: " + dosage + NEWLINE + "Time Taken: " + DF.format(timeTaken) + NEWLINE + "Time Effective: "
        + DF.format(timeEffective) + NEWLINE + (effectivity != null ? "Effectivity: " + effectivity + NEWLINE : "");
  }

  public String getMedicationName() {
    return medicationName;
  }

  public String getMedicationClass() {
    return medicationClass;
  }

  public int getDosage() {
    return dosage;
  }

  public double getEffectivityTime() {
    return effectivityTime;
  }

}
