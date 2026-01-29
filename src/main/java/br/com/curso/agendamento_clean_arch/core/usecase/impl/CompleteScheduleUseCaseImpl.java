package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.CompleteScheduleUseCase;

public class CompleteScheduleUseCaseImpl implements CompleteScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public CompleteScheduleUseCaseImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway;
    }

    @Override
    public Schedule execute(Long id) {
        if(scheduleGateway.findScheduleById(id) == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
        return scheduleGateway.completeSchedule(id);
    }
}
