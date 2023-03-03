package be.vdab.sportwinkel.services;

import be.vdab.sportwinkel.domain.Artikel;
import be.vdab.sportwinkel.events.ArtikelGemaakt;
import be.vdab.sportwinkel.repositories.ArtikelRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ArtikelService {
    private final ArtikelRepository repository;
    private final AmqpTemplate template;

    public ArtikelService(ArtikelRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public void create(Artikel artikel) {
        repository.save(artikel);
        template.convertAndSend("sportartikels", null, new ArtikelGemaakt(artikel));
    }
}
