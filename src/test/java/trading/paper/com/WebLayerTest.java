package trading.paper.com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void testSignup() throws Exception {
        mockMvc.perform(get("/signup")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Sign-up")));
    }

    @Test
    public void testAllTrades() throws Exception {
        mockMvc.perform(get("/alltrades")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Trades")));
    }

    @Test
    public void testAddTrade() throws Exception {
        mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Make a trade")));
    }

    @Test
    public void testModifyTrade() throws Exception {
        mockMvc.perform(get("/edit/2")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Update a trade")));
    }
}
