package viiteryhma;

import viiteryhma.wanhat.MockDatabase;
import viiteryhma.wanhat.OldArticle;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnPageNew() throws Exception {
        MockDatabase.reset();
        this.mockMvc.perform(get("/new")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2>Add a reference</h2>")));
    }
    
    @Test
    public void shouldAddANewReference() throws Exception {
        MockDatabase.reset();
        this.mockMvc.perform(post("/new", new OldArticle())).andDo(print()).andExpect(status().isOk())
                .andExpect(model().attributeExists("success"));        
    }
    
    @Test
    public void shouldReturnPageExport() throws Exception {
        MockDatabase.reset();
        this.mockMvc.perform(get("/export")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2>Export references</h2>")));
    }
    
    @Test
    public void shouldGenerateBibTex() throws Exception {
        MockDatabase.reset();
        MockDatabase.add(new OldArticle());
        this.mockMvc.perform(post("/export")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("author = {")));        
    }
    
}