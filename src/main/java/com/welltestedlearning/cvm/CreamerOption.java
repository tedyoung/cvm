package com.welltestedlearning.cvm;

import java.util.HashMap;
import java.util.Map;

public enum CreamerOption {

  NONE("n", "None"),
  MILK("m", "Milk"),
  HALF_N_HALF("h", "Half & Half");

  private final String letter;
  private final String displayName;

  private static final Map<String, CreamerOption> LETTER_LOOKUP_MAP;

  static {
    LETTER_LOOKUP_MAP = new HashMap<>();
    for (CreamerOption option : CreamerOption.values()) {
      LETTER_LOOKUP_MAP.put(option.letter, option);
    }
  }

  public static CreamerOption fromLetter(String letter) {
    return LETTER_LOOKUP_MAP.get(letter.toLowerCase());
  }

  CreamerOption(String letter, String displayName) {
    this.letter = letter;
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return displayName;
  }
}
