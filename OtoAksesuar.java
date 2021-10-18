package omsa.aksesuarlar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class OtoAksesuar {

	private static final String WEBSITE = "https://www.otoaksesuar.com";

	static	BufferedWriter bw = null;

	public static void main(String[] args) {
		
		File file = new File("D:/Users/Mert/Desktop/productList.txt");
		FileWriter fw;
		try {
			//Creates a file
			 if (!file.exists()) {
			     file.createNewFile();
			     System.out.println("New File Created!");
			  }
			 
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			scanCathegory();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void scanCathegory() {
		Document document;
		ArrayList<String> aracKategori = new ArrayList<String>();
		
		try {
			
			document = Jsoup.connect(WEBSITE + "/kategoriler.html").get();
			Elements katagori = document.select("td.wpe25 > a");
			
			
			//gets the categories
			for (Element marka : katagori) {
				String markalar = marka.attr("href");
				aracKategori.add(markalar);
				
				System.out.print(markalar + "\n");
			}
			
			
			for(String kategor : aracKategori) {
				scanItem(kategor);
				
			}
			
			//scanItem(aracKategori.get(0));
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	static int i, j, k;
	
	public static void scanItem(String cat) {
		
		Document document;
		ArrayList<Araclar> arac = new ArrayList<Araclar>();	
		
	
		try {
	
			document = Jsoup.connect(WEBSITE + cat).get();
				
	
			Elements product = document.select("div.showcaseTitle");
			Elements price = document.select("div.showcasePriceOne");
			Elements brand = document.select("div.filterProductGroupsLevel-2-Title");
			String model = brand.text();
			
			
			//gets the product
			for (Element aksesuar : product) {
				String urun = " ";
				urun = aksesuar.getElementsByTag("a").first().text();
				Araclar s = new Araclar(k, i, "0", model, urun);
				arac.add(s);
				i++; k++;	} i=0;
			
	
			//gets the price
			for (Element element : price) {
				String fiyat = " ";
				fiyat = element.getElementsByClass("showcasePriceOne").text();
				arac.get(j).setPrice(fiyat);
				j++;	} j=0;
			

			//System.out.print(arac.toString());
			bw.write(arac.toString());
			System.out.print(model + " yazýldý\n");
			
			
		}
		catch (IOException ignored) {
		System.out.println("Could not scan items!");
		return;
		}
		
				
	}
}

