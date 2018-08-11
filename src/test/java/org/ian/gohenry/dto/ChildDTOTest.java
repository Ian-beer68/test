package org.ian.gohenry.dto;

import net.codebox.javabeantester.JavaBeanTester;
import org.ian.gohenry.domain.Child;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChildDTOTest {

    @Test
    public void shouldBeanOk() throws Exception {
        JavaBeanTester.test(ChildDTO.class, "dateofbirth");

        LocalDate ld = LocalDate.now();
        ChildDTO child = new ChildDTO();
        child.setDateofbirth(ld);
        assertThat(child.getDateofbirth(), is(ld));
    }
}