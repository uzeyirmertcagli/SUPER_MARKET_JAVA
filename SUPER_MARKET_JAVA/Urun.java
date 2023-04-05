package XI_HAFTA_MARKET;

public abstract class Urun {
	
	public enum Miktar {
		TOPTAN_MIN(10),
		PERAKENDE_MAX(8);
		public int id;

		Miktar(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}
	}

	protected String adi;
	protected int fiyat;
	protected int maxStok;
	protected int asgariStok;
	protected int mevcutUrunMiktari;
	
	public Urun(String adi , int fiyat , int maxStok , int asgariStok) {
		this.adi=adi;
		this.fiyat=fiyat;
		this.maxStok=maxStok;
		this.mevcutUrunMiktari=0;
		this.asgariStok=asgariStok;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getFiyat() {
		return fiyat;
	}

	public int getAsgariStok() {
		return asgariStok;
	}

	public void setAsgariStok(int asgariStok) {
		this.asgariStok = asgariStok;
	}

	public int getMevcutUrunMiktari() {
		return mevcutUrunMiktari;
	}

	public void setMevcutUrunMiktari(int mevcutUrunMiktari) {
		this.mevcutUrunMiktari = mevcutUrunMiktari;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public int getMaxStok() {
		return maxStok;
	}

	public void setMaxStok(int maxStok) {
		this.maxStok = maxStok;
	}

}
