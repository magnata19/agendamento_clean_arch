package br.com.curso.agendamento_clean_arch.infrastructure.beans;

import br.com.curso.agendamento_clean_arch.core.gateway.ScheduleGateway;
import br.com.curso.agendamento_clean_arch.core.usecase.contracts.*;
import br.com.curso.agendamento_clean_arch.core.usecase.impl.*;
import br.com.curso.agendamento_clean_arch.infrastructure.gateways.ScheduleRepositoryGateway;
import br.com.curso.agendamento_clean_arch.infrastructure.mappers.ScheduleEntityMapper;
import br.com.curso.agendamento_clean_arch.infrastructure.persistence.repository.ScheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ScheduleGateway scheduleGateway(
            ScheduleRepository repository,
            ScheduleEntityMapper mapper
    ) {
        return new ScheduleRepositoryGateway(repository, mapper);
    }

    @Bean
    public CreateScheduleUseCase createScheduleUseCase(ScheduleGateway gateway) {
        return new CreateScheduleUseCaseImpl(gateway);
    }

    @Bean
    public FindScheduleByIdUseCase findScheduleByIdUseCase(ScheduleGateway gateway) {
        return new FindScheduleByIdImpl(gateway);
    }

    @Bean
    public CancelScheduleUseCase cancelScheduleUseCase(ScheduleGateway gateway) {
        return new CancelScheduleUseCaseImpl(gateway);
    }

    @Bean
    public CompleteScheduleUseCase completeScheduleUseCase(ScheduleGateway gateway) {
        return new CompleteScheduleUseCaseImpl(gateway);
    }

    @Bean
    public UpdateScheduleUseCase updateScheduleUseCase(ScheduleGateway gateway) {
        return new UpdateScheduleUseCaseImpl(gateway);
    }

    @Bean
    public DeleteScheduleUseCase deleteScheduleUseCase(ScheduleGateway gateway) {
        return new DeleteScheduleUseCaseImpl(gateway);
    }

}
