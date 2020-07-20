
public class PainSpot {
  private Location  location;
  private Sidedness sidedness;

  /**
   * @param location
   * @param sidedness
   */
  public PainSpot(Location location, Sidedness sidedness) {
    this.location = location;
    this.sidedness = sidedness;
  }

  public String getRawData() {
    return "Location: " + location + HeadacheTracker.NEWLINE + "Sidedness: " + sidedness + HeadacheTracker.NEWLINE;
  }
}
