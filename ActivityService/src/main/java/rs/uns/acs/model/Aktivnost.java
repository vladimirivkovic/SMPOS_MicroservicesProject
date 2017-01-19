package rs.uns.acs.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class Aktivnost implements Serializable {
	
	public enum OcenaEfekta {
		UPOTPUNOSTI,
		DELIMICNI,
		NEOSTVARENI
	}
	
	public enum ObimRealizacije {
		REALIZOVANA,
		DELIMOCNI,
		NEREALIZOVANA
	}
	
	@Id
	private String id;
	private int brojMere;
	private String nosilacAktivnosti;
	private String opis;
	private String cilj;
	private String ocekivaniEfekti;
	private String napomena;
	private String rukovodilacTima;
	private Date datumPotpisa;
	private OcenaEfekta ocenaEfekta;
	private int procenatOstvarenosti;
	private Date datumVerifikacije;
	private ObimRealizacije obimRealizacije;
	private OcenaEfekta verifikacijaEfekta;
	private int procenatRealizacije;
	private Date datumPodnosenjaIzvestaja;
	private String izvestajPodneo;
	private String verifikacijuIzvrsio;
	
	public Aktivnost() {
		// TODO Auto-generated constructor stub
	}
	
	public Aktivnost(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNosilacAktivnosti() {
		return nosilacAktivnosti;
	}

	public void setNosilacAktivnosti(String nosilacAktivnosti) {
		this.nosilacAktivnosti = nosilacAktivnosti;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getCilj() {
		return cilj;
	}

	public void setCilj(String cilj) {
		this.cilj = cilj;
	}

	public String getOcekivaniEfekti() {
		return ocekivaniEfekti;
	}

	public void setOcekivaniEfekti(String ocekivaniEfekti) {
		this.ocekivaniEfekti = ocekivaniEfekti;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public String getRukovodilacTima() {
		return rukovodilacTima;
	}

	public void setRukovodilacTima(String rukovodilacTima) {
		this.rukovodilacTima = rukovodilacTima;
	}

	public Date getDatumPotpisa() {
		return datumPotpisa;
	}

	public void setDatumPotpisa(Date datumPotpisa) {
		this.datumPotpisa = datumPotpisa;
	}

	public OcenaEfekta getOcenaEfekta() {
		return ocenaEfekta;
	}

	public void setOcenaEfekta(OcenaEfekta ocenaEfekta) {
		this.ocenaEfekta = ocenaEfekta;
	}

	public int getProcenatOstvarenosti() {
		return procenatOstvarenosti;
	}

	public void setProcenatOstvarenosti(int procenatOstvarenosti) {
		this.procenatOstvarenosti = procenatOstvarenosti;
	}

	public Date getDatumVerifikacije() {
		return datumVerifikacije;
	}

	public void setDatumVerifikacije(Date datumVerifikacije) {
		this.datumVerifikacije = datumVerifikacije;
	}

	public ObimRealizacije getObimRealizacije() {
		return obimRealizacije;
	}

	public void setObimRealizacije(ObimRealizacije obimRealizacije) {
		this.obimRealizacije = obimRealizacije;
	}

	public OcenaEfekta getVerifikacijaEfekta() {
		return verifikacijaEfekta;
	}

	public void setVerifikacijaEfekta(OcenaEfekta verifikacijaEfekta) {
		this.verifikacijaEfekta = verifikacijaEfekta;
	}

	public int getProcenatRealizacije() {
		return procenatRealizacije;
	}

	public void setProcenatRealizacije(int procenatRealizacije) {
		this.procenatRealizacije = procenatRealizacije;
	}

	public Date getDatumPodnosenjaIzvestaja() {
		return datumPodnosenjaIzvestaja;
	}

	public void setDatumPodnosenjaIzvestaja(Date datumPodnosenjaIzvestaja) {
		this.datumPodnosenjaIzvestaja = datumPodnosenjaIzvestaja;
	}

	public String getIzvestajPodneo() {
		return izvestajPodneo;
	}

	public void setIzvestajPodneo(String izvestajPodneo) {
		this.izvestajPodneo = izvestajPodneo;
	}

	public String getVerifikacijuIzvrsio() {
		return verifikacijuIzvrsio;
	}

	public void setVerifikacijuIzvrsio(String verifikacijuIzvrsio) {
		this.verifikacijuIzvrsio = verifikacijuIzvrsio;
	}

	public int getBrojMere() {
		return brojMere;
	}

	public void setBrojMere(int brojMere) {
		this.brojMere = brojMere;
	}

	@Override
	public String toString() {
		return "Aktivnost [id=" + id + ", brojMere=" + brojMere + ", nosilacAktivnosti=" + nosilacAktivnosti + ", opis="
				+ opis + ", cilj=" + cilj + ", ocekivaniEfekti=" + ocekivaniEfekti + ", napomena=" + napomena
				+ ", rukovodilacTima=" + rukovodilacTima + ", datumPotpisa=" + datumPotpisa + ", ocenaEfekta="
				+ ocenaEfekta + ", procenatOstvarenosti=" + procenatOstvarenosti + ", datumVerifikacije="
				+ datumVerifikacije + ", obimRealizacije=" + obimRealizacije + ", verifikacijaEfekta="
				+ verifikacijaEfekta + ", procenatRealizacije=" + procenatRealizacije + ", datumPodnosenjaIzvestaja="
				+ datumPodnosenjaIzvestaja + ", izvestajPodneo=" + izvestajPodneo + ", verifikacijuIzvrsio="
				+ verifikacijuIzvrsio + ", getId()=" + getId() + ", getNosilacAktivnosti()=" + getNosilacAktivnosti()
				+ ", getOpis()=" + getOpis() + ", getCilj()=" + getCilj() + ", getOcekivaniEfekti()="
				+ getOcekivaniEfekti() + ", getNapomena()=" + getNapomena() + ", getRukovodilacTima()="
				+ getRukovodilacTima() + ", getDatumPotpisa()=" + getDatumPotpisa() + ", getOcenaEfekta()="
				+ getOcenaEfekta() + ", getProcenatOstvarenosti()=" + getProcenatOstvarenosti()
				+ ", getDatumVerifikacije()=" + getDatumVerifikacije() + ", getObimRealizacije()="
				+ getObimRealizacije() + ", getVerifikacijaEfekta()=" + getVerifikacijaEfekta()
				+ ", getProcenatRealizacije()=" + getProcenatRealizacije() + ", getDatumPodnosenjaIzvestaja()="
				+ getDatumPodnosenjaIzvestaja() + ", getIzvestajPodneo()=" + getIzvestajPodneo()
				+ ", getVerifikacijuIzvrsio()=" + getVerifikacijuIzvrsio() + ", getBrojMere()=" + getBrojMere()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojMere;
		result = prime * result + ((cilj == null) ? 0 : cilj.hashCode());
		result = prime * result + ((datumPodnosenjaIzvestaja == null) ? 0 : datumPodnosenjaIzvestaja.hashCode());
		result = prime * result + ((datumPotpisa == null) ? 0 : datumPotpisa.hashCode());
		result = prime * result + ((datumVerifikacije == null) ? 0 : datumVerifikacije.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((izvestajPodneo == null) ? 0 : izvestajPodneo.hashCode());
		result = prime * result + ((napomena == null) ? 0 : napomena.hashCode());
		result = prime * result + ((nosilacAktivnosti == null) ? 0 : nosilacAktivnosti.hashCode());
		result = prime * result + ((obimRealizacije == null) ? 0 : obimRealizacije.hashCode());
		result = prime * result + ((ocekivaniEfekti == null) ? 0 : ocekivaniEfekti.hashCode());
		result = prime * result + ((ocenaEfekta == null) ? 0 : ocenaEfekta.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + procenatOstvarenosti;
		result = prime * result + procenatRealizacije;
		result = prime * result + ((rukovodilacTima == null) ? 0 : rukovodilacTima.hashCode());
		result = prime * result + ((verifikacijaEfekta == null) ? 0 : verifikacijaEfekta.hashCode());
		result = prime * result + ((verifikacijuIzvrsio == null) ? 0 : verifikacijuIzvrsio.hashCode());
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
		Aktivnost other = (Aktivnost) obj;
		if (brojMere != other.brojMere)
			return false;
		if (cilj == null) {
			if (other.cilj != null)
				return false;
		} else if (!cilj.equals(other.cilj))
			return false;
		if (datumPodnosenjaIzvestaja == null) {
			if (other.datumPodnosenjaIzvestaja != null)
				return false;
		} else if (!datumPodnosenjaIzvestaja.equals(other.datumPodnosenjaIzvestaja))
			return false;
		if (datumPotpisa == null) {
			if (other.datumPotpisa != null)
				return false;
		} else if (!datumPotpisa.equals(other.datumPotpisa))
			return false;
		if (datumVerifikacije == null) {
			if (other.datumVerifikacije != null)
				return false;
		} else if (!datumVerifikacije.equals(other.datumVerifikacije))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (izvestajPodneo == null) {
			if (other.izvestajPodneo != null)
				return false;
		} else if (!izvestajPodneo.equals(other.izvestajPodneo))
			return false;
		if (napomena == null) {
			if (other.napomena != null)
				return false;
		} else if (!napomena.equals(other.napomena))
			return false;
		if (nosilacAktivnosti == null) {
			if (other.nosilacAktivnosti != null)
				return false;
		} else if (!nosilacAktivnosti.equals(other.nosilacAktivnosti))
			return false;
		if (obimRealizacije != other.obimRealizacije)
			return false;
		if (ocekivaniEfekti == null) {
			if (other.ocekivaniEfekti != null)
				return false;
		} else if (!ocekivaniEfekti.equals(other.ocekivaniEfekti))
			return false;
		if (ocenaEfekta != other.ocenaEfekta)
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (procenatOstvarenosti != other.procenatOstvarenosti)
			return false;
		if (procenatRealizacije != other.procenatRealizacije)
			return false;
		if (rukovodilacTima == null) {
			if (other.rukovodilacTima != null)
				return false;
		} else if (!rukovodilacTima.equals(other.rukovodilacTima))
			return false;
		if (verifikacijaEfekta != other.verifikacijaEfekta)
			return false;
		if (verifikacijuIzvrsio == null) {
			if (other.verifikacijuIzvrsio != null)
				return false;
		} else if (!verifikacijuIzvrsio.equals(other.verifikacijuIzvrsio))
			return false;
		return true;
	}

	
	
	
}
