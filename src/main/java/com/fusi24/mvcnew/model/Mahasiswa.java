package com.fusi24.mvcnew.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mahasiswa database table.
 * 
 */
@Entity
@NamedQuery(name="Mahasiswa.findAll", query="SELECT m FROM Mahasiswa m")
public class Mahasiswa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String alamat;

	private String nama;

	private String nim;

	@Column(name="no_telp")
	private String noTelp;

	@Temporal(TemporalType.DATE)
	@Column(name="tgl_lahir")
	private Date tglLahir;

	//bi-directional many-to-one association to Jurusan
	@ManyToOne
	@JoinColumn(name = "jurusan_id", nullable = false)
	private Jurusan jurusan;


	public Mahasiswa() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNim() {
		return this.nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNoTelp() {
		return this.noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public Date getTglLahir() {
		return this.tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public Jurusan getJurusan() {
		return this.jurusan;
	}

	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}

}