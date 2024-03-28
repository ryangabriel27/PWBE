package webapp.projeto_appescola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webapp.projeto_appescola.Model.Administradores;
import webapp.projeto_appescola.Repository.AdministradoresRepository;
import webapp.projeto_appescola.Repository.VerificaCadastroAdmRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdministradorController {

    @Autowired
    private AdministradoresRepository admR;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administradores adm) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            admR.save(adm);
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar");
        }

        return "login/admlog";
    }

}
