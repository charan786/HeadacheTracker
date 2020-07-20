
public class MedicationReport {
  private Medication medication;
  private double     totalEffectivityTime;
  private double     averageEffectivityTime;
  private int        doseTaken;

  /**
   * @param medication
   * @param totalEffectivityTime
   */
  public MedicationReport(Medication medication) {
    this.medication = medication;
    this.totalEffectivityTime = averageEffectivityTime = medication.getEffectivityTime();
    doseTaken = 1;
  }

  public void addEffectivityTime(double effectivityTime)
  {
    totalEffectivityTime += effectivityTime;
    doseTaken++;
    averageEffectivityTime = totalEffectivityTime/doseTaken;
  }
  
  public Medication getMedication() {
    return medication;
  }

  public double getAverageEffectivityTime() {
    return averageEffectivityTime;
  }
  public int getDoseTaken() {
    return doseTaken;
  }
  
}
