package webapp.projeto_appescola.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.projeto_appescola.Model.Aluno;
import webapp.projeto_appescola.Model.Professor;
import webapp.projeto_appescola.Repository.AlunoRepository;
import webapp.projeto_appescola.Repository.ProfessoresRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository alR;
    
    @Autowired
    ProfessoresRepository pfR;

    boolean acessoAluno = false;

    @PostMapping("acesso-aluno")
    public String acessoAluno(@RequestParam String email, @RequestParam String senha) {
        String url = "";
        boolean verificaEmail = alR.existsByEmail(email);
        if (verificaEmail) {
            boolean verificaSenha = alR.findByEmail(email).getSenha().equals(senha);
            String encontraUsuario = alR.findByEmail(email).getUsuario();
            if (verificaSenha) {
                acessoAluno = true;
                url = "redirect:/internaaluno/" + encontraUsuario;
            } else {
                url = "redirect:/alunolog";
            }
        } else {
            System.out.println("usuario não encontrado!");
            url = "redirect:/alunolog";
        }
        return url;
    }

    @GetMapping("/internaaluno/{usuario}")
    public ModelAndView acessoInternaAluno(@PathVariable("usuario") String usuario) {
        ModelAndView mv = new ModelAndView();
        if (acessoAluno) {
            String msg = "Bem vindo, " + usuario;
            mv.addObject("msg", msg);
            mv.setViewName("internaaluno/internaaluno-home");
        } else {
            mv.setViewName("redirect:/alunolog");
        }
        return mv;
    }

    @GetMapping("/perfil-aluno/{usuario}")
    public ModelAndView verPerfilAluno(@PathVariable("usuario") String usuario) {
        ModelAndView modelAndView = new ModelAndView();
        Aluno aluno = alR.findByUsuario(usuario);
        if (aluno != null) {
            modelAndView.addObject("aluno", aluno);
            modelAndView.setViewName("internaaluno/internaaluno-perfil");
        } else {
            // Tratar o caso em que o aluno não é encontrado
            modelAndView.setViewName("redirect:/alunolog");
        }
        return modelAndView;
    }

    @GetMapping("/ver-professor/{usuario}")
    public ModelAndView verProfessor(@PathVariable("usuario") String usuario) {
        ModelAndView modelAndView = new ModelAndView();
        if (acessoAluno) {
            Aluno aluno = alR.findByUsuario(usuario);
            List<Professor> profs = pfR.findAllByMateria(aluno.getMateria1());
            modelAndView.addObject("profs", profs);
            modelAndView.setViewName("internaaluno/internaaluno-prof");
        } else {
            modelAndView.setViewName("redirect:internaaluno/"+usuario);
        }

        return modelAndView;
    }


    @GetMapping("/logout-aluno")
    public String logoutAdm() {
        acessoAluno = false;

        return "redirect:/home";
    }
}
