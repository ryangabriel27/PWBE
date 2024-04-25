package webapp.projeto_appescola.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.projeto_appescola.Model.Aluno;
import webapp.projeto_appescola.Model.Materias;
import webapp.projeto_appescola.Model.NotasFaltas;
import webapp.projeto_appescola.Model.Professor;
import webapp.projeto_appescola.Repository.AlunoRepository;
import webapp.projeto_appescola.Repository.NotasFaltasRepository;
import webapp.projeto_appescola.Repository.ProfessoresRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfessorController {

    @Autowired
    ProfessoresRepository pfR;

    @Autowired
    AlunoRepository alR;

    @Autowired
    NotasFaltasRepository nfR;

    boolean acessoProfessor = false;

    @PostMapping("acesso-prof")
    public String acessoProfessor(@RequestParam String cpf, @RequestParam String senha) {
        String url = "";
        boolean verificaCpf = pfR.existsById(cpf);
        if (verificaCpf) {
            boolean verificaSenha = pfR.findByCpf(cpf).getSenha().equals(senha);
            String encontraUsuario = pfR.findByCpf(cpf).getUsuario();
            if (verificaSenha) {
                acessoProfessor = true;
                url = "redirect:/internaprof/" + encontraUsuario;
            } else {
                url = "redirect:/admlog";
            }
        } else {
            System.out.println("usuario não encontrado!");
            url = "redirect:/proflog";
        }
        return url;
    }

    @GetMapping("/internaprof/{usuario}") // Corrigido para usar "/"
    public ModelAndView acessoInternaProf(@PathVariable("usuario") String usuario) {
        ModelAndView mv = new ModelAndView();
        if (acessoProfessor) {
            String msg = "Bem vindo, " + usuario;
            mv.addObject("msg", msg);
            mv.setViewName("internaprof/internaprof-home");
        } else {
            mv.setViewName("redirect:/proflog");
        }
        return mv;
    }

    @GetMapping("/listar-alunoprof/{usuario}")
    public ModelAndView listarAlunos(@PathVariable("usuario") String usuario) {
        ModelAndView modelAndView = new ModelAndView();
        if (acessoProfessor) {
            Professor prof = pfR.findByUsuario(usuario);
            List<Aluno> alunos = alR.findByMateria1(prof.getMateria());
            modelAndView.addObject("alunos", alunos);
            modelAndView.setViewName("internaprof/internaprof-listaluno");
        } else {
            modelAndView.setViewName("redirect:proflog");
        }

        return modelAndView;
    }

    @GetMapping("/editarNota/{id_aluno}")
    public ModelAndView abrirEditarNotaAluno(@PathVariable("id_aluno") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Aluno aluno = alR.findById(id).orElse(null);
        if (aluno != null) {
            modelAndView.addObject("aluno", aluno);
            modelAndView.setViewName("internaprof/internaprof-nota");
        } else {
            // Tratar o caso em que o aluno não é encontrado
            modelAndView.setViewName("redirect:/internaprof-home");
        }
        return modelAndView;
    }

    @GetMapping("/perfil-prof/{usuario}")
    public ModelAndView verPerfilProf(@PathVariable("usuario") String usuario) {
        ModelAndView modelAndView = new ModelAndView();
        Professor prof = pfR.findByUsuario(usuario);
        if (prof != null) {
            modelAndView.addObject("prof", prof);
            modelAndView.setViewName("internaprof/internaprof-perfil");
        } else {
            // Tratar o caso em que o aluno não é encontrado
            modelAndView.setViewName("redirect:/proflog");
        }
        return modelAndView;
    }

    @GetMapping("/logout-prof")
    public String logoutAdm() {
        acessoProfessor = false;

        return "redirect:/home";
    }
    

}
