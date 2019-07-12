package Venator.Venator.controller;

import Venator.Venator.forms.commands.FormCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class FormController {


    private static final Log logger = LogFactory.getLog(FormController.class);

    @GetMapping("/fooform")
    public String fooForm(Model model) {
        model.addAttribute( "command", new FormCommand());

        return "fooForm";
    }

    @ModelAttribute("multiCheckboxAllValues")
    public String[] getMultiCheckboxAllValues() {
        return new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    }


    // set of values applied to a single-select radio button set, and drop-down list.
    @ModelAttribute("singleSelectAllValues")
    public String[] getSingleSelectAllValues() {
        return new String[] {"YES", "NO", "MAYBE"};
    }


    @PostMapping("/fooform")
    public String foobarPost(
            @ModelAttribute("command") FormCommand command,
            // WARN: BindingResult *must* immediately follow the Command.
            // https://stackoverflow.com/a/29883178/1626026
            BindingResult bindingResult,
            Model model,
            RedirectAttributes ra ) {

        logger.debug("form submission.");

        if ( bindingResult.hasErrors() ) {
            return "fooForm";
        }

        ra.addFlashAttribute("command", command);

        return "redirect:/fooresult";
    }

    @GetMapping("/fooresult")
    public String fooresult(
            @ModelAttribute("command") FormCommand command,
            Model model) {

        logger.debug( "!!!" + command.toString());

        return "fooResult";
    }

}