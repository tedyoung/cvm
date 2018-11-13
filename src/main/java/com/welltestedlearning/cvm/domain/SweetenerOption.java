package com.welltestedlearning.cvm.domain;

import java.util.HashMap;
import java.util.Map;

public enum SweetenerOption {
  NONE("n", "None"),
  SUGAR("s", "Sugar"),
  SPLENDA("p", "Splenda");

  private static final Map<String, SweetenerOption> LETTER_LOOKUP_MAP;

  static {
    LETTER_LOOKUP_MAP = new HashMap<>();
    for (SweetenerOption option : SweetenerOption.values()) {
      LETTER_LOOKUP_MAP.put(option.letter, option);
    }
  }

  private final String letter;
  private final String displayName;

  SweetenerOption(String letter, String displayName) {
    this.letter = letter;
    this.displayName = displayName;
  }

  public static SweetenerOption fromLetter(String letter) {
    return LETTER_LOOKUP_MAP.get(letter.toLowerCase());
  }

  @Override
  public String toString() {
    return displayName;
  }

}
