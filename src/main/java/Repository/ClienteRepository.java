package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
