package webapp.projeto_appescola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webapp.projeto_appescola.Model.AdministradorModel;
import webapp.projeto_appescola.Repository.AdministradorRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    @Autowired
    private AdministradorRepository admR;

    @RequestMapping(value = "/cadastros/admCad", method = RequestMethod.GET)
    public String abrirAdmCad() {
        return "cadastros/admCad";
    }

    @RequestMapping(value = "/cadastros/admCad", method = RequestMethod.POST)
    public String cadastrarADM(AdministradorModel adm) {
        admR.save(adm);
        return "redirect:/cadastros/admCad";
    }
}
