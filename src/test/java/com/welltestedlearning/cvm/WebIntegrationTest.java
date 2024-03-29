package com.welltestedlearning.cvm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void homePageExists() throws Exception {
    mockMvc.perform(get("/index.html"))
           .andExpect(status().isOk())
           .andExpect(content().string(containsString("<title>Coffee</title>")));
  }

  @Test
  public void orderFormExists() throws Exception {
    mockMvc.perform(get("/order-coffee"))
           .andExpect(status().isOk())
           .andExpect(view().name("order-coffee-form"))
           .andExpect(model().attributeExists("coffeeOrderForm"));
  }

}
