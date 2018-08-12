package org.ian.gohenry.endpoints;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChallengeExcveptionHandlerTest {

    private ChallengeExcveptionHandler underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new ChallengeExcveptionHandler();
    }

    @Test
    public void should500Throwable() throws Exception {
        Throwable t = new Throwable("bang");

        ResponseEntity re = underTest.handleThrowable(t);

        assertThat(re.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    public void should500Runtime() throws Exception {
        RuntimeException t = new RuntimeException("bang");

        ResponseEntity re = underTest.handleRuntime(t);

        assertThat(re.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    public void should404IllegalArgument() throws Exception {
        IllegalArgumentException t = new IllegalArgumentException("bang");

        ResponseEntity re = underTest.handleIllegalArgument(t);

        assertThat(re.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

}