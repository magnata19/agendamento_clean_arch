package br.com.curso.agendamento_clean_arch.infrastructure.persistence.repository;

import br.com.curso.agendamento_clean_arch.infrastructure.persistence.model.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
}
