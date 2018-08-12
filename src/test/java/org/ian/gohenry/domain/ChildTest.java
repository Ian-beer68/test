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
        Child child = new Child(1l, "dan","de","bar", "dbar@bar.com",ld,"male", new Parent());
        child.setDateofbirth(ld);
        assertThat(child.getDateofbirth(), is(ld));
    }



}