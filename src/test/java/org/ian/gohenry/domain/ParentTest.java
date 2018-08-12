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
    public void shouldHashCode() throws Exception {
        LocalDate ld = LocalDate.now();
        Parent parent = new Parent();
        parent.setDateofbirth(ld);

        int hashCode = parent.hashCode();

        assertThat(Math.abs(hashCode) > 0, is(true));
    }

    @Test
    public void shouldToString() throws Exception {
        LocalDate ld = LocalDate.now();
        Parent parent = new Parent();
        parent.setDateofbirth(ld);

        String toStr = parent.toString();

        assertThat(toStr.contains(ld.toString()), is(true));
    }
}