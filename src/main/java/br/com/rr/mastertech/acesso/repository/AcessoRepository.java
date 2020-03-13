package br.com.rr.mastertech.acesso.repository;

import br.com.rr.mastertech.acesso.domain.Acesso;
import br.com.rr.mastertech.acesso.domain.AcessoIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepository extends JpaRepository<Acesso, AcessoIdentity> {
    //
}
