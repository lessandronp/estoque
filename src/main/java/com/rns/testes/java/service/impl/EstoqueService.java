package com.rns.testes.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rns.testes.java.dao.IEstoqueDao;
import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.exception.ParameterNotFoundException;
import com.rns.testes.java.exception.ValidationException;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.util.DataUtil;

@Service
public class EstoqueService extends AbstractGenericServicePersistence<IEstoqueDao, Estoque, Long>
	implements IEstoqueService {

    @Autowired
    IEstoqueDao estoqueDao;

    @Autowired
    IFilialService filialService;

    @Override
    public Estoque buscaEstoque(String codProd, String cnpjFilial) {
	if (StringUtils.isNotEmpty(codProd) && StringUtils.isNotEmpty(cnpjFilial)) {
	    return estoqueDao.buscaEstoque(codProd, cnpjFilial);
	}
	throw new ParameterNotFoundException("Algum dos parâmetros não foi informado.");
    }

    public List<Estoque> buscaEstoques(String cnpjFilial) {
	if (StringUtils.isNotEmpty(cnpjFilial)) {
	    Filial filial = filialService.buscaPorCNPJ(cnpjFilial);
	    if (filial != null && !filial.getEstoques().isEmpty()) {
		return filial.getEstoques();
	    }
	}
	throw new ParameterNotFoundException("O parâmetro de CNPJ da filial não foi informado.");
    }

    @Override
    public EstoqueDto updateProdutoFilial(String codProd, String cnpjFilialOrig, String cnpjFilialDest)
	    throws ValidationException {
	if (StringUtils.isNotEmpty(codProd) && StringUtils.isNotEmpty(cnpjFilialOrig)
		&& StringUtils.isNotEmpty(cnpjFilialDest)) {
	    try {
		estoqueDao.updateProdutoFilial(codProd, cnpjFilialOrig, cnpjFilialDest);
		Estoque estoque = this.buscaEstoque(codProd, cnpjFilialDest);
		return preparaEstoqueDto(estoque);
	    } catch (ValidationException e) {
		throw new ValidationException(e.getMessage());
	    }
	}
	throw new ParameterNotFoundException("Algum dos parâmetros não foi informado.");
    }

    private EstoqueDto preparaEstoqueDto(Estoque estoque) throws ValidationException {
	return new EstoqueDto(estoque.getId(), estoque.getProduto().getCodigo(), estoque.getProduto().getNome(),
		estoque.getFilial().getCnpj(), estoque.getFilial().getRazaoSocial(),
		estoque.getFilial().getTipoFilial().getDescricao(), estoque.getQuantidade(),
		DataUtil.converteDataHoraString(estoque.getDataUltAlteracao()),
		estoque.getVersao() != null ? String.valueOf(estoque.getVersao()) : "0");
    }

    @Override
    public List<EstoqueDto> buscaEstoques() throws ValidationException {
	List<Estoque> estoques = super.findAll(Sort.by(Sort.Direction.ASC, "filial.razaoSocial"));
	List<EstoqueDto> estoquesDto = new ArrayList<>();
	estoques.forEach(e -> {
	    try {
		estoquesDto.add(preparaEstoqueDto(e));
	    } catch (ValidationException e1) {
		throw new RuntimeException(e1);
	    }
	});
	return estoquesDto;
    }
}
