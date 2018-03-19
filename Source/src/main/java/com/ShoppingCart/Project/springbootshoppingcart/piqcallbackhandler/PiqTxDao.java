package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PiqTxDao extends CrudRepository<PiqTx, Long> {
	
	PiqTx findByTxId(Long txId);
	
	PiqTx findByPiqTxId(String piqTxId);

}
