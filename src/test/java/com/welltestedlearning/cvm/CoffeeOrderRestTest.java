package com.welltestedlearning.cvm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoffeeOrderRestTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getReturnsJsonContainingPrice() throws Exception {
    MvcResult result = mockMvc.perform(get("/api/coffeeorders/1"))
                              .andExpect(status().isOk())
                              .andReturn();
    String body = result.getResponse().getContentAsString();
    assertThat(body)
        .contains("\"price\"");
  }

  @Test
  public void getWithIdReturnsCoffeeOrderInfoForThatId() throws Exception {
    mockMvc.perform(get("/api/coffeeorders/1"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(1))
           .andExpect(jsonPath("$.price").value("225"));
  }

}