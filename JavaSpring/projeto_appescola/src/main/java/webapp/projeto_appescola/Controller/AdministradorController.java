package webapp.projeto_appescola.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import webapp.projeto_appescola.Model.Administradores;
import webapp.projeto_appescola.Model.Aluno;
import webapp.projeto_appescola.Model.NotasFaltas;
import webapp.projeto_appescola.Model.Professor;
import webapp.projeto_appescola.Repository.AdministradoresRepository;
import webapp.projeto_appescola.Repository.AlunoRepository;
import webapp.projeto_appescola.Repository.NotasFaltasRepository;
import webapp.projeto_appescola.Repository.ProfessoresRepository;
import webapp.projeto_appescola.Repository.VerificaCadastroAdmRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdministradorController {
    

    @Autowired
    private AdministradoresRepository admR;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    @Autowired
    private ProfessoresRepository pfR;

    @Autowired
    private AlunoRepository alR;

    @Autowired
    private NotasFaltasRepository nfR;

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
            NotasFaltas nf = new NotasFaltas(0,0,aluno.getId_aluno());
            nfR.save(nf);
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Falha ao cadastrar!" + e);
        }

        return "redirect:/cadastrar-aluno";
    }

    @PostMapping("cadastro-prof")
    public String cadastroProf(Professor prof) {
        try {
            pfR.save(prof);
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
            url = "interna/interna-cadprof";
        } else {
            url = "redirect:admlog";
        }
        return url;
    }

    @GetMapping("/listar-aluno")
    public ModelAndView listarAlunos() {
        ModelAndView modelAndView = new ModelAndView();

        if (acessoAdm) {
            List<Aluno> alunos = (List<Aluno>) alR.findAll();
            modelAndView.addObject("alunos", alunos);
            modelAndView.setViewName("interna/interna-listaaluno");
        } else {
            modelAndView.setViewName("redirect:admlog");
        }

        return modelAndView;
    }

    @GetMapping("/listar-prof")
    public ModelAndView listarProf() {
        ModelAndView modelAndView = new ModelAndView();

        if (acessoAdm) {
            List<Professor> profs = (List<Professor>) pfR.findAll();
            modelAndView.addObject("profs", profs);
            modelAndView.setViewName("interna/interna-listaprof");
        } else {
            modelAndView.setViewName("redirect:admlog");
        }

        return modelAndView;
    }

    @GetMapping("/logout-adm")
    public String logoutAdm() {
        acessoAdm = false;

        return "redirect:/home";
    }

    @GetMapping("/deletaraluno/{id_aluno}")
    public String deletarFuncionario(@PathVariable("id_aluno") Long id) {
        alR.deleteById(id);
        return "redirect:/listar-aluno";
    }

    @GetMapping("/editaraluno/{id_aluno}")
    public ModelAndView abrireditarfuncionario(@PathVariable("id_aluno") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Aluno aluno = alR.findById(id).orElse(null);
        if (aluno != null) {
            modelAndView.addObject("aluno", aluno);
            modelAndView.setViewName("interna/interna-editaaluno");
        } else {
            // Tratar o caso em que o aluno não é encontrado
            modelAndView.setViewName("redirect:/interna-listaaluno");
        }
        return modelAndView;
    }

    @PostMapping("/editaraluno/{usuario}")
    public String editarAluno(Aluno aluno) {
        System.err.println(aluno.getNome_completo());
        //alR.save(aluno);
        return "redirect:/listar-aluno";
    }

}
