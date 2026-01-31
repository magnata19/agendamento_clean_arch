package br.com.curso.agendamento_clean_arch.infrastructure.mappers;

import br.com.curso.agendamento_clean_arch.core.entities.Schedule;
import br.com.curso.agendamento_clean_arch.infrastructure.dtos.ScheduleResponse;
import org.springframework.stereotype.Component;

@Component
public class ScheduleResponseMapper {

    public ScheduleResponse toDto(Schedule schedule){
        return new ScheduleResponse(
                schedule.id(),
                schedule.title(),
                schedule.description(),
                schedule.initialDate(),
                schedule.finalDate(),
                schedule.status(),
                schedule.user(),
                schedule.createdAt(),
                schedule.updatedAt()
        );
    }

    public Schedule toEntity(ScheduleResponse dto){
        return new Schedule(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.initialDate(),
                dto.finalDate(),
                dto.status(),
                dto.user(),
                dto.createdAt(),
                dto.updatedAt()
        );
    }
}
