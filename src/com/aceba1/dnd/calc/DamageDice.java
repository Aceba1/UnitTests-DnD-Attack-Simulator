package com.aceba1.dnd.calc;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.Random;
import java.util.stream.Collectors;

public class DamageDice {

  public final static String diceRegex = "^(0*[1-9]+[0-9]*|)d(0*[1-9]+[0-9]*)$";

  private final static Random random = new Random();

  private String dice;

  public DamageDice(String dice) {
    this.dice = dice;
  }

  public void setDice(String dice) {
    this.dice = dice;
  }

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
    if (!testFormat(dice))
      throw new MissingFormatArgumentException("Input not of format '{X?}d{Y}");

    String[] sides = dice.split("d", 2);

    int count = 1;
    if (sides[0].length() != 0)
      count = Integer.parseInt(sides[0]);
    int range = Integer.parseInt(sides[1]);

    int sum = 0;
    for (int i = 0; i < count; i++) {
      sum += random.nextInt(range) + 1;
    }
    return sum;
  }
}
