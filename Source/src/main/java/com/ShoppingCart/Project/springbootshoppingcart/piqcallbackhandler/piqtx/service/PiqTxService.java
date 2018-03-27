package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PiqTxService {

	@Autowired
	PiqTxDao piqTxDao;
	
	public void saveTx(PiqTx piqTx) {
		piqTxDao.save(piqTx);
	}
	
	public ArrayList<PiqTx> getTxHistory(String userId){
		
		ArrayList<PiqTx> allPiqTx = (ArrayList<PiqTx>) piqTxDao.findAll();
		ArrayList<PiqTx> txHistory = new ArrayList<PiqTx>();
		
		for (PiqTx piqTx : allPiqTx) {
			if (piqTx.getUserId().equals(userId)){
				txHistory.add(piqTx);
			}
		}
		
		return txHistory;
		
	}
	
}
