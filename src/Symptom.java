public class Symptom {
  private CommonSymptom commonSymptom;
  private String        customSymptom;
  private Phase         phase;

  /**
   * @param commonSymptom
   * @param phase
   */
  public Symptom(CommonSymptom commonSymptom, Phase phase) {
    this.commonSymptom = commonSymptom;
    this.phase = phase;
  }

  /**
   * @param customSymptom
   * @param phase
   */
  public Symptom(String customSymptom, Phase phase) {
    this.customSymptom = customSymptom;
    this.phase = phase;
  }

  public String getRawData() {    
    return 
        "Symptom: " + (customSymptom != null ? customSymptom : commonSymptom) + " - " + phase + HeadacheTracker.NEWLINE;
  }
}
