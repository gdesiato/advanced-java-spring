package platform.codingnomads.co.usingmockmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.usingmockmvc.MockMvcMain;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//tell Spring to start completely and indicate the location of the bootstrapping class
@SpringBootTest(classes = MockMvcMain.class)
//indicate that Spring should autoconfigure the MockMvc object
@AutoConfigureMockMvc
public class TestingWebServices {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloShouldReturnDefaultMessage() throws Exception {
        //use mockMvc to start a request
        mockMvc
                //.perform is used to indicate what mockMvc should do
                .perform(
                        //the get method and the path passed in as a parameter is used to indicate the
                        // HTTP method and the url path used to make request
                        get("/hello"))
                //print the response
                .andDo(print())
                //the response should have status 200 OK
                .andExpect(status().isOk())
                //test that this response has a body that contains a "Hello Back" String
                .andExpect(content().string(containsString("Hello Back")));

    }

    @Test
    public void baseURLShouldReturnGreetingViewName() throws Exception {
        //use mockMvc to start a request
        mockMvc
                //indicate what HTTP method and url path should be used to make the request
                .perform(get("/"))
                //the result should be printed
                .andDo(print())
                //the view name expected is greeting
                .andExpect(view().name("greeting"));
    }

    @Test
    public void nonExistentEndpoint() throws Exception {

        // mockMvc pretends to be a browser
        mockMvc.perform(
                        //set up a GET request to a non-existent endpoint
                        get("/test_4")
                )
                //expect response status 404 NOT FOUND
                .andExpect(status().isNotFound());
    }

    @Test
    public void confirmHeader() throws Exception {

        mockMvc.perform(
                        //create POST request
                        post("/test_1")
                                //add data to the request body
                                .content("application/json")
                                //make the request HTTPS
                                .secure(true)
                )
                //expect 200 OK
                .andExpect(status().isOk())
                //test if it is present
                .andExpect(header().exists("X-header"))
                //test its value also
                .andExpect(header().string("X-header", "header value 1"));
    }

//    @Test
//    public void confirmBodyOfResponseIsEmpty() throws Exception {
//
//        mockMvc.perform(get("/custom/header/should/be/added"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(emptyString()));
//    }
}
