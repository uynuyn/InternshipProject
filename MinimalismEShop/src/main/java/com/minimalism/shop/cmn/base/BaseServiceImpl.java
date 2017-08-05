package com.minimalism.shop.cmn.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<E,I>{

	@Autowired private BaseRepositoryImpl<E, I> baseRepository;

	public E save(E entity) {
		// TODO Auto-generated method stub
		return (E) baseRepository.save(entity);
	}

	public E update(E entity) {
		// TODO Auto-generated method stub
		return (E) baseRepository.update(entity);
	}

}
