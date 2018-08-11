package org.ian.gohenry.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ian.gohenry.service.FamilyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.*;

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

    }

    @Test
    public void shouldPost400BadValidationFail() throws Exception {

    }

    @Test
    public void shouldGetParent() throws Exception {

    }


}