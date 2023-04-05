package XI_HAFTA_MARKET;

import XI_HAFTA_MARKET.Urun.Miktar;

public class Hububat extends Urun implements PerakendeSatis , ToptanSatis , ToptanAlis{

	public Hububat(String adi, int fiyat, int maxStok , int asgariStok) {
		super(adi, fiyat, maxStok , asgariStok);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void toptanAlisyap(int alisMiktari) {
		this.mevcutUrunMiktari+=alisMiktari;
		
	}

	@Override
	public int toptanSatisYap(int satisMiktari) {
		if(satisMiktari<Miktar.TOPTAN_MIN.getId()) {
			System.out.println("Toptan Alým Ýçin Daha Fazla Almalýsýnýz !");
			return 0;
		}
		if(this.mevcutUrunMiktari<satisMiktari) {
			System.out.println("Yeterli Hububat Yok!");
			return 0;
		}
		if(this.mevcutUrunMiktari-satisMiktari<this.asgariStok) {
			System.out.println("Min Stok Aþýldý!");
		return 0;
		}
		this.mevcutUrunMiktari-=satisMiktari;
		return ((satisMiktari*this.fiyat)*85)/100;
		
	}

	@Override
	public int PerakendeSatisYap(int satisMiktari) {
		if(satisMiktari>Miktar.PERAKENDE_MAX.getId()) {
			System.out.println("Bu Kadar Perakende Alamazsýnýz!");
			return 0;
		}
		if(this.mevcutUrunMiktari-satisMiktari<this.asgariStok) {
			System.out.println("Min Stok Aþýldý!");
		return 0;
		}
		
		if(this.mevcutUrunMiktari<satisMiktari)
			System.out.println("Yeterli Hububat Yok!");
		if(this.mevcutUrunMiktari-satisMiktari<this.asgariStok) {
			System.out.println("Daha Fazla Satýþ Yapamayýz!");
		return 0;
		}
		this.mevcutUrunMiktari-=satisMiktari;
		return satisMiktari*this.fiyat;
		
	}

}
