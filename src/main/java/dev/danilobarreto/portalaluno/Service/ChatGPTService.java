package dev.danilobarreto.portalaluno.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
    @Service
    
    public class ChatGPTService {
        @Value("${chatgpt.api.url}")
        private String apiUrl;
    
        @Value("${chatgpt.api.key}")
        private String apiKey;
    
        private final RestTemplate restTemplate;
    
        public ChatGPTService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }
    
        public String obterRespostaDoChatGPT(String pergunta) {
            
            String url = apiUrl + "?apiKey=" + apiKey + "&pergunta=" + pergunta;
    
            
            String resposta = restTemplate.getForObject(url, String.class);
    
            return resposta;
        }
    }

