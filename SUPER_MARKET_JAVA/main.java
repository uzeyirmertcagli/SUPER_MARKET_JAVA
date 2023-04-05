package XI_HAFTA_MARKET;

import java.util.Scanner;

import XI_HAFTA_MARKET.Musteri.servisYapilanMahalleler;
import XI_HAFTA_MARKET.Urun.Miktar;

public class main {

	public enum Urunler {
		SUT(1), YOGURT(2), KASAR(3), CÝLEK(4), ARMUT(5), MUZ(6), MERCÝMEK(7), NOHUT(8), UN(9);

		public int id;

		Urunler(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

	}

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * Hububat nohut = new Hububat("Nohut", 30, 100 , 20);
		 * 
		 * nohut.toptanAlisyap(30); //Depoya 100 Kilo Alýndý int fiyat =
		 * nohut.PerakendeSatisYap(3); //3 Kilo sat 
		 * System.out.println("Satýþ1: " + fiyat);
		 *  int fiyat1= nohut.toptanSatisYap(21); //21 Kilo Sat
		 * System.out.println("Satýþ2: " + fiyat1);
		 *  int fiyat2= nohut.toptanSatisYap(5);
		 * Musteri musteri = new Musteri("Mert", "Çaðlý", "Bilkent");
		 * musteri.alisverisYap("5 Kg Nohut", 90); 
		 * musteri.alisverisYap("3 Kg Elma", 45); 
		 * musteri.alisverisYap("20 Kg Patates", 400);
		 *  musteri.alisverisiTamamla();
		 */

		Scanner scanner = new Scanner(System.in);

		Sut sut = new Sut("Süt", 18, 150, 0);
		Sut yogurt = new Sut("Yoðurt", 45, 300, 15);
		Sut kasar = new Sut("Kaþar", 25, 250, 25);
		MeyveSebze cilek = new MeyveSebze("ÇÝlek", 10, 140, 25);
		MeyveSebze armut = new MeyveSebze("Armut", 14, 200, 40);
		MeyveSebze muz = new MeyveSebze("Muz", 50, 600, 50);
		Hububat mercimek = new Hububat("Mercimek", 15, 500, 40);
		Hububat nohut = new Hububat("Nohut", 12, 200, 30);
		Hububat un = new Hububat("Un", 40, 900, 150);

		while (true) {
			System.out.println("1-Ürün Ýþlemleri , 2-Müþteri Ýþlemleri , 3-Çýkýþ");
			int islem = scanner.nextInt();
			if (islem == 1) {
				for (Urunler urun : Urunler.values())
					System.out.println(urun.getId() + " " + urun);
				System.out.println("Ürün Seçiniz :");
				int urunsecim = scanner.nextInt();
				System.out.println("Miktar Giriniz :");
				int miktar = scanner.nextInt();
				switch (urunsecim) {
				case 1:
					sut.toptanAlisyap(miktar);
				case 2:
					yogurt.toptanAlisyap(miktar);
				case 3:
					kasar.toptanAlisyap(miktar);
				case 4:
					cilek.toptanAlisyap(miktar);
				case 5:
					armut.toptanAlisyap(miktar);
				case 6:
					muz.toptanAlisyap(miktar);
				case 7:
					mercimek.toptanAlisyap(miktar);
				case 8:
					nohut.toptanAlisyap(miktar);
				case 9:
					un.toptanAlisyap(miktar);
				}
			} else if (islem == 2) {
				System.out.println("Adýnýz :");
				String ad = scanner.next();
				System.out.println("Soyadýnýz : ");
				String soyad = scanner.next();
				System.out.println("Eve Servis Ýsteniyor Mu?(1-EVET , 0-HAYIR)");
				int servis = scanner.nextInt();
				String adres = "";
				if (servis == 1) {
					System.out.println("Adresiniz : ");
					adres = scanner.next();
				}

				Musteri musteri = new Musteri(ad, soyad, adres);
				musteri.bilgiler();
				if (servis == 0 || (servis == 1 && musteri.isEveServis())) {

					while (true) {
						System.out.println("1-Perakende , 2-Toptan , 3-Çýkýþ");
						int secim = scanner.nextInt();
						if (secim == 1 || secim == 2) {
							for (Urunler urun : Urunler.values()) {
								if (secim == 1)
									System.out.println(urun.getId() + " " + urun);
								else {
									if (urun.equals(Urunler.SUT) || urun.equals(Urunler.KASAR)
											|| urun.equals(Urunler.YOGURT)) {
									} else
										System.out.println(urun.getId() + " " + urun);
								}
							}
							System.out.println("Ürün Seçiniz : ");
							int secimUrun = scanner.nextInt();
							System.out.println("Miktar Giriniz : ");
							int miktarAlis = scanner.nextInt();

							switch (secimUrun) {
							case 1:
								int fiyat = sut.PerakendeSatisYap(miktarAlis);
								if (fiyat > 0)
									musteri.alisverisYap(miktarAlis + " Kg Süt ", fiyat);
								break;
							case 2:
								int fiyat1 = yogurt.PerakendeSatisYap(miktarAlis);
								if (fiyat1 > 0)
									musteri.alisverisYap(miktarAlis + " Kg Yoðurt ", fiyat1);
								break;
							case 3:
								int fiyat2 = kasar.PerakendeSatisYap(miktarAlis);
								if (fiyat2 > 0)
									musteri.alisverisYap(miktarAlis + " Kg Kaþar ", fiyat2);
								break;
							case 4:
								if (secim == 1) {
									int fiyat3 = cilek.PerakendeSatisYap(miktarAlis);
									if (fiyat3 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Çilek ", fiyat3);
								} else {
									int fiyat3 = cilek.toptanSatisYap(miktarAlis);
									if (fiyat3 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Çilek ", fiyat3);
								}
								break;
							case 5:
								if (secim == 1) {
									int fiyat4 = armut.PerakendeSatisYap(miktarAlis);
									if (fiyat4 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Armut ", fiyat4);
								} else {
									int fiyat4 = armut.toptanSatisYap(miktarAlis);
									if (fiyat4 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Armut ", fiyat4);
								}
								break;
							case 6:
								if (secim == 1) {
									int fiyat5 = muz.PerakendeSatisYap(miktarAlis);
									if (fiyat5 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Muz ", fiyat5);
								} else {
									int fiyat5 = muz.toptanSatisYap(miktarAlis);
									if (fiyat5 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Muz ", fiyat5);
								}
								break;
							case 7:
								if (secim == 1) {
									int fiyat6 = mercimek.PerakendeSatisYap(miktarAlis);
									if (fiyat6 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Mercimek ", fiyat6);
								} else {
									int fiyat6 = mercimek.toptanSatisYap(miktarAlis);
									if (fiyat6 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Mercimek ", fiyat6);
								}
								break;
							case 8:
								if (secim == 1) {
									int fiyat7 = nohut.PerakendeSatisYap(miktarAlis);
									if (fiyat7 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Nohut ", fiyat7);
								} else {
									int fiyat7 = nohut.toptanSatisYap(miktarAlis);
									if (fiyat7 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Nohut ", fiyat7);
								}
								break;

							case 9:
								if (secim == 1) {
									int fiyat8 = un.PerakendeSatisYap(miktarAlis);
									if (fiyat8 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Un ", fiyat8);
								} else {
									int fiyat8 = un.toptanSatisYap(miktarAlis);
									if (fiyat8 > 0)
										musteri.alisverisYap(miktarAlis + " Kg Un ", fiyat8);
								}
								break;
							}

						}

						else if (secim == 3) {
							musteri.alisverisiTamamla();
							break;

						} else {
							System.out.println("Yanlýþ Girdiniz ! ");

						}
					}
				} else if (islem == 3) {
					break;
				}

			}
		}
	}
}
