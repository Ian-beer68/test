package org.ian.gohenry.service.impl;

import org.ian.gohenry.dal.ParentDAO;
import org.ian.gohenry.domain.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FamilyServiceImplTest {
    @Mock
    private ParentDAO parentDAO;
    @InjectMocks
    private FamilyServiceImpl underTest;

    @Test
    public void shouldCreateParent() throws Exception {
        Parent parent = new Parent();
        parent.setId(1l);
        parent.setEmailaddress("meh@meh.com");

        when(parentDAO.save(parent)).thenReturn(parent);


        Parent ret = underTest.createParent(parent);

        assertThat(ret.getId(), is(1l));
        assertThat(ret.getEmailaddress(), is("meh@meh.com"));

        verify(parentDAO).save(parent);
    }

    @Test
    public void shouldGetParent() throws Exception {
        Parent parent = new Parent();
        parent.setId(1l);
        parent.setEmailaddress("meh@meh.com");

        when(parentDAO.findOne(1l)).thenReturn(parent);

        Parent ret = underTest.getParentPlusChildren(1l);

        assertNotNull(ret);

        verify(parentDAO).findOne(1l);
    }

}