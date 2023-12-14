package dev.danilobarreto.portalaluno.Controller;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import dev.danilobarreto.portalaluno.Model.TextGenerate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/text")
public class ChatController {
    @Value("${openai.token}")
    private String TOKEN_OPEN_AI;
    @GetMapping("/chat")
    public ModelAndView telaInicio(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }
    @PostMapping
    public Object generate(@RequestBody TextGenerate textGenerate, Model model){
        try {
            OpenAiService service = new OpenAiService(TOKEN_OPEN_AI);

            CompletionRequest completionRequest = CompletionRequest.builder()
                    .model("text-davinci-003")
                    .prompt(textGenerate.getText())
                    .maxTokens(4000)
                    .build();


            model.addAttribute("response", service.createCompletion(completionRequest).getChoices());
            model.addAttribute("error", null); // Limpar qualquer mensagem de erro existente
            return "response"; // Nome do template Thymeleaf (response.html)
        } catch (Exception e) {
            model.addAttribute("response", null); // Limpar qualquer resposta existente
            model.addAttribute("error", e.getMessage());
            return "index"; // Redirecionar de volta para o formulário com mensagem de erro
        }
    }

}
