package be.vdab.sportwinkel.restcontrollers;

import be.vdab.sportwinkel.domain.Artikel;
import be.vdab.sportwinkel.services.ArtikelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/artikels")
class ArtikelController {
    private final ArtikelService artikelService;

    ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void post(@RequestBody Artikel artikel) {
        artikelService.create(artikel);
    }
}
