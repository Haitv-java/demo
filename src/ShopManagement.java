import com.aptech.ishop.controller.CategoriesController;
import com.aptech.ishop.controller.ProductController;
import com.aptech.ishop.entity.Categories;
import com.aptech.ishop.entity.Product;
import com.aptech.ishop.service.impl.CategoriesServiceImpl;
import com.aptech.ishop.service.impl.ProductServiceServiceImpl;
import com.aptech.ishop.utils.ShowMenu;

import java.util.List;
import java.util.Scanner;

public class ShopManagement {
	public void run() {
		CategoriesController categoriesController = new CategoriesController();
		ProductController productController = new ProductController();
		List<Product> productList = ProductServiceServiceImpl.readObjectProductList();
		List<Categories> categoriesList = CategoriesServiceImpl.readObjectFileCategories();

		Scanner sc = new Scanner(System.in);
		boolean active = true;
		do {
			ShowMenu.showMenu();
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
				case 1:
					categoriesController.categoryCase(categoriesList, sc);
					break;
				case 2:
					productController.productCase(sc, productList);
					break;
				case 3:
					CategoriesServiceImpl.writeObjectFileCategories(categoriesList);
					ProductServiceServiceImpl.writeObjectFileProduct(productList);
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
