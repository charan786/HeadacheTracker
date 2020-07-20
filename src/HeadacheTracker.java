import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HeadacheTracker {

  public static final String NEWLINE = System.lineSeparator();
  public static final SimpleDateFormat DF = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");

  public static void main(String[] args) throws ParseException {
    Neurologist doctor = new Neurologist("Naveen", 40);
    Patient patient = new Patient("Joe", 35);
    Headache headacheA = new Headache.Builder()
        .headacheType(HeadacheType.MIGRANE)
        .startDate(DF.parse("05/01/2017:07:30:00"))
        .endDate(DF.parse("05/01/2017:11:00:00"))
        .duration()
        .severity(Severity.SEVEN)
        .painType(new PainType(CommonPainType.STABBING))
        .painSpots().addPainSpot(new PainSpot(Location.OCULAR, Sidedness.LEFT_SIDE))
        .symptoms().addSymptom(new Symptom(CommonSymptom.NAUSEA_VOMITING, Phase.PRODROME))
        .addSymptom(new Symptom(CommonSymptom.LIGHT_SENSITIVITY, Phase.CONCURRENT))
        .addSymptom(new Symptom(CommonSymptom.SOUND_SENISITIVITY, Phase.CONCURRENT))
        .addSymptom(new Symptom("Fatigue", Phase.POSTDROME))
        .triggers().addTrigger(new Trigger(CommonTrigger.SMELL, "Fumes From Construction"))
        .addTrigger(new Trigger(CommonTrigger.LIGHT, "Sun Glare"))
        .selfHelpTreatments(new ArrayList<SelfHelpTreatment>())
        .medication(new Medication.Builder()
            .medicationName("MaxAlt")
            .medicationClass("triptan")
            .dosage(5)
            .timeTaken(DF.parse("05/01/2017:09:00:00"))
            .timeEffective(DF.parse("05/01/2017:11:00:00"))
            .build())
        .build();
    Headache headacheB = new Headache.Builder()
        .headacheType(HeadacheType.TENSION)
        .startDate(DF.parse("05/06/2017:18:00:00"))
        .endDate(DF.parse("05/06/2017:21:15:00"))
        .duration()
        .severity(Severity.FIVE)
        .painType(new PainType("dull"))
        .painSpots().addPainSpot(new PainSpot(Location.SUB_OCCIPITAL, Sidedness.BILATERAL))
        .symptoms().addSymptom(new Symptom(CommonSymptom.NECK_PAIN, Phase.CONCURRENT))
        .triggers().addTrigger(new Trigger(CommonTrigger.MISSED_MEALS, ""))
        .selfHelpTreatments().addSelfHelpTreatment(new SelfHelpTreatment(CommonSelfHelpTreatment.PHYSICAL_THERAPY, PainReduction.THREE))
        .medication(new Medication.Builder()
            .medicationName("Anaprox")
            .medicationClass("NSAID")
            .dosage(550)
            .timeTaken(DF.parse("05/06/2017:19:00:00"))
            .timeEffective(DF.parse("05/06/2017:21:15:00"))
            .build())
        .build();    
    Headache headacheC = new Headache.Builder()
        .headacheType(HeadacheType.TENSION)
        .startDate(DF.parse("05/10/2017:16:00:00"))
        .endDate(DF.parse("05/10/2017:21:00:00"))
        .duration()
        .severity(Severity.SIX)
        .painType(new PainType("dull"))
        .painSpots().addPainSpot(new PainSpot(Location.FRONTAL, Sidedness.BILATERAL))
        .addPainSpot(new PainSpot(Location.TEMPORAL, Sidedness.RIGHT_SIDE))
        .symptoms().addSymptom(new Symptom(CommonSymptom.NECK_PAIN, Phase.CONCURRENT))
        .addSymptom(new Symptom("Sinus Congestion", Phase.CONCURRENT))
        .triggers().addTrigger(new Trigger(CommonTrigger.STRESS, ""))
        .selfHelpTreatments()
        .addSelfHelpTreatment(new SelfHelpTreatment(CommonSelfHelpTreatment.BIOFEEDBACK, PainReduction.ZERO))
        .addSelfHelpTreatment(new SelfHelpTreatment(CommonSelfHelpTreatment.PHYSICAL_THERAPY, PainReduction.THREE))
        .medication(new Medication.Builder()
            .medicationName("Anaprox")
            .medicationClass("NSAID")
            .dosage(550)
            .timeTaken(DF.parse("05/10/2017:17:00:00"))
            .timeEffective(DF.parse("05/10/2017:19:00:00"))
            .build())
        .build();
    Headache headacheD = new Headache.Builder()
        .headacheType(HeadacheType.MIGRANE)
        .startDate(DF.parse("05/17/2017:06:00:00"))
        .endDate(DF.parse("05/17/2017:09:00:00"))
        .duration()
        .severity(Severity.SEVEN)
        .painType(new PainType(CommonPainType.PULSATING))
        .painSpots().addPainSpot(new PainSpot(Location.OCULAR, Sidedness.LEFT_SIDE))
        .symptoms().addSymptom(new Symptom(CommonSymptom.NAUSEA_VOMITING, Phase.PRODROME))
        .addSymptom(new Symptom(CommonSymptom.TEARY_REDEYES, Phase.PRODROME))
        .addSymptom(new Symptom(CommonSymptom.VISION_DISTURBANCE, Phase.CONCURRENT))
        .triggers().addTrigger(new Trigger(CommonTrigger.SLEEP, "Lack of Sleep"))
        .selfHelpTreatments()
        .addSelfHelpTreatment(new SelfHelpTreatment(CommonSelfHelpTreatment.REST, PainReduction.ONE))
        .medication(new Medication.Builder()
            .medicationName("MaxAlt")
            .medicationClass("triptan")
            .dosage(5)
            .timeTaken(DF.parse("05/17/2017:06:15:00"))
            .timeEffective(DF.parse("05/17/2017:07:30:00"))
            .build())
        .build();
    patient.addHeadache(headacheA);
    patient.addHeadache(headacheB);
    patient.addHeadache(headacheC);
    patient.addHeadache(headacheD);
    
    System.out.print(doctor.getRawData(patient, DF.parse("05/01/2017:07:30:00"), DF.parse("05/17/2017:09:00:00")));
    System.out.print(doctor.getPatientReport(patient, DF.parse("05/01/2017:07:30:00"), DF.parse("05/17/2017:09:00:00")));
    System.out.print(doctor.getMedicationReport(patient, DF.parse("05/01/2017:07:30:00"), DF.parse("05/17/2017:09:00:00")));
    System.out.print(doctor.getSelfHelpReport(patient, DF.parse("05/01/2017:07:30:00"), DF.parse("05/17/2017:09:00:00")));

  }

}
