package org.jsp.employeedb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeeController 
{
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("main")
	String welcome()
	{
		return "Welcome.jsp";
	}
	
	@RequestMapping("addEmp")
	String addEmp(Employee e,HttpSession h1 ) {
		repo.save(e);
		h1.setAttribute("msg", e.getEname()+" had been added into Db...!!!!");
		return "AddEmply.jsp";
		
	}
	
	@RequestMapping("removeEmp")
	String removeEmp(String eid,HttpSession h1)
	{
		Optional<Employee> e= repo.findById(eid);
		if(e.isPresent())
				{
					repo.deleteById(eid);
					h1.setAttribute("value",e.get().getEname()+"had been removed....!!!");
				}
				else
				{
					h1.setAttribute("value","Invalid Eid....!!");
				}
				return "RemoveEmp.jsp";
	}
	
	@RequestMapping("EmpById")
	String empById(String eid,HttpSession h1)
	{
		Employee e=repo.findById(eid).orElse(null);
		if(e!=null)
				{
			h1.setAttribute("info",e);
				}
		else
		{
			h1.setAttribute("info","Invalid Eid.....!:)");
		}
		return "EmplyById.jsp";
		
	}
	
	@RequestMapping("EmpByAge")
	String findByAge(int age,HttpSession h1)
	{
		 List<Employee> l1=repo.findByAge(age);
		 if(l1.size()==0)
		 {
			 h1.setAttribute("moon","Employees not Found");
		 }
		 else
		 {
			 h1.setAttribute("moon", l1);
		 }
	return "EmpByAge.jsp";
	}
	

}
