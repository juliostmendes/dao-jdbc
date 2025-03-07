import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class MainDepartment {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("======= TEST 1: Department findAll =========");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj.getName());
        }
    }
}
