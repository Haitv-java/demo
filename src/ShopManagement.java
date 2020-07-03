import com.aptech.ishop.controller.CategoriesController;
import com.aptech.ishop.controller.ProductController;
import com.aptech.ishop.entity.Categories;
import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.impl.CategoriesServiceImpl;
import com.aptech.ishop.service.impl.ProductServiceImpl;
import com.aptech.ishop.utils.ShowMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
	private CategoriesController categoriesController;
	private ProductController productController;

	public ShopManagement(CategoriesController categoriesController, ProductController productController) {
		this.categoriesController = categoriesController;
		this.productController = productController;
	}

	public void run() {
		List<Categories> categoriesList = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		ProductServiceImpl.readObjectProductList(productList);
		CategoriesServiceImpl.readObjectFileCategories(categoriesList);

		Scanner sc = new Scanner(System.in);
		boolean active = true;
		do {
			ShowMenu.showMenu();
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
				case 1:
					categoriesController.rootOneCase(categoriesList, sc);
					break;
				case 2:
					productController.rootTwoCase(sc, productList);
					break;
				case 3:
					CategoriesServiceImpl.writeObjectFileCategories(categoriesList);
					ProductServiceImpl.writeObjectFileProduct(productList);
					active = false;
					break;
				default:
					System.err.println("Nhap lai lua chon cua ban");
			}
		} while (active);
	}

	public static void main(String[] args) {
		ShopManagement shopManagement = new ShopManagement();
		shopManagement.run();
	}
}