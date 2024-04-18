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
            String encontraMateria = pfR.findByCpf(cpf).getMateria();
            String encontraUsuario = pfR.findByCpf(cpf).getUsuario();
            if (verificaSenha) {
                acessoProfessor = true;
                url = "redirect:/internaprof/" + encontraUsuario + "/" + encontraMateria;
            } else {
                url = "redirect:/admlog";
            }
        } else {
            System.out.println("usuario não encontrado!");
            url = "redirect:/proflog";
        }
        return url;
    }

    @GetMapping("/internaprof/{usuario}/{materia}") // Corrigido para usar "/"
    public ModelAndView acessoInternaProf(@PathVariable("usuario") String usuario,
            @PathVariable("materia") String materia) {
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

    @GetMapping("/listar-alunoprof/{materia}")
    public ModelAndView listarAlunos(@PathVariable("materia") String materia) {
        ModelAndView modelAndView = new ModelAndView();
        if (acessoProfessor) {
            List<Aluno> alunos = (List<Aluno>) alR.findByMateria1(materia);
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


}
