package com.welltestedlearning.cvm;

public enum SizeOption {
  SMALL("s", "Small"),
  MEDIUM("m", "Medium"),
  LARGE("l", "Large");

  private final String displayName;
  private final String letter;

  /**
   * One way to convert a letter to an Enum (vs. a static Map, e.g., see SweetenerOption)
   */
  public static SizeOption fromLetter(String letter) {
    for (SizeOption sizeOption : values()) {
      if (sizeOption.letter.equalsIgnoreCase(letter)) {
        return sizeOption;
      }
    }
    return null;
  }

  SizeOption(String letter, String displayName) {
    this.displayName = displayName;
    this.letter = letter;
  }

  @Override
  public String toString() {
    return displayName;
  }
}
