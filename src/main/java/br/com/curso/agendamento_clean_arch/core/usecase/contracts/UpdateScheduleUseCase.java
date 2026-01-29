package br.com.curso.agendamento_clean_arch.core.usecase.contracts;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;

public interface UpdateScheduleUseCase {
    Schedule execute(Schedule schedule);
}
