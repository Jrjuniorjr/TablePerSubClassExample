package com.example.TablePerSubClassExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TablePerSubClassExample.interfacesdao.IEmployerDAO;
import com.example.TablePerSubClassExample.model.Employer;
import com.example.TablePerSubClassExample.model.SalariedEmployer;


@Service
public class EmployerService {
	
	@Autowired
	private IEmployerDAO iEmployerDAO;
	
	public ResponseEntity<?> saveEmployer(int empNo, String eName, double annualSalary){
		
		/*
		 * Observação 1 - Se for Employer employer = new SalariedEmployer() com o construtor feito por voce(com parametros)
		 * ou com o construtor default, e fizer save(employer),
		 * ele salva como type=SalariedEmployer 
		 * 
		 */
		
		/*
		 *Observação 2 - Mesmo se a super classe(nesse caso, employer) for abstrata, a observação 1 também funciona.
		 *Só lembresse de tirar o DiscriminatorValue,  pois não faz sentido porque não é possivel instanciar.
		 */
		
		/*
		 * Observação 5 - MUITO CUIDADO, esse tipo de strategy, coloca os atributos da subclasse not null.
		 * É possivel alterar fazendo @Column(nullable=true) em cima do atributo desejado.
		 */
		
		/*
		 * Resumo dessa strategy: Separar as classes em varias tabelas.
		 */
		Employer employer = new SalariedEmployer();
		
		employer.setEmpNo(empNo);
		
		employer.seteName(eName);
				
		iEmployerDAO.save(employer);
		
		return ResponseEntity.ok("Empregado cadastrado com sucesso!");
		
	}
	
	/*
	 * Observação 3 - Traz tambem o objeto do tipo SalariedEmployer, mesmo a referência sendo Employer.
	 */
	
	/*
	 * Observação 4 - É como se lidasse com o objeto inteiro, tanto pra salvar, como para consultar. 
	 */
	public ResponseEntity<Employer> findByEmpNo(int empNo) {
		
		Employer employer = iEmployerDAO.findByEmpNo(empNo);
		return ResponseEntity.ok(employer);
	}
}
