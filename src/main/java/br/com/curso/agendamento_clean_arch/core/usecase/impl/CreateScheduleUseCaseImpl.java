package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.CreateScheduleUseCase;

public class CreateScheduleUseCaseImpl implements CreateScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public CreateScheduleUseCaseImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway;
    }

    @Override
    public Schedule execute(Schedule schedule) {
        return scheduleGateway.create(schedule);
    }
}
