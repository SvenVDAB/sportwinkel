package be.vdab.sportwinkel.repositories;

import be.vdab.sportwinkel.events.ArtikelGemaakt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelGemaaktRepository extends JpaRepository<ArtikelGemaakt, Long> {
}
