
public class PainType {
  private CommonPainType commonPainType;
  private String         customPainType;

  /**
   * @param commonPainType
   */
  public PainType(CommonPainType commonPainType) {
    this.commonPainType = commonPainType;
  }

  /**
   * @param customPainType
   */
  public PainType(String customPainType) {
    this.customPainType = customPainType;
  }
  
  public String getRawData(){
    return 
        (customPainType != null ? customPainType : commonPainType).toString();
  }

}
