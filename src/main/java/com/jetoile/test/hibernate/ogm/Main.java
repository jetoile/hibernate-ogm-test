/*
 * Copyright (c) 2011 Khanh Tuong Maudoux <kmx.petals@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
