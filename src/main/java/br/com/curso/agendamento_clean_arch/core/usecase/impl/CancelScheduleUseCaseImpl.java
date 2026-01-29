package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.CancelScheduleUseCase;

public class CancelScheduleUseCaseImpl implements CancelScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public CancelScheduleUseCaseImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway;
    }

    @Override
    public Schedule execute(Long id) {
        if(scheduleGateway.findScheduleById(id) == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
        return scheduleGateway.cancelSchedule(id);
    }
}
