package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    /* TASK 1
    should test the return result of the /all endpoint.
    These methods will test using data returned from the actual database.
     */
    @Test
    public void testGetAllMoviesSuccess() throws Exception {

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")));

    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        final long rating = 400;

        mockMvc.perform(get("/all/rating" + rating))
                .andDo(print())
                .andExpect(status().isNotFound()) //404
                .andExpect(content().string(containsString("")));

    }

    /* TASK 2
    Use Mockito to complete an implementation of testGetAllMoviesSuccessMockService(),
    which mocks MovieService and creates a list of movies for testing, instead of using the database.
     */
    @Test
    public void testGetAllMoviesSuccessMockService() {

        //GIVEN-WHEN-THEN

        //create list of movies
        //when ...
        //return ...

        //test

    }
}
