package com.welltestedlearning.cvm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COFFEE_ORDERS")
public class CoffeeOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private Long orderNumber;

  private List<CoffeeItem> coffeeItems = new ArrayList<>();

  public int price() {
    int price = 0;
    for (CoffeeItem item : coffeeItems) {
      price += item.price();
    }
    return price;
  }

  public String name() {
    return name;
  }

  public void changeNameTo(String newName) {
    name = newName;
  }

  public void display() {
    for (CoffeeItem item : coffeeItems) {
      System.out.println(item.display());
    }
    System.out.println("Price: " + price());
  }

  public void size(SizeOption sizeOption) {
    coffeeItems.add(new Size(sizeOption));
  }

  public void creamer(CreamerOption creamerOption) {
    coffeeItems.add(new Creamer(creamerOption));
  }

  public void sweetener(SweetenerOption sweetenerOption) {
    coffeeItems.add(new Sweetener(sweetenerOption));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<CoffeeItem> items() {
    return coffeeItems;
  }

  public void updateOrderNumberTo(long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Long orderNumber() {
    return orderNumber;
  }
}
