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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: khanh
 */
public class Main {
	private final static Logger LOGGER = LoggerFactory.getLogger( Main.class );

	public static final void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"hibernate-ogm-test"
		);

		EntityManager em = emf.createEntityManager();
		Breed norvegien = new Breed();
		norvegien.setName( "norvegien" );
		norvegien.setId("1");
		em.persist( norvegien );
//		Cat miaou = new Cat();
//		miaou.setName( "Tux" );
//		miaou.setBreed( norvegien );
//		em.persist( miaou );
//		Long miaouId = miaou.getId();
//
////		em = emf.createEntityManager();
//		miaou = em.find( Cat.class, miaouId );
//		LOGGER.debug( miaou.getName() );
//		LOGGER.debug( miaou.getBreed().getName() );
//		em.flush();
		em.close();
	}
}
