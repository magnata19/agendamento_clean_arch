package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.FindScheduleByIdUseCase;

public class FindScheduleByIdImpl implements FindScheduleByIdUseCase {

    private final ScheduleGateway scheduleGateway;

    public FindScheduleByIdImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway;
    }

    @Override
    public Schedule execute(Long id) {
        Schedule schedule = scheduleGateway.findScheduleById(id);
        if(schedule == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
        return schedule;
    }
}
