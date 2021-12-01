package de.mischokacademy.FamilyTreeUI.Controller;

import de.mischokacademy.FamilyTreeUI.Domain.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FamilyTreeController {
    private static List<Human> humanList = new ArrayList<>();

    @GetMapping
    public String inputForm(Model model) {

        model.addAttribute("saveInputForm", new Human());
        model.addAttribute("humanList", humanList);

        return "inputForm";
    }

    @PostMapping
    public String saveInput(Model model, Human human) {
        humanList.add(human);
        System.out.println(humanList);

        model.addAttribute("saveInputForm", new Human());
        model.addAttribute("humanList", humanList);

        return "inputForm";
    }

}
