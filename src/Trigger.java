public class Trigger {
  private CommonTrigger commonTrigger;
  private String        customTrigger;
  private String        notes;

  /**
   * @param commonTrigger
   * @param notes
   */
  public Trigger(CommonTrigger commonTrigger, String notes) {
    super();
    this.commonTrigger = commonTrigger;
    this.notes = notes;
  }

  /**
   * @param customTrigger
   * @param notes
   */
  public Trigger(String customTrigger, String notes) {
    super();
    this.customTrigger = customTrigger;
    this.notes = notes;
  }
  
  public String getRawData()
  {
    return 
        "Trigger: " + (customTrigger != null ? customTrigger : commonTrigger) + (notes != "" ? " - " + notes : "") + HeadacheTracker.NEWLINE;    
  }

}
