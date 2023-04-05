package XI_HAFTA_MARKET;

public class Sut extends Urun implements PerakendeSatis , ToptanAlis {

	public Sut(String adi, int fiyat, int maxStok , int asgariStok) {
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
	public int PerakendeSatisYap(int satisMiktari) {
		if(this.mevcutUrunMiktari<satisMiktari) {
			System.out.println("Yeterli Süt Yok!");
		return 0;
	}
		this.mevcutUrunMiktari-=satisMiktari;
		return satisMiktari*this.fiyat;
		
	}

}
