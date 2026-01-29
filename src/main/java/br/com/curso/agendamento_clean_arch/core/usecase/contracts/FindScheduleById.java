package br.com.curso.agendamento_clean_arch.core.usecase.contracts;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;

public interface FindScheduleById {
    Schedule execute(Long id);
}
