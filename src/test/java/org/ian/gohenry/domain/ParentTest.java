package org.ian.gohenry.domain;

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

}