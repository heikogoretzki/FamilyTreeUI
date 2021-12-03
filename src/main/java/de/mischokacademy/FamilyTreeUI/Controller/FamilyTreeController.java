package de.mischokacademy.FamilyTreeUI.Controller;

import de.mischokacademy.FamilyTreeUI.Domain.Human;
import de.mischokacademy.FamilyTreeUI.Domain.Beans.HumanBean;
import org.springframework.lang.NonNullFields;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class FamilyTreeController {
    private static final List<HumanBean> humanBeanList = new ArrayList<>();
    private static final List<Human> humanList = new ArrayList<>();

    @GetMapping
    public String inputForm(Model model) {
        Objects.requireNonNull(model);

        model.addAttribute("humanBeanForm", new HumanBean());
        model.addAttribute("humanBeanList", humanBeanList);
        model.addAttribute("humanList", humanList);

        return "inputForm";
    }

    @PostMapping
    public String saveInput(@Valid @ModelAttribute("humanBeanForm") HumanBean humanBean, BindingResult bindingResult, Model model) {
        Objects.requireNonNull(model);

        System.out.println(bindingResult);

        if (bindingResult.hasErrors()) {
            return "inputForm";
        }

        humanBeanList.add(humanBean);

        convertHumanBeanToHuman(humanBean);

        model.addAttribute("humanBeanForm", new HumanBean());
        model.addAttribute("humanBeanList", humanBeanList);
        model.addAttribute("humanList", humanList);

        System.out.println(humanList);

        return "inputForm";
    }

    private void convertHumanBeanToHuman(HumanBean humanBean) {
        Objects.requireNonNull(humanBean);

        Human newHuman = new Human();
        newHuman.setFirstName(humanBean.getFirstName());
        newHuman.setLastName(humanBean.getLastName());
        newHuman.setAge(humanBean.getAge());

        if (humanBean.getMother() != null) {
            newHuman.setMother(humanList.get(humanBean.getMother()));
        }

        if (humanBean.getFather() != null) {
            newHuman.setFather(humanList.get(humanBean.getFather()));
        }

        humanList.add(newHuman);
    }
}
