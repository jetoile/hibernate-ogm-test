/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package com.jetoile.test.hibernate.ogm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.infinispan.transaction.lookup.JBossStandaloneJTAManagerLookup;

import org.hibernate.transaction.JBossTSStandaloneTransactionManagerLookup;

/**
 * User: khanh
 * Date: 14/03/12
 * Time: 17:29
 */
public class Main2 {
	
	public static void main(String[] args)
			throws Exception, RollbackException, HeuristicRollbackException, HeuristicMixedException, NotSupportedException {

//		TransactionManager tm = new JBossStandaloneJTAManagerLookup().getTransactionManager();
		TransactionManager tm = new JBossTSStandaloneTransactionManagerLookup().getTransactionManager(null);



		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"hibernate-ogm-test-infinispan"
		);

		tm.begin();

		EntityManager em = emf.createEntityManager();
		Breed norvegien = new Breed();
		norvegien.setName( "norvegien" );
		norvegien.setId("1");
		em.persist( norvegien );

		em.flush();
		em.close();
		tm.commit();
	}
}
