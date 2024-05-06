package webapp.projeto_appescola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/home")
    public String acessoHome() {
        return "index";
    }

    @GetMapping("/admlog")
    public String acessoLoginAdm() {
        return "login/admlog";
    }

    @GetMapping("/admcad")
    public String acessoCadastroAdm() {
        return "cadastro/admcad";
    }

    @GetMapping("/proflog")
    public String acessoLoginProf() {
        return "login/proflog";
    }

    @GetMapping("/alunolog")
    public String acessoLoginAluno() {
        return "login/alunolog";
    }
    
}
