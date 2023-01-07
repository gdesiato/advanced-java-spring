package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
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
    public void testGetAllMoviesSuccessMockService() throws Exception {

        //GIVEN-WHEN-THEN

        //create list of movies
        ArrayList<Movie> movieList1 = new ArrayList<>();

        Movie movie1 = Movie.builder().name("Jaws").rating(8.9).build();
        Movie movie2 = Movie.builder().name("The Gladiator").rating(9.1).build();

        movieList1.add(movie1);
        movieList1.add(movie2);

        //when ...
        when(movieService.getAllMovies())
                //return ...
                .thenReturn(movieList1);

        //test
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().string(movieList1.toString()));

    }

    /* TASK 3
    Create a new variation of testGetAllMoviesSuccess() using a different method of data validation
    that you used in Task 1.
    For example, if you used JSON paths in your implementation of Task 1, maybe use
    TestUtil.convertJsonBytesToObject() to create an object for testing instead (or vice versa).
     */
    @Test
    public void testGetAllMoviesSuccessWithTestUtil() throws Exception {

        //create movie List

        ArrayList<Movie> movieList2 = new ArrayList<>();

        Movie movie1 = Movie.builder().name("The Conjuring").rating(8.0).build();
        Movie movie2 = Movie.builder().name("The Shining").rating(8.7).build();

        movieList2.add(movie1);
        movieList2.add(movie2);


        //when movieService's getAll() method is called...
        when(movieService.getAllMovies())
                //return ...
                .thenReturn(movieList2);

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                //expect JSON in the body
                .andExpect(content().contentType("application/json"))
                //expect the JSON matches the Movie returned from getAll()
                .andExpect(content().string(TestUtil.convertObjectToJsonString(movieList2)));

    }


}
