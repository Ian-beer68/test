package org.ian.gohenry.dto;

import net.codebox.javabeantester.JavaBeanTester;
import org.ian.gohenry.domain.Child;
import org.ian.gohenry.domain.Parent;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParentDTOTest {
    @Test
    public void shouldBeanOk() throws Exception {
        JavaBeanTester.test(ParentDTO.class, "dateofbirth", "children");
        LocalDate ld = LocalDate.now();
        ParentDTO parent = new ParentDTO();
        parent.setDateofbirth(ld);
        assertThat(parent.getDateofbirth(), is(ld));

        ChildDTO c = new ChildDTO();
        Set<ChildDTO> children = new HashSet<>();
        children.add(c);

        parent.setChildren(children);
        assertThat(parent.getChildren(), is(children));
    }
}