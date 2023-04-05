package XI_HAFTA_MARKET;

import XI_HAFTA_MARKET.Urun.Miktar;

public class MeyveSebze extends Urun implements PerakendeSatis , ToptanSatis , ToptanAlis{

	public MeyveSebze(String adi, int fiyat, int maxStok , int asgariStok) {
		super(adi, fiyat, maxStok, asgariStok);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void toptanAlisyap(int alisMiktari) {
		if((this.mevcutUrunMiktari+alisMiktari)>maxStok)
			this.mevcutUrunMiktari=this.maxStok;
		else
			this.mevcutUrunMiktari+=alisMiktari;
		
	}

	@Override
	public int toptanSatisYap(int satisMiktari) {
		if(satisMiktari<Miktar.TOPTAN_MIN.getId()) {
			System.out.println("Toptan Alým Ýçin Daha Fazla Almalýsýnýz !");
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
		
		if(this.mevcutUrunMiktari<satisMiktari) {
			System.out.println("Yeterli Meyve Sebze Yok!");
		return 0;
	}
		if(this.mevcutUrunMiktari-satisMiktari<this.asgariStok) {
			System.out.println("Min Stok Aþýldý!");
		return 0;
		}
		this.mevcutUrunMiktari-=satisMiktari;
		return satisMiktari*this.fiyat;
		
	}

}
