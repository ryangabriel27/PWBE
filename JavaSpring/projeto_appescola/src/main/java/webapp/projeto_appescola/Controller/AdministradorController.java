package webapp.projeto_appescola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webapp.projeto_appescola.Model.Administradores;
import webapp.projeto_appescola.Model.Aluno;
import webapp.projeto_appescola.Repository.AdministradoresRepository;
import webapp.projeto_appescola.Repository.AlunoRepository;
import webapp.projeto_appescola.Repository.VerificaCadastroAdmRepository;

import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private AlunoRepository alR;

    boolean acessoAdm = false;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administradores adm) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            admR.save(adm);
            System.out.println("Cadastrado com sucesso!");
        } else {
            System.out.println("Falha ao cadastrar");
        }

        return "redirect:/admlog";
    }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        String url = "";
        if (acessoAdm) {
            url = "interna/interna-adm";
            acessoAdm = true;
        } else {
            url = "redirect:admlog";
        }
        return url;
    }

    @PostMapping("acesso-adm")
    public String acessoAdm(@RequestParam String cpf, @RequestParam String senha) {
        String url = "";
        boolean verificaCpf = admR.existsById(cpf);
        if (verificaCpf) {
            boolean verificaSenha = admR.findByCpf(cpf).getSenha().equals(senha);
            if (verificaSenha) {
                acessoAdm = true;
                url = "redirect:/interna-adm";
            } else {
                url = "redirect:/admlog";
            }
        } else {
            System.out.println("Cpf não encontrado!");
            url = "redirect:/admlog";
        }
        return url;
    }

    @GetMapping("/cadastrar-aluno")
    public String acessarCadAluno() {
        String url = "";
        if (acessoAdm) {
            url = "interna/interna-cadaluno";
        } else {
            url = "redirect:admlog";
        }
        return url;
    }

    @PostMapping("cadastro-aluno")
    public String cadastroAluno(Aluno aluno) {
        try {
            alR.save(aluno);
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao cadastrar!" + e);
        }

        return "redirect:/cadastrar-aluno";
    }

    @GetMapping("/cadastrar-prof")
    public String acessoCadastroProf() {
        String url = "";
        if (acessoAdm) {
            url = "interna/interna-cadaluno";
        } else {
            url = "redirect:admlog";
        }
        return url;
    }
    

}
