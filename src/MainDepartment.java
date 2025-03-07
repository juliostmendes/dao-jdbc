import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class MainDepartment {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("======= TEST 1: Department by id =========");
        Department dep = departmentDao.findById(2);
        System.out.println(dep.getId() + ", " + dep.getName());

        System.out.println("\n======= TEST 2: Department findAll =========");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj.getName());
        }

        System.out.println("\n======= TEST 3: Department insert =========");

        System.out.println("\n======= TEST 4: Department update =========");
        dep = departmentDao.findById(6);
        dep.setName("Human resources");
        departmentDao.update(dep);
        System.out.println("Update completed");

        System.out.println("\n======= TEST 5: Department delete =========");

    }
}
