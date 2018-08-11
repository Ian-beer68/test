package org.ian.gohenry.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ian.gohenry.domain.Parent;
import org.ian.gohenry.service.FamilyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ParentEndpointTest {
    private MockMvc mockMvc;

    @Mock
    public FamilyService familyService;

    @InjectMocks
    public ParentEndpoint underTest;

    @Before
    public void setUp() throws Exception{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        ReflectionTestUtils.setField(underTest, "validator", validator);
        // Initializes the JacksonTester
        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        JacksonTester.initFields(this, om);
        // MockMvc standalone approach
        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                .build();
    }

    @Test
    public void shouldPost201() throws Exception {
        String inJson = "{  \n" +
                "   \"title\":\"Mrs\",\n" +
                "   \"firstName\":\"Jane\",\n" +
                "   \"lastName\":\"Doe\",\n" +
                "   \"emailAddress\":\"jane.doe@gohenry.co.uk\",\n" +
                "   \"dateOfBirth\":\"1990-06-03\",\n" +
                "   \"gender\":\"female\",\n" +
                "   \"secondName\":\"\",\n" +
                "}\n";

        Parent parent = new Parent(1l,
                "mrs",
                "Jane",
                "Doe",
                null,
                "jane.doe@gohenry.co.uk",
                LocalDate.of(1990,06,03),
                "female",
                null);

        when(familyService.createParent(parent)).thenReturn(parent);

        MockHttpServletResponse response = mockMvc.perform(
                post("/parents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inJson))
                .andReturn().getResponse();

        String responseStr = response.getContentAsString();

        assertThat(responseStr.contains("mrs"), is(true));
        assertThat(responseStr.contains("1"), is(true));
        assertThat(responseStr.contains("Jane"), is(true));
        assertThat(responseStr.contains("Doe"), is(true));



        verify(familyService).createParent(parent);
    }

    @Test
    public void shouldPost400BadValidationFail() throws Exception {
        String inJson = "{  \n" +
                "   \"title\":\"\",\n" +
                "   \"firstName\":\"\",\n" +
                "   \"lastName\":\"\",\n" +
                "   \"emailAddress\":\"\",\n" +
                "   \"dateOfBirth\":\"2099-06-03\",\n" +
                "   \"gender\":\"\",\n" +
                "   \"secondName\":\"\",\n" +
                "}\n";

        MockHttpServletResponse response = mockMvc.perform(
                post("/parents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inJson))
                .andReturn().getResponse();

    }

    @Test
    public void shouldGetParent() throws Exception {
        String title = "mr";
        String name = "Jack";
        String surname = "reacher";
        String email = "Jack@reacher.com";
        LocalDate dob = LocalDate.now();
        String gender = "male";


        Parent parent = new Parent(1l, title, name, surname,null, email, dob, gender, null);

        MockHttpServletResponse response = mockMvc.perform(
                get("/parents/1"))
                .andReturn().getResponse();


    }


}