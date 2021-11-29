package com.example.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.junit.matchers.JUnitMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Password :")));
    }

    @Test
    public void testBooklist() throws Exception {
        mockMvc.perform(get("/booklist")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Books")));
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Add a book")));
    }

    @Test
    public void testModify() throws Exception {
        mockMvc.perform(get("/edit/9781781101032")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Modify a book")));
    }
}
