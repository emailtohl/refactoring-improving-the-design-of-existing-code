package chapter01.ver04;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
  private final String _name; // 姓名
  private final Vector _rentals = new Vector(); // 租借记

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      Rental rental = (Rental) rentals.nextElement();
      frequentRenterPoints += rental.getFrequentRenterPoints();
      // show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t"
          + rental.getCharge() + "\n";
      totalAmount += rental.getCharge();
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints
        + " frequent renter points";
    return result;
  }

}
