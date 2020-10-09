package com.rns.testes.java;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rns.testes.java.exception.ValidationException;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JavaApplicationTests {

    @Autowired
    private IEstoqueService estoqueService;
    
    @Autowired
    private IFilialService filialService;

    @Test
    @Order(1)
    public void checkStockIsEmpty() throws ValidationException {
	assertTrue(!estoqueService.buscaEstoques().isEmpty());
    }
    
    @Test
    @Order(2)
    public void analyseStockFrom() throws ValidationException {
	Estoque stockFrom = estoqueService.buscaEstoque("1", "83.230.227/0001-50");
	assertNotNull(stockFrom);
    }

    @Test
    @Order(3)
    public void analyseBranchTo() throws ValidationException {
	Filial filial = filialService.buscaPorCNPJ("50.935.855/0001-82");
	assertNotNull(filial);
    }

    @Test
    @Order(4)
    public void updateProductAnotherBranch() throws ValidationException {
	estoqueService.updateProdutoFilial("1", "83.230.227/0001-50", "50.935.855/0001-82");
	Estoque stockTo = estoqueService.buscaEstoque("1", "50.935.855/0001-82");
	assertNotNull(stockTo);
    }
    
    @Test
    @Order(5)
    public void checkProductsBranch() throws ValidationException {
	Filial filial = filialService.buscaPorCNPJ("50.935.855/0001-82");
	assertTrue(filial.getEstoques().size() >= 2);
    }
}
