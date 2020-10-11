package com.aceba1.dnd.calc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  private final static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("D&D Attack Calculator\n");
    while (true) {
      int ac = getNum("Armor Class: ", 10, 18);
      // Uhh, what's D&D
      int defenseMod = getNum("Defense Mod: ", -50, 50);
      int attackMod = getNum("Attack Mod: ", -50, 50);
      String dice = getDice("Damage Dice: ");

      System.out.println();
      int damage = Calculator.attack(ac, defenseMod, attackMod, dice);
      // Do something with this?
    }
  }

  private static String getDice(String promptNoLine) {
    while (true) {
      System.out.print(promptNoLine);
      String input = in.nextLine().trim().toLowerCase();
      if (DamageDice.testFormat(input))
        return input;
      System.out.println("Input not of format {X?}d{Y}");
    }
  }

  private static int getNum(String promptNoLine, int min, int max) {
    while (true) {
      System.out.print(promptNoLine);
      try {
        int input = in.nextInt();
        in.nextLine();
        if (input > max || input < min)
          System.out.println("Out of range (" + min + "," + max + ")");
        else
          return input;
      } catch (InputMismatchException e) {
        System.out.println("Input not a number");
        in.nextLine();
      }
    }
  }
}
