package com.aceba1.dnd.calc;

public class Calculator {
  public static int attack(int armorClass, int defenseMod, int attackMod, String damageDice) {
    int hit = DamageDice.roll("d20");
    System.out.println("Rolled " + hit + "...");
    if (hit == 20) {
      int roll1 = DamageDice.roll(damageDice);
      int roll2 = DamageDice.roll(damageDice);
      int total = roll1 + roll2;
      System.out.println("Critical Hit! " +
        roll1 + " + " + roll2 + " = " + total + " damage");
      return total;
    }

    if (hit == 1) {
      System.out.println("Critical Miss!");
      return 0;
    }

    if (hit + attackMod > armorClass + defenseMod) {
      int damage = DamageDice.roll(damageDice);
      System.out.println("Hit " + damage + " damage dealt");
      return damage;
    }

    System.out.println("Miss 0 damage");
    return 0;
  }
}
