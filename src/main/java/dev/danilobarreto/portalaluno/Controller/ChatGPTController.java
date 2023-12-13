package dev.danilobarreto.portalaluno.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dev.danilobarreto.portalaluno.Service.ChatGPTService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/chatgpt")
public class ChatGPTController {
    private final ChatGPTService chatGPTService;

    @Autowired
    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }


    @GetMapping("/chat")
    public ModelAndView exibirPaginaDeChat(@RequestParam(name = "pergunta", required = false) String pergunta) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("aluno/chat");
        
        List<String> mensagens = inicializarMensagens();
        modelAndView.addObject("mensagens", mensagens);

        // Se uma pergunta foi fornecida, obtenha uma resposta do ChatGPT
        if (pergunta != null) {
            String respostaDoChatGPT = chatGPTService.obterRespostaDoChatGPT(pergunta);
            mensagens.add("Você: " + pergunta);
            mensagens.add("ChatGPT: " + respostaDoChatGPT);
        }

        return modelAndView;
    }

    private List<String> inicializarMensagens() {
        List<String> mensagens = new ArrayList<>();
        mensagens.add("Bem-vindo ao professor horario!");
        return mensagens;
    }
}


