import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("======= TEST 1: Seller findById =========");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n======= TEST 2: Seller findByDepartment =========");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n======= TEST 3: Seller findAll =========");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n======= TEST 4: Seller insert =========");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Id = " + newSeller.getId());

        System.out.println("\n======= TEST 5: Seller update =========");
        seller = sellerDao.findById(9);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n======= TEST 6: Seller delete =========");
        sellerDao.deleteById(10);
        sellerDao.deleteById(11);
        System.out.println("Deletion completed");
    }
}