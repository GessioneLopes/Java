
package com.ordem.servico.util;

import com.ordem.servico.models.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuscaViaCepUtilTest {
    
    public BuscaViaCepUtilTest() {
    }

    @Test
    public void testGet() {
        System.out.println("get");
        String cep = "65495000";
        BuscaViaCepUtil instance = new BuscaViaCepUtil();
        Endereco expResult = null;
        Endereco result = instance.get(cep);
        Assertions.assertEquals("MA", result.getUf());
        //fail("The test case is a prototype.");
    }
    
}
