package org.ian.gohenry.domain;


import net.codebox.javabeantester.JavaBeanTester;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChildTest {

    @Test
    public void shouldBeanOk() throws Exception {
        JavaBeanTester.test(Child.class, "dateofbirth");

        LocalDate ld = LocalDate.now();
        Child child = new Child(1l, "dan", "de", "bar", "dbar@bar.com", ld, "male", new Parent());
        child.setDateofbirth(ld);
        assertThat(child.getDateofbirth(), is(ld));
    }

    @Test
    public void shouldEquals() throws Exception {
        LocalDate ld = LocalDate.now();
        Child child = new Child(1l, "dan", "de", "bar", "dbar@bar.com", ld, "male", new Parent());
        child.setDateofbirth(ld);

        assertThat(child.equals(child), is(true));
    }

    @Test
    public void shouldNotEquals() throws Exception {
        LocalDate ld = LocalDate.now();
        Child child = new Child(1l, "dan", "de", "bar", "dbar@bar.com", ld, "male", new Parent());
        child.setDateofbirth(ld);

        assertThat(child.equals(new Child()), is(false));
    }

    @Test
    public void shouldToString() throws Exception {
        LocalDate ld = LocalDate.now();
        Child child = new Child(1l, "dan","de","bar", "dbar@bar.com",ld,"male", new Parent());
        child.setDateofbirth(ld);

        String toStr = child.toString();
        assertThat(toStr.contains("dan"), is(true));
        assertThat(toStr.contains("de"), is(true));
        assertThat(toStr.contains("bar"), is(true));
        assertThat(toStr.contains("dbar@bar.com"), is(true));
        assertThat(toStr.contains("male"), is(true));
        assertThat(toStr.contains(ld.toString()), is(true));
    }
}