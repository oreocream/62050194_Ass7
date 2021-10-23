/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentbase_ass7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 *
 * @author Pongsiri
 */
public class Componentbase_Ass7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Menu 1.Add Employee 2.Update Employee 3. Delete Employee");
        int select = input.nextInt();
        
        if(select == 1) {
            System.out.println("1.Fulltime 2. Parttime");
            int type = input.nextInt();
            if(type == 1) {
                FulltimeEmployee emp = new FulltimeEmployee();
                System.out.print("Name : ");
                String name = input.next();
                System.out.print("Salary : ");
                int salary = input.nextInt();
                
                emp.setName(name);
                emp.setSalary(salary);
                
                FulltimeTable.insertEmployee(emp);
            }
            if(type == 2) {
                ParttimeEmployee emp = new ParttimeEmployee();
                System.out.print("Name : ");
                String name = input.next();
                System.out.print("Hours Work : ");
                int hoursWork = input.nextInt();
                
                emp.setName(name);
                emp.setHoursWork(hoursWork);
                
                ParttimeTable.insertEmployee(emp);
            }
        } else if(select == 2) {
            System.out.print("ID : ");
            Long id = input.nextLong();
            FulltimeEmployee emp = new FulltimeEmployee();
            emp = FulltimeTable.findEmployeeById(id);
            
            System.out.print("New Name : ");
            String name = input.next();
            emp.setName(name);
            System.out.print("New Salary : ");
            int salary = input.nextInt();
            emp.setSalary(salary);
            
            FulltimeTable.updateEmployee(emp);
        } else if (select == 3) {
            System.out.print("ID : ");
            Long id = input.nextLong();
            FulltimeEmployee emp = new FulltimeEmployee();
            emp = FulltimeTable.findEmployeeById(id);
            
            FulltimeTable.removeEmployee(emp);
        }
        
//        FulltimeEmployee emp1 = new FulltimeEmployee();
//        emp1.setName("Jo");
//        emp1.setSalary(10000);
//        ParttimeEmployee emp2 = new ParttimeEmployee();
//        emp2.setName("First");
//        emp2.setHoursWork(8);
//        persist(emp1);
//        persist(emp2);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Componentbase_Ass7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

    

