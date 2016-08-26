/**
  *  This class converts different units
  *  using the convertibles.
  *
  *  @author Stephanie Remy
  *  @version 1.0
  */
public class MetricConverter  {
    private int capacity  =  6;
    private Convertibles[] list;
    private Convertibles[] temp;
    private int numConverts;
    private boolean isIn  =  true;
    /**
      *  Constructor for MetricConverter. Creates a list of
      *  new Convertibles.
      *
      *
      *
      */
    public MetricConverter()  {
        list  =  new Convertibles[capacity];
        numConverts  =  0;
        Mile one  =  new Mile("Mile");
        double ratez1 =  one.getConversionRate();
        String si1 =  one.specialInformation();
        addUnit(ratez1 , "Mile" , si1);

        Foot two  =  new Foot("Foot");
        double ratez2 =  two.getConversionRate();
        String si2 =  two.specialInformation();
        addUnit(ratez2 , "Foot" , si2);

        Inch three  =  new Inch("Inch");
        double ratez3 =  three.getConversionRate();
        String si3 =  three.specialInformation();
        addUnit(ratez3 , "Inch" , si3);

        Yard four  =  new Yard("Yard");
        double ratez4 =  four.getConversionRate();
        String si4 =  four.specialInformation();
        addUnit(ratez4 , "Yard" , si4);

        Kilometer five  =  new Kilometer("Kilometer");
        double ratez5 =  five.getConversionRate();
        String si5 =  five.specialInformation();
        addUnit(ratez5 , "Kilometer" , si5);
        this.temp = new Convertibles[2 * list.length];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }
    /**
      *  the addUnit method adds a new unit
      *  to the list of convertibles.
      *
      *  @param double rate - the rate of conversion of the other type.
      *  @param String name - the name of the unit.
      *  @param String fact- the fact of the unit.
      *
      */
    public void addUnit(double rate ,  String name ,  String fact) {
        this.temp = new Convertibles[2 * list.length];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }
        list = temp;
        if (numConverts == list.length) {
            temp = new Convertibles[2 * list.length];
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        String z;
        String[] k  =  new String[temp.length];
        for  (int i  =  0; i < (numConverts); i++) {
            z  =  temp[i].toString();
            k[i]  =  z;
        }
        for  (int i  =  0; i < (numConverts); i++) {
            String u  =  k[i];
            if (u.equals(name))  {
                throw new DuplicateUnitException("DuplicateUnitException: "
                + "That unit with that name already exists. Try again!");
            }
        }
        if (rate < 0)  {
            throw new UnsupportedRateException("UnsupportedRateException:"
            + "the rate cannot be negative");
        }
        Convertibles p  =  new UserCreatedConvertible(rate , name , fact);
        temp[numConverts++]  =  p;
    }
    /**
      *  the isIn method checks if
      *  a unit is in the list of convertibles.
      *
      *
      *  @return boolean - true if in list.
      *
      */
    public boolean isIn()  {
        isIn  =  true;
        return isIn;
    }
    /**
      *  the turnOff method changes the isIn
      *  boolean back to false.
      *
      *
      *  @return boolean isIn- changes it to false
      *  to be able to do test again.
      *
      */
    public boolean turnOff()  {
        isIn  =  false;
        return isIn;
    }
    /**
      *  The convert to meters method converts the right unit to meters
      * @param String name-which unit to convert.
      *  @param double x- the amount to convert.
      *  @return double amount - the amount after converting
      */
    public double convertToMeters(String name ,  double x)  {
        double conversion  =  0;
        if (isIn) {
            if (name.equals("Mile"))  {
                Mile converz  =  new Mile(name);
                conversion  =  converz.convertToMeters(x);
                return conversion;
            } else if (name.equals("Foot"))  {
                Foot converz  =  new Foot(name);
                conversion  =  converz.convertToMeters(x);
                return conversion;
            } else if (name.equals("Yard"))  {
                Yard converz  =  new Yard(name);
                conversion  =  converz.convertToMeters(x);
                return conversion;
            } else if (name.equals("Inch"))  {
                Inch converz  =  new Inch(name);
                conversion  =  converz.convertToMeters(x);
                return conversion;
            } else if (name.equals("Kilometer"))  {
                Kilometer converz  =  new Kilometer(name);
                conversion  =  converz.convertToMeters(x);
                return conversion;
            } else {
                String z;
                String[] k = new String[temp.length];
                for  (int i = 0; i < (numConverts); i++)  {
                    z = temp[i].toString();
                    k[i] = z;
                }
                int itshere = 0;
                for  (int i = 0; i < (numConverts); i++) {
                    String hz = k[i];
                    if (hz.equals(name)) {
                        itshere = i;
                    }
                }
                for  (int i = 0; i < (numConverts); i++) {
                    conversion = temp[itshere].convertToMeters(x);
                    return conversion;
                }
            }
        } else  {
            throw new UnsupportedUnitException("UnsupportedUnitException: "
            + "Not one of the available units! Try again!");
        }
        return conversion;
    }
    /**
      *  the convertToDifferenceMeasurement method converts a set
      *  amount of the unit
      *  to another unit already defined.
      *  @param double x - the amount to convert
      *  @param String baseUnit - the rate of conversion of the base type
      *  @param String targetUnit - the rate of conversion of the target type
      *  @return double amount - the converted amount.
      */
    public double convertToDifferentUnit(String baseUnit ,
                                         String targetUnit ,  double x) {
        double conversion = 0;
        double cr = 0;
        if (isIn) {
            if (baseUnit.equals("Mile"))  {
                Mile converz =  new Mile(baseUnit);
                if (targetUnit.equals("Foot")) {
                    Foot conver =  new Foot(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Yard")) {
                    Yard conver =  new Yard(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Kilometer")) {
                    Kilometer conver =  new Kilometer(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Inch")) {
                    Inch conver =  new Inch(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere].getConversionRate();
                    }
                }
                conversion = converz.convertToDifferentMeasurement(
                           x , cr);
                return conversion;
            } else if (baseUnit.equals("Foot"))  {
                Foot converz =  new Foot(baseUnit);
                if (targetUnit.equals("Mile")) {
                    Mile conver =  new Mile(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Yard")) {
                    Yard conver =  new Yard(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Kilometer")) {
                    Kilometer conver =  new Kilometer(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Inch")) {
                    Inch conver =  new Inch(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere].getConversionRate();
                    }
                }
                conversion =  converz.convertToDifferentMeasurement(x ,
                 cr);
                return conversion;
            } else if (baseUnit.equals("Yard"))  {
                Yard converz =  new Yard(baseUnit);
                if (targetUnit.equals("Foot")) {
                    Foot conver =  new Foot(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Mile")) {
                    Mile conver =  new Mile(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Kilometer")) {
                    Kilometer conver =  new Kilometer(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Inch")) {
                    Inch conver =  new Inch(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere].getConversionRate();
                    }
                }
                conversion =  converz.convertToDifferentMeasurement(
                x , cr);
                return conversion;
            } else if (baseUnit.equals("Kilometer"))  {
                Kilometer converz =  new Kilometer(baseUnit);
                if (targetUnit.equals("Foot")) {
                    Foot conver =  new Foot(targetUnit);
                    cr =  conver.getConversionRate();
                 } else if (targetUnit.equals("Yard")) {
                    Yard conver =  new Yard(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Mile")) {
                    Mile conver =  new Mile(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Inch")) {
                    Inch conver =  new Inch(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere].getConversionRate();
                    }
                }
                conversion =  converz.convertToDifferentMeasurement(
                           x , cr);
                return conversion;
            } else if (baseUnit.equals("Inch"))  {
                Inch converz =  new Inch(baseUnit);
                if (targetUnit.equals("Foot")) {
                    Foot conver =  new Foot(targetUnit);
                    cr =  conver.getConversionRate();
                  } else if (targetUnit.equals("Yard")) {
                    Yard conver =  new Yard(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Kilometer")) {
                    Kilometer conver =  new Kilometer(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Mile")) {
                    Mile conver =  new Mile(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere].getConversionRate();
                    }
                }
                conversion =  converz.convertToDifferentMeasurement(
                           x , cr);
                return conversion;
            } else {
                String z;
                String[] k = new String[temp.length];
                for  (int i = 0; i < (numConverts); i++) {
                    z = temp[i].toString();
                    k[i] = z;
                }
                int itshere = 0;
                for  (int i = 0; i < (numConverts); i++) {
                    String hz = k[i];
                    if (hz.equals(baseUnit)) {
                        itshere = i;
                    }
                }
                double cr1 = 0;
                for  (int i = 0; i < (numConverts); i++) {
                    cr1 = temp[itshere].getConversionRate();
                }
                if (targetUnit.equals("Foot")) {
                    Foot conver =  new Foot(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Mile")) {
                    Mile conver =  new Mile(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Inch")) {
                    Inch conver =  new Inch(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Yard")) {
                    Yard conver =  new Yard(targetUnit);
                    cr =  conver.getConversionRate();
                } else if (targetUnit.equals("Kilometer")) {
                    Kilometer conver =  new Kilometer(targetUnit);
                    cr =  conver.getConversionRate();
                } else {
                    k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere2 = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(targetUnit)) {
                            itshere2 = i;
                        }
                    }
                    cr = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        cr = temp[itshere2].getConversionRate();
                    }
                }
                conversion =  ((x * cr1) / cr);
                return conversion;
            }
        } else  {
            throw new UnsupportedUnitException("UnsupportedUnitException: "
            + "Not one of the available units! Try again!");
        }
    }
    /**
      *  The getCoolFact method returns a fun fact about the
      *  selected unit.
      * @param String name-name of the unit.
      *  @return String - a fun fact about the unit
      */
    public String getCoolFact(String name)  {
        String fact =  "";
        if (isIn) {
                if (name.equals("Mile"))  {
                    Mile converz =  new Mile(name);
                    fact =  converz.specialInformation();
                    return fact;
                }
                if (name.equals("Foot"))  {
                    Foot converz =  new Foot(name);
                    fact =  converz.specialInformation();
                    return fact;
                }
                if (name.equals("Yard"))  {
                    Yard converz =  new Yard(name);
                    fact =  converz.specialInformation();
                    return fact;
                }
                if (name.equals("Inch"))  {
                    Inch converz =  new Inch(name);
                    fact =  converz.specialInformation();
                    return fact;
                }
                if (name.equals("Kilometer"))  {
                    Kilometer converz =  new Kilometer(name);
                    fact =  converz.specialInformation();
                    return fact;
                } else  {
                    String z;
                    String[] k = new String[temp.length];
                    for  (int i = 0; i < (numConverts); i++) {
                        z = temp[i].toString();
                        k[i] = z;
                    }
                    int itshere = 0;
                    for  (int i = 0; i < (numConverts); i++) {
                        String hz = k[i];
                        if (hz.equals(name)) {
                            itshere = i;
                        }
                    }
                    for  (int i = 0; i < (numConverts); i++) {
                        fact = temp[itshere].specialInformation();
                    }
                    return fact;
                }
        } else  {
            throw new UnsupportedUnitException("UnsupportedUnitException: "
            + "Not one of the available units! Try again!");
        }
    }
    /**
      *  the toString method returns the convertibles in a
      *  String format list.
      *
      *
      *  @return String output - the names of the convertible.
      */
    public String toString()  {
        String output  =  "We offer the following units:\n";
        for (int i = 0; i < numConverts; i++) {
            output +=  list[i].toString() + "\n";
        }
        return output;
    }
    /**
      *  the getNames method returns a string array of
      *  the list.
      *
      *
      *  @return String Array k - the names of the convertibles.
      */
    public String[] getNames()  {
        String z;
        String[] k = new String[numConverts];
        for  (int i = 0; i < (numConverts); i++) {
            z = list[i].toString();
            k[i] = z;
        }
        return k;
    }
}
