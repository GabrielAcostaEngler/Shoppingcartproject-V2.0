package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.dao;

import org.springframework.stereotype.Repository;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.PiqTx;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PiqTxDao extends CrudRepository<PiqTx, Long> {
	
	PiqTx findByTxId(Long txId);
	
	PiqTx findByPiqTxId(String piqTxId);

}
