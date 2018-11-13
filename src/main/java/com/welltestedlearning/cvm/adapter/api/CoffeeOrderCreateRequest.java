package com.welltestedlearning.cvm.adapter.api;

public class CoffeeOrderCreateRequest {
  private String name;
  private String size;
  private String creamer;
  private String sweetener;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getCreamer() {
    return creamer;
  }

  public void setCreamer(String creamer) {
    this.creamer = creamer;
  }

  public String getSweetener() {
    return sweetener;
  }

  public void setSweetener(String sweetener) {
    this.sweetener = sweetener;
  }
}
