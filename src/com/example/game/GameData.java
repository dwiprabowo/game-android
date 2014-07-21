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
			new Question("Berasal dari manakah\nTari Merak Bungo?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Sekapur Sirih?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Kipas?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Cakalele?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Mengket?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Pepatay?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Likok Pulo?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Belian?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Tambun?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			new Question("Berasal dari manakah\nTari Jaipong?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_TARI_TRADISIONAL),
			// nama pahlawan
			new Question(
					"sisingamangaraja_xii",
					"pahlawan tersebut\nbernama...", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"sultan_hasanuddin",
					"siapakah yang ada\n pada gambar\ntersebut?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"pangeran_antasari",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"kh_ahmad_dahlan",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"cut_nyak_dien",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"raden_dewi_sartika",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"h_agus_salim",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"ki_hajar_dewantara",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"sutan_syahrir",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			new Question(
					"oto_iskandar_dinata",
					"nama pahlawan?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_PAHLAWAN),
			// lagu daerah
			new Question("Berasal dari manakah\nlagu Gambang Suling?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Ampar-Ampar Pisang?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Bungong Jeumpa?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Bolelebo?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Yamko Rambe Yamko?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu O Ina Keke?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Butet?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Burung Tantina?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Angin Mamiri?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			new Question("Berasal dari manakah\nlagu Kicir-Kicir?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_LAGU_DAERAH),
			// nama bandara
			new Question("Di provinsi manakah\nBandara Tunggul Wulung\nberada?", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Sultan Babullah\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Sepinggan\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Hang Nadim\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Husein\nSastranegara\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Ngurah Rai\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Pattimura\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Sam Ratulangi\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Sentani\nberada?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_BANDARA),
			new Question("Di provinsi manakah\nBandara Supadio\nberada?", 
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
					"kecapi",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"kulintang",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"rebab",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"sampek",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"sasando",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"saluang",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"tifa",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"triton",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			new Question(
					"rapai",
					"Apakah nama dari\nalat musik\ndiatas?", 
					new String[]{
					"Magelang", 
					"Solo",
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_ALAT_MUSIK),
			// nama kerajaan
			new Question("Kerajaan tertua\ndi Indonesia\nadalah .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Kerajaan yang memiliki\nRaja Balaputradewa\nadalah .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Raja Jayabaya\nadalah raja yang\nterkenal dari kerajaan ....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Patih Gajah Mada\nberasal dari\nkerajaaan .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Kerajaan Islam\npertama di Indonesia\nadalah ......", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Candi Borobudur\ndan Prambanan\npeninggalan kerajaan", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Kerajaan yang\ndidirikan oleh\nRaden Patah", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Sultan Agung\nadalah raja terkenal\ndari kerajaan", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Sultan Hasanuddin\nadalah sultan dari\nkerajaan .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			new Question("Kerajaan yang\nterdapat pada Kitab\nPararaton dan Kitab\nNegara Kertagama\nadalah kerajaan .....", 
					new String[]{
					"Magelang", 
					"Solo", 
					"Yogya", 
					"Denpasar"}, 3, Constants.KATEGORI_NAMA_KERAJAAN),
			
	};

}
