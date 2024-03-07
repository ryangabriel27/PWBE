package webapp.newsletterjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.newsletterjdbc.connection.IndexDAO;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        new IndexDAO().criaTabela(); // Cria a tabela no banco de dados
        String mensagem = "Olá, seja bem-vinda(o)!";
        mv.addObject("msg", mensagem);

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView enviarEmailBanco(@RequestParam("email") String email, @RequestParam("nome") String nome,
            @RequestParam("senha") String senha, @RequestParam("telefone") String telefone) {
        ModelAndView mv = new ModelAndView("index");
        new IndexDAO().cadastrar(nome, email, telefone, senha);
        return mv;
    }

}
