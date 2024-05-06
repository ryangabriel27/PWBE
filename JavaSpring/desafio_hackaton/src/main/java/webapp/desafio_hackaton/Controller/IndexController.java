package webapp.desafio_hackaton.Controller;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import webapp.desafio_hackaton.Model.Usuario;
import webapp.desafio_hackaton.Repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    boolean acesso = false;

    @Autowired
    UsuarioRepository usR;

    @GetMapping("/")
    public String abrirIndex() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String abrirCadastro() {
        return "cadastro/cad-usuario";
    }

    @PostMapping("cadastrar-usuario")
    public String cadastrarUsuario(Usuario user) {
        try {
            usR.save(user);
            System.out.println("Cadastrado");
        } catch (Exception e) {
            System.out.println("falha :" + e);
        }

        return "redirect:/cadastro";
    }

    @GetMapping("/login")
    public String abrirLogin() {
        return "login/log-usuario";
    }

    @PostMapping("login-usuario")
    public String fazerLogin(@RequestParam String email, @RequestParam String senha) {
        String url = "";
        boolean verificaEmail = usR.existsByEmail(email);
        if (verificaEmail) {
            boolean verificaSenha = usR.findByEmail(email).getSenha().equals(senha);
            if (verificaSenha) {
                int getId = usR.findByEmail(email).getId_usuario();
                acesso = true;
                url = "redirect:/internauser/"+getId;
            } else {
                url = "redirect:/login";
            }
        } else {
            System.out.println("Cpf não encontrado!");
            url = "redirect:/login";
        }
        return url;
    }

    @GetMapping("/internauser/{id_usuario}")
    public String abrirInterna() {
        String url = "";

        if (acesso) {
            url = "interna/home";
        } else {
            url = "redirect:/login";
        }
        return url;
    }

    @GetMapping("/logout")
    public String abrirLogout() {
        acesso = false;
        return "redirect:/";
    }

    @GetMapping("/perfil-usuario/{id_usuario}")
    public ModelAndView verPerfilUsurio(@PathVariable("id_usuario") int id_usuario) {
        ModelAndView modelAndView = new ModelAndView();
        Usuario user = usR.findById(id_usuario);
        if (user != null) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("interna/perfil-usuario");
        } else {
            // Tratar o caso em que o aluno não é encontrado
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
    
    



}
