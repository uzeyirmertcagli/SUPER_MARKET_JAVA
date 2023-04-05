package XI_HAFTA_MARKET;

import java.util.ArrayList;

public class Musteri extends Human {
	
	public enum servisYapilanMahalleler{
		BILKENT("Bilkent"),
		YENÝMAHALLE("Yenimahalle"),
		CEBECÝ("Cebeci");
		public String mah;

		servisYapilanMahalleler(String mah) {
			this.mah = mah;
		}
		public String getmah() {
			return this.mah;
		}
	}
	
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<Integer> fiyatListesi = new ArrayList<Integer>();
	private servisYapilanMahalleler servisYapilanMah;
	
	public Musteri(String ad, String soyad, String adres ) {
		super(ad, soyad, adres ,  eveServisHesapla(adres));
		
	}

	public void alisverisYap(String urun , Integer fiyat) {
		this.list.add(urun);
		this.fiyatListesi.add(fiyat);
	}
	
	public void alisverisiTamamla() {
	Integer toplam=0;
		for(int i=0 ; i<this.list.size();i++) {
		System.out.println(this.list.get(i)+ " : " + this.fiyatListesi.get(i));
			toplam+=this.fiyatListesi.get(i);
		}
		System.out.println("Toplam Fiyat = " + toplam);
	}
	

	public static boolean eveServisHesapla(String adres) {
		for(servisYapilanMahalleler serMah : servisYapilanMahalleler.values()) {
			if(adres.equals(serMah.getmah())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void bilgiler() {
		System.out.println("Müþteri Ad : " + this.ad);
		System.out.println("Müþteri Soyad : " + this.soyad);
		System.out.println("Müþteri Adres : " + this.adres);
		System.out.println("Eve Servis Olacak Mý ? : "+ (this.eveServis?"Evet":"Hayýr"));
		
		
	}

}
