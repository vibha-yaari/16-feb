package com.example.democontroller;

import com.example.demoentity.Department;
import com.example.demoservice.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("dep")
public class DepController {
    @Autowired
    private DepService depService;

    @GetMapping("/depnew")
    public String departadd(Model model){
        model.addAttribute("department", new Department() );
        return "depnew";
    }


    @GetMapping("/dep")
    public String addemp(Model model){
        List<Department> listdepartment= depService.listAll();
        model.addAttribute("listdepartment",listdepartment);
        return "dep";
    }



    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department dep){
        depService.save(dep);
        return "redirect:/dep";
    }



}
