package br.com.isoftlab.submissaoPalestras.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = -6806735977725717887L;
	
	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception{
		System.out.println("Open Transaction");
		manager.getTransaction().begin();
		
		Object result = context.proceed();
		
		manager.getTransaction().commit();
		System.out.println("Transaction Commited");
		
		return result;
	}
	
}
