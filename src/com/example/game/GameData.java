package com.example.game;

public interface GameData {
	
	Question[] QUESTIONS = {
			new Question("Apakah nama Ibukota\nProvinsi Bali?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"
					}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Banten?", 
					new String[]{
					"Jakarta", 
					"Bandung", 
					"Bogor", 
					"Banten"
					}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Jawa Timur?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Kalimantan Timur?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Bangka Belitung?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Maluku Utara?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi\nNusa Tenggara Barat?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Papua?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Sulawesi Barat?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
			new Question("Apakah nama Ibukota\nProvinsi Sumatera Selatan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_IBU_KOTA),
					
			// tari
			new Question("Berasal dari manakah Tari Merak Bungo?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah Tari Sekapur Sirih?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			// nama pahlawan
			new Question(
					"1",
					"pahlawan tersebut\nbernama...", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"1",
					"siapakah yang ada\n pada gambar\ntersebut?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			// lagu daerah
			new Question("Berasal dari manakah lagu Gambang Suling?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah lagu Ampar-Ampar Pisang?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			// nama bandara
			new Question("Di provinsi manakah Bandara Hang Nadim berada?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah Bandara Husein Sastranegara berada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			// nama alat musik
			new Question(
					"angklung",
					"Berasal darimanakah\nalat musik\ntersebut?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"angklung",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			// nama kerajaan
			new Question("Sultan Hasanuddin adalah sultan dari kerajaan .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Kerajaan yang terdapat pada Kitab Pararaton dan Kitab Negara Kertagama adalah kerajaan .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			
	};

}
