
public class SelfHelpTreatment {
  private CommonSelfHelpTreatment commonSelfHelpTreatment;
  private String                  customSelfHelpTreatment;
  private PainReduction           effectivity;

  /**
   * @param commonSelfHelpTreatment
   * @param effectivity
   */
  public SelfHelpTreatment(CommonSelfHelpTreatment commonSelfHelpTreatment, PainReduction effectivity) {
    this.commonSelfHelpTreatment = commonSelfHelpTreatment;
    this.effectivity = effectivity;
  }

  /**
   * @param customSelfHelpTreatment
   * @param effectivity
   */
  public SelfHelpTreatment(String customSelfHelpTreatment, PainReduction effectivity) {
    this.customSelfHelpTreatment = customSelfHelpTreatment;
    this.effectivity = effectivity;
  }

  public String getRawData() {
    return "Self Help Treatment: "
        + (customSelfHelpTreatment != null ? customSelfHelpTreatment : commonSelfHelpTreatment) + " - Effectivity: "
        + effectivity + HeadacheTracker.NEWLINE;
  }

  public String getSelfHelpTreatmentName(){
    return (customSelfHelpTreatment != null ? customSelfHelpTreatment : commonSelfHelpTreatment.toString());
  }

  public double getEffectivity() {
    switch (effectivity) {
      case ZERO:
        return 0;
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
}
