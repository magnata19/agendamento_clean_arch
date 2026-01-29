package br.com.curso.agendamento_clean_arch.core.usecase.impl;

import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.DeleteScheduleUseCase;

public class DeleteScheduleUseCaseImpl implements DeleteScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public DeleteScheduleUseCaseImpl(ScheduleGateway scheduleGateway) {
        this.scheduleGateway = scheduleGateway;
    }

    @Override
    public void execute(Long id) {
        if(scheduleGateway.findScheduleById(id) == null) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
        scheduleGateway.delete(id);
    }
}
