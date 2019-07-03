package com.fusi24.mvcnew.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.fusi24.mvcnew.model.Jurusan;
import com.fusi24.mvcnew.model.Mahasiswa;


@Service
public class MahasiswaService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Mahasiswa> selectAll() {
		return entityManager.createQuery("select m from Mahasiswa m", Mahasiswa.class)
				.getResultList();
	}
	
	public Mahasiswa selectByNim(String nim) {
		
		return entityManager
				.createQuery("select m from Mahasiswa m where m.nim = ?1", Mahasiswa.class)
				.setParameter(1, nim)
				.getSingleResult();
	}
	
	public Jurusan findJurusanByid(long id_jurusan) {
		return entityManager.find(Jurusan.class, id_jurusan);
	}
	
	public Mahasiswa findMahasiswaById(long id_mahasiswa) {
		return entityManager.find(Mahasiswa.class, id_mahasiswa);
	}
	
	
	public void insert(Mahasiswa mhs)  {
		EntityManager em = entityManager;
		em.getTransaction().begin();
		em.persist(mhs);
		em.getTransaction().commit();
	}
	
	public void update(Mahasiswa mhs) {
		EntityManager em = entityManager;
		em.getTransaction().begin();
		em.merge(mhs);
		em.getTransaction().commit();
	}
	
	public void delete(Mahasiswa mhs) {
		EntityManager em = entityManager;
		em.getTransaction().begin();
		em.createNativeQuery("delete from mahasiswa where id = ?1", Mahasiswa.class)
		.setParameter(1, mhs.getId())
		.executeUpdate();
		em.getTransaction().commit();
	}
}
