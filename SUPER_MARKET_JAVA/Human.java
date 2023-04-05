package XI_HAFTA_MARKET;

public abstract class Human {

	protected String ad;
	protected String soyad;
	protected String adres;
	protected boolean eveServis;
	
	public Human(String ad, String soyad , String adres , boolean eveServis) {
		this.ad=ad;
		this.soyad=soyad;
		this.adres=adres;
		this.eveServis=eveServis;
	}
	
	
	public abstract void bilgiler();
	
	public boolean isEveServis() {
		return eveServis;
	}

	public void setEveServis(boolean eveServis) {
		this.eveServis = eveServis;
	}



	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

}
