package com.aceba1.dnd.calc;

import com.aceba1.util.Die;

public class DamageDice extends Die {

  public final static String diceRegex = "^(0*[1-9]+[0-9]*|)d(0*[1-9]+[0-9]*)$";

  private final String dice;

  public DamageDice(String dice) {
    this.dice = dice;
  }

  @Override
  public int roll() {
    return roll(dice);
  }

  @Override
  public String toString() {
    return dice;
  }

  public static boolean testFormat(String dice) {
    return dice.matches(diceRegex);
  }

  public static String format(int count, int range) {
    return (count > 1 ? count : "") + "d" + range;
  }

  public static int roll(String dice) {
    // Arguments are pre-checked (trusted code), otherwise uncomment below
    //  if (!testFormat(dice)) throw new IllegalArgumentException("Input not of format '{X?}d{Y}");

    String[] sides = dice.split("d", 2);

    int count = 1;
    if (sides[0].length() != 0)
      count = Integer.parseInt(sides[0]);
    int range = Integer.parseInt(sides[1]);

    int sum = 0;
    for (int i = 0; i < count; i++) {
      sum += roll(range);
    }
    return sum;
  }
}
