package com.fusi24.mvcnew.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jurusan database table.
 * 
 */
@Entity
@NamedQuery(name="Jurusan.findAll", query="SELECT j FROM Jurusan j")
public class Jurusan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String deskripsi;

	@Column(name="kode_jurusan")
	private String kodeJurusan;

	@Column(name="nama_jurusan")
	private String namaJurusan;

	//bi-directional many-to-one association to Mahasiswa
	@OneToMany(mappedBy="jurusan")
	private List<Mahasiswa> mahasiswas;

	public Jurusan() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getKodeJurusan() {
		return this.kodeJurusan;
	}

	public void setKodeJurusan(String kodeJurusan) {
		this.kodeJurusan = kodeJurusan;
	}

	public String getNamaJurusan() {
		return this.namaJurusan;
	}

	public void setNamaJurusan(String namaJurusan) {
		this.namaJurusan = namaJurusan;
	}

	public List<Mahasiswa> getMahasiswas() {
		return this.mahasiswas;
	}

	public void setMahasiswas(List<Mahasiswa> mahasiswas) {
		this.mahasiswas = mahasiswas;
	}

	public Mahasiswa addMahasiswa(Mahasiswa mahasiswa) {
		getMahasiswas().add(mahasiswa);
		mahasiswa.setJurusan(this);

		return mahasiswa;
	}

	public Mahasiswa removeMahasiswa(Mahasiswa mahasiswa) {
		getMahasiswas().remove(mahasiswa);
		mahasiswa.setJurusan(null);

		return mahasiswa;
	}

}