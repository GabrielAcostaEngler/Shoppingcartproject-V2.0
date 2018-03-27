package com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.PiqTx;
import com.ShoppingCart.Project.springbootshoppingcart.piqcallbackhandler.piqtx.dao.PiqTxDao;


@Service
public class PiqTxService {

	@Autowired
	PiqTxDao piqTxDao;
	
	public void saveTx(PiqTx piqTx) {
		piqTxDao.save(piqTx);
	}
	
	public PiqTx findByPiqTxId(String piqTxId) {
		
		PiqTx piqTx = piqTxDao.findByPiqTxId(piqTxId);
		
		return piqTx;
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
