import java.text.SimpleDateFormat;

public class Person {
  public static final String           NEWLINE = System.lineSeparator();
  public static final SimpleDateFormat DF      = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");


  protected String name;
  protected int    age;

  /**
   * @param name
   * @param age
   * @param sex
   */
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }
}
