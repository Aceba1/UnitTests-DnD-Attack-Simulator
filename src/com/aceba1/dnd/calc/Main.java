package com.aceba1.dnd.calc;

import com.aceba1.util.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("D&D Attack Calculator\n");
    while (true) {
      int ac = Input.getNum("Armor Class: ", 10, 18);
      // Uhh, what's D&D
      int defenseMod = Input.getNum("Defense Mod: ", -50, 50);
      int attackMod = Input.getNum("Attack Mod: ", -50, 50);
      String dice = getDice("Damage Dice: ");

      System.out.println();
      // Do something with this?
      int damage = Calculator.attack(ac, defenseMod, attackMod, dice);
      System.out.println();
    }
  }

  private static String getDice(String promptNoLine) {
    while (true) {
      String input = Input.getLine(promptNoLine);
      if (DamageDice.testFormat(input))
        return input;
      System.out.println("Input not of format {X?}d{Y}");
    }
  }
}
