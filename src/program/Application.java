package program;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import entities.Product;
import entities.UsedProduct;
import entities.ImportedProduct;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of product: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Employee #"+i+"data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);// charAy (0) Ler uma char em posição específica, no caso 0
			System.out.print("Name: ");
			sc.nextLine();//consumir quebra de linha
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
			if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			
			if (ch == 'c') {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRODUCTS TAGS: ");
		
		for (Product prod:list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();

	}

}
