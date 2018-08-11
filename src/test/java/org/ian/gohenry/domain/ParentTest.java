package org.ian.gohenry.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.codebox.javabeantester.JavaBeanTester;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParentTest {

    @Test
    public void shouldBeanOk() throws Exception {
        JavaBeanTester.test(Parent.class, "dateofbirth", "children");
        LocalDate ld = LocalDate.now();
        Parent parent = new Parent();
        parent.setDateofbirth(ld);
        assertThat(parent.getDateofbirth(), is(ld));

        Child c = new Child();
        Set<Child> children = new HashSet<>();
        children.add(c);

        parent.setChildren(children);
        assertThat(parent.getChildren(), is(children));
    }

    @Test
    public void shouldJson() throws Exception {
        String in = "{  \n" +"   \"title\":\"Mrs\",\n" +
                "   \"firstName\":\"Jane\",\n" +
                "   \"lastName\":\"Doe\",\n" +
                "   \"emailAddress\":\"jane.doe@gohenry.co.uk\",\n" +
                "   \"dateOfBirth\":\"1990-06-03\",\n" +
                "   \"gender\":\"female\",\n" +
                "   \"secondName\":\"\",\n" +
                "   \"children\":[  \n" +
                "      {  \n" +
                "         \"firstName\":\"Janet\",\n" +
                "         \"lastName\":\"Doe\",\n" +
                "         \"emailAddress\":\"janet.doe@gohenry.co.uk\",\n" +
                "         \"dateOfBirth\":\"2010-05-22\",\n" +
                "         \"gender\":\"female\",\n" +
                "         \"secondName\":\"\"\n" +
                "      },\n" +
                "      {  \n" +
                "         \"firstName\":\"Jason\",\n" +
                "         \"lastName\":\"Doe\",\n" +
                "         \"emailAddress\":\"jason.doe@gohenry.co.uk\",\n" +
                "         \"dateOfBirth\":\"2008-12-05\",\n" +
                "         \"gender\":\"male\",\n" +
                "         \"secondName\":\"\"\n" +
                "      }\n" +
                "   ]\n" +
                "}";

        ObjectMapper om = new ObjectMapper();
        om.findAndRegisterModules();

        Parent p = om.readValue(in, Parent.class);

        System.out.println("hi");
    }

}