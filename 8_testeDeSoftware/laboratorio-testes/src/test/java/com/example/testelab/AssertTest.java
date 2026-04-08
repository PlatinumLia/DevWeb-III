package com.example.testelab;

import org.junit.jupiter.api.Test;

import com.example.testelab.models.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertTest {
    @Test
    public void deveDemonstrarAssercoesComJunit(){
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull(new Object());
        assertEquals(1, 1);

        //delta de precisão
        assertEquals(0.12345, 0.12, 0.01);

        //comparando outros tipos
        assertEquals("Linux", "Linux", "Erro de comparação");

        Usuario user1 = new Usuario("chai");
        Usuario user2 = new Usuario("chai");

        assertEquals(user1, user2);

        assertSame(user1, user1);
    }
}