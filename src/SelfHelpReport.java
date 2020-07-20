
public class SelfHelpReport {
  private SelfHelpTreatment selfHelpTreatment;
  int                       usage;
  double                    totalEffectivity;
  double                    averageEffectivity;

  /**
   * @param selfHelpTreatment
   */
  public SelfHelpReport(SelfHelpTreatment selfHelpTreatment) {
    this.selfHelpTreatment = selfHelpTreatment;
    totalEffectivity = averageEffectivity = selfHelpTreatment.getEffectivity();
    usage = 1;
  }

  public SelfHelpTreatment getSelfHelpTreatment() {
    return selfHelpTreatment;
  }

  public int getUsage() {
    return usage;
  }
  
  public void addEffectivity(double effectivity){
    totalEffectivity += effectivity;
    usage++;
    averageEffectivity = totalEffectivity / usage;
  }
  
  public String getAverageEffectivity()
  {
    if(averageEffectivity >= 3)
      return "Helped a Lot";
    else if (averageEffectivity >= 1)
      return "Helped a Little";
    else if (averageEffectivity >=0)
      return "Didn't Help";
    else
      return "Made it Worse";
  }
}
