package com.rns.testes.java.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.service.IProdutoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EstoqueSeeder {

    @Autowired
    IFilialService filialService;
    
    @Autowired
    IProdutoService produtoService;

    @Autowired
    IEstoqueService estoqueService;
    
    @EventListener
    @Order(3)
    public void seedEstoque(ContextRefreshedEvent event) {
        try {
            log.info("Criando estoques....");
            criandoEstoques();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private void criandoEstoques() {
        Estoque estoqueFilial1Prd1 = new Estoque();
        Filial filial1 = filialService.buscaPorRazao("Galpão de estocagem de produtos LTDA");
        estoqueFilial1Prd1.setFilial(filial1);
        Produto produto1 = produtoService.buscaPorNome("Sal produto 1");
        estoqueFilial1Prd1.setProduto(produto1);
        estoqueFilial1Prd1.setQuantidade(5);
        estoqueService.save(estoqueFilial1Prd1);

        Estoque estoqueFilial1Prd2 = new Estoque();
        estoqueFilial1Prd2.setFilial(filial1);
        Produto produto2 = produtoService.buscaPorNome("Sal produto 2");
        estoqueFilial1Prd2.setProduto(produto2);
        estoqueFilial1Prd2.setQuantidade(20);
        estoqueService.save(estoqueFilial1Prd2);

        Estoque estoqueFilial2Prd1 = new Estoque();
        Filial filial2 = filialService.buscaPorRazao("Loja São Paulo LTDA");
        estoqueFilial2Prd1.setFilial(filial2);
        estoqueFilial2Prd1.setProduto(produto1);
        estoqueFilial2Prd1.setQuantidade(15);
        estoqueService.save(estoqueFilial2Prd1);

        Estoque estoqueFilial3Prd3 = new Estoque();
        Filial filial3 = filialService.buscaPorRazao("Loja Rio de Janeiro LTDA");
        estoqueFilial3Prd3.setFilial(filial3);
        Produto produto3 = produtoService.buscaPorNome("Sal produto 3");
        estoqueFilial3Prd3.setProduto(produto3);
        estoqueFilial3Prd3.setQuantidade(12);
        estoqueService.save(estoqueFilial3Prd3);
    }
}
