package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.UpdateScheduleUseCase;

import java.time.LocalDateTime;

public class UpdateScheduleUseCaseImpl implements UpdateScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public UpdateScheduleUseCaseImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway; 
    }

    @Override
    public Schedule execute(Schedule schedule) {
        Schedule scheduleFounded = scheduleGateway.findScheduleById(schedule.id());
        if(scheduleFounded == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
        return scheduleGateway.update(new Schedule(
                scheduleFounded.id(),
                schedule.title(),
                schedule.description(),
                schedule.initialDate(),
                schedule.finalDate(),
                scheduleFounded.status(),
                scheduleFounded.user(),
                scheduleFounded.createdAt(),
                LocalDateTime.now()));
    }
}
