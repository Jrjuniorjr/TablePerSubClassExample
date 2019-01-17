package com.example.TablePerSubClassExample.interfacesdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TablePerSubClassExample.model.Employer;


public interface IEmployerDAO extends JpaRepository<Employer, Integer>{
	public Employer findByEmpNo(int empNo);
}
