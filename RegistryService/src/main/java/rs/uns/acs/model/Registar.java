package rs.uns.acs.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class Registar implements Serializable {
	
	@Id
	private String id;
	private int redniBroj;
	private String ppu;
	private String neusaglasnost;
	private char mera;
	private String rukovodilacTima;
	private Date planiranRok;
	private Date produzenRok;
	private Date ostvarenRok;
	
	public Registar() {
		// TODO Auto-generated constructor stub
	}
	
	public Registar(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public String getPpu() {
		return ppu;
	}

	public void setPpu(String ppu) {
		this.ppu = ppu;
	}

	public String getNeusaglasnost() {
		return neusaglasnost;
	}

	public void setNeusaglasnost(String neusaglasnost) {
		this.neusaglasnost = neusaglasnost;
	}

	public char getMera() {
		return mera;
	}

	public void setMera(char mera) {
		this.mera = mera;
	}

	public String getRukovodilacTima() {
		return rukovodilacTima;
	}

	public void setRukovodilacTima(String rukovodilacTima) {
		this.rukovodilacTima = rukovodilacTima;
	}

	public Date getPlaniranRok() {
		return planiranRok;
	}

	public void setPlaniranRok(Date planiranRok) {
		this.planiranRok = planiranRok;
	}

	public Date getProduzenRok() {
		return produzenRok;
	}

	public void setProduzenRok(Date produzenRok) {
		this.produzenRok = produzenRok;
	}

	public Date getOstvarenRok() {
		return ostvarenRok;
	}

	public void setOstvarenRok(Date ostvarenRok) {
		this.ostvarenRok = ostvarenRok;
	}

	@Override
	public String toString() {
		return "Registar [id=" + id + ", redniBroj=" + redniBroj + ", ppu=" + ppu + ", neusaglasnost=" + neusaglasnost
				+ ", mera=" + mera + ", rukovodilacTima=" + rukovodilacTima + ", planiranRok=" + planiranRok
				+ ", produzenRok=" + produzenRok + ", ostvarenRok=" + ostvarenRok + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mera;
		result = prime * result + ((neusaglasnost == null) ? 0 : neusaglasnost.hashCode());
		result = prime * result + ((ostvarenRok == null) ? 0 : ostvarenRok.hashCode());
		result = prime * result + ((planiranRok == null) ? 0 : planiranRok.hashCode());
		result = prime * result + ((ppu == null) ? 0 : ppu.hashCode());
		result = prime * result + ((produzenRok == null) ? 0 : produzenRok.hashCode());
		result = prime * result + redniBroj;
		result = prime * result + ((rukovodilacTima == null) ? 0 : rukovodilacTima.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registar other = (Registar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mera != other.mera)
			return false;
		if (neusaglasnost == null) {
			if (other.neusaglasnost != null)
				return false;
		} else if (!neusaglasnost.equals(other.neusaglasnost))
			return false;
		if (ostvarenRok == null) {
			if (other.ostvarenRok != null)
				return false;
		} else if (!ostvarenRok.equals(other.ostvarenRok))
			return false;
		if (planiranRok == null) {
			if (other.planiranRok != null)
				return false;
		} else if (!planiranRok.equals(other.planiranRok))
			return false;
		if (ppu == null) {
			if (other.ppu != null)
				return false;
		} else if (!ppu.equals(other.ppu))
			return false;
		if (produzenRok == null) {
			if (other.produzenRok != null)
				return false;
		} else if (!produzenRok.equals(other.produzenRok))
			return false;
		if (redniBroj != other.redniBroj)
			return false;
		if (rukovodilacTima == null) {
			if (other.rukovodilacTima != null)
				return false;
		} else if (!rukovodilacTima.equals(other.rukovodilacTima))
			return false;
		return true;
	}
	
	

}
