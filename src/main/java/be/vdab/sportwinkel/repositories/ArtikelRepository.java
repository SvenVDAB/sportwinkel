package be.vdab.sportwinkel.repositories;

import be.vdab.sportwinkel.domain.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtikelRepository extends JpaRepository<Artikel, Long> {
}
