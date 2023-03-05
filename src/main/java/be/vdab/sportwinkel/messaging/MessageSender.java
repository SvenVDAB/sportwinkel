package be.vdab.sportwinkel.messaging;

import be.vdab.sportwinkel.repositories.ArtikelGemaaktRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MessageSender {
    private final ArtikelGemaaktRepository repository;
    private final AmqpTemplate template;

    public MessageSender(ArtikelGemaaktRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Scheduled(fixedDelay = 5000)
    @Transactional
    void verstuurMessages() {
        var artikelsGemaakt = repository.findAll();
        artikelsGemaakt.forEach(
                gemaakt -> template.convertAndSend("sportartikels", null, gemaakt)
        );
        repository.deleteAllInBatch(artikelsGemaakt);
    }
}
